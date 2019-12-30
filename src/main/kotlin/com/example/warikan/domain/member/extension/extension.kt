package com.example.warikan.domain.member.extension

import com.example.warikan.domain.member.PaymentWeight

internal fun List<PaymentWeight>.sum(): PaymentWeight {
    var paymentWeight = PaymentWeight(0)
    for (element in this) {
        paymentWeight += element
    }
    return paymentWeight
}
