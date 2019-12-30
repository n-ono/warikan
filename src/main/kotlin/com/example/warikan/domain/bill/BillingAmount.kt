package com.example.warikan.domain.bill

data class BillingAmount(
    private var value: Int
) {
    init {
        value -= (value % 500)
    }

    fun value() = value

    operator fun plus(billingAmount: BillingAmount) =
        BillingAmount(value + billingAmount.value)
}
