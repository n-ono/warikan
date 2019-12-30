package com.example.warikan.datasource.member

import com.example.warikan.domain.member.PaymentType
import java.lang.RuntimeException

class PaymentTypeTranslator {
    companion object {
        fun translate(value: String) = when (value) {
            "plus" -> PaymentType.PLUS
            "default" -> PaymentType.DEFAULT
            "minus" -> PaymentType.MINUS
            else -> throw RuntimeException("unknown value: $value")
        }

        fun translate(paymentType: PaymentType) = when (paymentType) {
            PaymentType.PLUS -> "plus"
            PaymentType.DEFAULT -> "default"
            PaymentType.MINUS -> "minus"
        }
    }
}
