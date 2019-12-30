package com.example.warikan.domain.party

data class PartyId(
    private val value: String
) {
    fun asString() = value
}
