package com.example.warikan.domain.member

data class MemberId(
    private val value: String
) {
    fun asString() = value
}
