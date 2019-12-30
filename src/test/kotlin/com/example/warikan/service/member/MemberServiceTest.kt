package com.example.warikan.service.member

import com.example.warikan.domain.member.MemberName
import com.example.warikan.domain.member.MemberRepository
import com.example.warikan.domain.member.PaymentType
import com.example.warikan.domain.party.FixtureParty
import com.example.warikan.domain.party.PartyRepository
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
internal class MemberServiceTest {
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
    fun canAddMemberAsSecretary() {
        val memberName = MemberName("alice")

        val secretaryMemberId =
            MemberService(memberRepository).addSecretary(FixtureParty().get().id, memberName, PaymentType.DEFAULT)

        assertNotNull(secretaryMemberId)
    }

    @Test
    @Transactional
    fun canAddMemberAsParticipant() {
        val memberName = MemberName("alice")

        val participantId = MemberService(memberRepository).addParticipant(
            FixtureParty().get().id,
            memberName,
            PaymentType.DEFAULT
        )

        assertNotNull(participantId)
    }
}
