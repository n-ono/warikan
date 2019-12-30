package com.example.warikan.domain.bill

import com.example.warikan.domain.bill.extension.sum
import com.example.warikan.domain.member.Member
import com.example.warikan.domain.member.Members

class BillIssueService(
    private val totalBillingAmount: TotalBillingAmount,
    private val members: Members
) {
    fun issue(): Bill {
        val billTo = issueBillTo()
        return Bill(
            billTo,
            calculateBalanceDue(billTo)
        )
    }

    private fun issueBillTo() =
        members.allMembers().map {
            BillTo(
                it.name,
                totalBillingAmount * calculateBillingPortionOf(it)
            )
        }

    private fun calculateBillingPortionOf(member: Member) =
        BillingProportion(member.paymentWeight(), members.totalPaymentWeight())

    private fun calculateBalanceDue(billTo: List<BillTo>) =
        totalBillingAmount - billTo.map { it.billingAmount }.sum()
}

