package com.example.warikan.domain.member

enum class MemberType {
    PARTICIPANT, SECRETARY;

    fun isParticipant() = this == PARTICIPANT

    fun isSecretary() = this == SECRETARY
}
