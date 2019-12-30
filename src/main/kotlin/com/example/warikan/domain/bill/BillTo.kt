package com.example.warikan.domain.bill

import com.example.warikan.domain.member.MemberName

data class BillTo(
    val memberName: MemberName,
    val billingAmount: BillingAmount
)
