package com.example.warikan.domain.party

import java.time.Month

class FixturePartyHoldingDateTime {
    private var partyHoldingDateTime = PartyHoldingDateTime.of(2020, Month.JANUARY, 17, 19, 0)

    fun get() = partyHoldingDateTime
}
