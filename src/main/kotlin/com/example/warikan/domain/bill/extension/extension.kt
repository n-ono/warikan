package com.example.warikan.domain.bill.extension

import com.example.warikan.domain.bill.BillingAmount

internal fun List<BillingAmount>.sum(): BillingAmount {
    var billingAmount = BillingAmount(0)
    for (element in this) {
        billingAmount += element
    }
    return billingAmount
}
