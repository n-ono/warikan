package com.example.warikan.domain.bill

import com.example.warikan.domain.member.FixtureMember
import com.example.warikan.domain.member.MemberName
import com.example.warikan.domain.member.Members
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
internal class BillIssueServiceTest {

    @Test
    @Transactional
    fun allDefault() {
        val totalBillingAmount = TotalBillingAmount(20000)
        val members = Members(
            listOf(
                FixtureMember().memberId(1).memberName("john").asSecretary(),
                FixtureMember().memberId(2).memberName("alice").asParticipant(),
                FixtureMember().memberId(3).memberName("bob").asParticipant(),
                FixtureMember().memberId(4).memberName("mike").asParticipant()
            )
        )
        val expected = Bill(
            listOf(
                BillTo(MemberName("john"), BillingAmount(5000)),
                BillTo(MemberName("alice"), BillingAmount(5000)),
                BillTo(MemberName("bob"), BillingAmount(5000)),
                BillTo(MemberName("mike"), BillingAmount(5000))
            ),
            BalanceDue(0)
        )

        val actual = BillIssueService(totalBillingAmount, members).issue()

        assertEquals(expected, actual)
    }

    @Test
    @Transactional
    fun allPaymentTypes() {
        val totalBillingAmount = TotalBillingAmount(20000)
        val members = Members(
            listOf(
                FixtureMember().memberId(1).memberName("john").asSecretary(),
                FixtureMember().memberId(2).memberName("alice").minus().asParticipant(),
                FixtureMember().memberId(3).memberName("bob").plus().asParticipant(),
                FixtureMember().memberId(4).memberName("mike").plus().asParticipant()
            )
        )
        val expected = Bill(
            listOf(
                BillTo(MemberName("john"), BillingAmount(4500)),
                BillTo(MemberName("alice"), BillingAmount(3500)),
                BillTo(MemberName("bob"), BillingAmount(5500)),
                BillTo(MemberName("mike"), BillingAmount(5500))
            ),
            BalanceDue(1000)
        )

        val actual = BillIssueService(totalBillingAmount, members).issue()

        assertEquals(expected, actual)
    }
}
