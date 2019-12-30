package com.example.warikan.domain.member

enum class PaymentType(
    val weight: PaymentWeight
) {
    PLUS(PaymentWeight(5)),
    DEFAULT(PaymentWeight(4)),
    MINUS(PaymentWeight(3));
}
