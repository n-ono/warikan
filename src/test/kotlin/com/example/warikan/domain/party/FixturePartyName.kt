package com.example.warikan.domain.party

class FixturePartyName {
    private var partyName = PartyName("飲み会")

    fun get() = partyName

    fun name(s: String): FixturePartyName {
        partyName = PartyName(s)
        return this
    }
}
