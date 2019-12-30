package com.example.warikan.domain.bill

data class Bill(
    val billTo: List<BillTo>,
    val balanceDue: BalanceDue
)
