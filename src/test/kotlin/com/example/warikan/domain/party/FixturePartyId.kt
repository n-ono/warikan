package com.example.warikan.domain.party

class FixturePartyId {
    fun get(n: Int) = PartyId(n.toString().padStart(36, '0'))
}
