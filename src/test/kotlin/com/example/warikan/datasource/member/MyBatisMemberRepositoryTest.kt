package com.example.warikan.datasource.member

import com.example.warikan.domain.member.FixtureMember
import com.example.warikan.domain.member.MemberRepository
import com.example.warikan.domain.party.FixtureParty
import com.example.warikan.domain.party.PartyRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
internal class MyBatisMemberRepositoryTest {
    @Autowired
    private lateinit var memberRepository: MemberRepository

    @Autowired
    private lateinit var partyRepository: PartyRepository

    @BeforeEach
    fun setup() {
        partyRepository.schedule(FixtureParty().get())
    }

    @Test
    @Transactional
    fun canParticipateIfParticipantNotRegistered() {
        val participant = FixtureMember().asParticipant()

        memberRepository.participate(participant)
        val found = memberRepository.findById(participant.memberId)

        assertEquals(found, participant)
    }

    @Test
    @Transactional
    fun throwExceptionIfParticipantAlreadyRegistered() {
        val participant = FixtureMember().asParticipant()

        memberRepository.participate(participant)

        assertThrows<RuntimeException> {
            memberRepository.participate(participant)
        }

    }
}
