package com.example.warikan.domain.member

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class MembersTest {
    @Test
    fun throwsUnlessSecretaryExists() {
        val participants = listOf(
            FixtureMember().memberId(1).memberName("alice").asParticipant(),
            FixtureMember().memberId(2).memberName("bob").asParticipant()
        )

        assertThrows<RuntimeException> { Members(participants) }
    }

    @Test
    fun throwsUnlessParticipantExists() {
        val secretary = listOf(
            FixtureMember().memberId(1).memberName("alice").asSecretary()
        )

        assertThrows<RuntimeException> { Members(secretary) }
    }

    @Test
    fun canGetTotalPaymentWeight() {
        val members = Members(
            listOf(
                FixtureMember().memberId(1).memberName("alice").minus().asSecretary(),
                FixtureMember().memberId(2).memberName("bob").plus().asParticipant(),
                FixtureMember().memberId(3).memberName("john").asParticipant()
            )
        )

        val totalPaymentWeight = members.totalPaymentWeight()

        assert(totalPaymentWeight == PaymentWeight(12))
    }
}