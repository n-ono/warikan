package com.example.warikan.domain.bill

data class TotalBillingAmount(val value: Int) {
    operator fun times(billingProportion: BillingProportion) =
        BillingAmount((value * billingProportion.value()).toInt())

    operator fun minus(billingAmount: BillingAmount): BalanceDue {
        val amount = value - billingAmount.value()
        if (isPositive(amount)) {
            return BalanceDue(amount)
        } else {
            throw RuntimeException("failed subtraction: $value, ${billingAmount.value()}")
        }
    }

    private fun isPositive(value: Int) = 0 <= value
}
