package com.example.warikan.domain.member

import com.example.warikan.domain.member.extension.sum

data class Members(
    private val members: List<Member>
) {
    init {
        val hasSecretary = members.any { it.isSecretary() }
        if (!hasSecretary) {
            throw RuntimeException("failed construct members: no secretary")
        }
        val hasMember = members.any { it.isParticipant() }
        if (!hasMember) {
            throw RuntimeException("failed construct members: no participant")
        }
    }

    fun allMembers() =  members

    fun totalPaymentWeight() = members.map { it.paymentWeight() }.sum()
}
