package com.example.warikan.domain.member

import com.example.warikan.domain.party.PartyId

data class Member private constructor(
    val memberId: MemberId,
    val partyId: PartyId,
    val name: MemberName,
    val paymentType: PaymentType,
    val memberType: MemberType
) {
    companion object {
        fun asParticipant(memberId: MemberId, partyId: PartyId, memberName: MemberName, paymentType: PaymentType) =
            Member(memberId, partyId, memberName, paymentType, MemberType.PARTICIPANT)

        fun asSecretary(memberId: MemberId, partyId: PartyId, memberName: MemberName, paymentType: PaymentType) =
            Member(memberId, partyId, memberName, paymentType, MemberType.SECRETARY)
    }

    fun isSecretary() = memberType.isSecretary()

    fun isParticipant() = memberType.isParticipant()

    fun paymentWeight() = paymentType.weight
}
