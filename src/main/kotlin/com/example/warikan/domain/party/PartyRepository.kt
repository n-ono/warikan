package com.example.warikan.domain.party

interface PartyRepository {
    fun nextIdentity(): PartyId
    fun schedule(party: Party): PartyId
}
