package com.example.warikan.domain.bill

import com.example.warikan.domain.member.PaymentWeight

data class BillingProportion(
    private val numerator: PaymentWeight,
    private val denominator: PaymentWeight
) {
    fun value() = numerator.value.toDouble() / denominator.value
}
