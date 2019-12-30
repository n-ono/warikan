package com.example.warikan.domain.member

data class PaymentWeight(
    val value: Int
) {
    operator fun plus(paymentWeight: PaymentWeight) =
        PaymentWeight(value + paymentWeight.value)
}
