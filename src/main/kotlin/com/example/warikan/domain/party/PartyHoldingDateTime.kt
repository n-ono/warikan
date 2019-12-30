package com.example.warikan.domain.party

import java.time.LocalDateTime
import java.time.Month

data class PartyHoldingDateTime private constructor(
    private val value: LocalDateTime
) {
    companion object {
        fun from(localDateTime: LocalDateTime) = PartyHoldingDateTime(localDateTime)

        fun of(year: Int, month: Month, dayOfMonth: Int, hour: Int, minute: Int) =
            PartyHoldingDateTime(LocalDateTime.of(year, month, dayOfMonth, hour, minute))
    }

    fun asLocalDateTime() = value
}