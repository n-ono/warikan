package com.example.warikan.domain.member

data class MemberName(
    private val value: String
) {
    fun asString() = value
}
