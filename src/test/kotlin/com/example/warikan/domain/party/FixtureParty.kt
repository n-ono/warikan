package com.example.warikan.domain.party

class FixtureParty {
    private var partyId = FixturePartyId().get(1)
    private var partyName = FixturePartyName().get()
    private var partyHoldingDateTime = FixturePartyHoldingDateTime().get()

    fun get() = Party(partyId, partyName, partyHoldingDateTime)
}
