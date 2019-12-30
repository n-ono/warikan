package com.example.warikan.domain.party

data class PartyName(
    private val value: String
) {
    fun asString() = value
}
