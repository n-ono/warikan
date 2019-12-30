package com.example.warikan.datasource.member

import com.example.warikan.domain.member.Member
import com.example.warikan.domain.member.MemberId
import com.example.warikan.domain.member.MemberName
import com.example.warikan.domain.party.PartyId

data class MemberDao(
    val memberId: String,
    val partyId: String,
    val memberName: String,
    val paymentType: String,
    val memberType: String
) {
    fun toDomainObject() = when (memberType) {
        "secretary" -> Member.asSecretary(
            MemberId(memberId),
            PartyId(partyId),
            MemberName(memberName),
            PaymentTypeTranslator.translate(paymentType)
        )
        "participant" -> Member.asParticipant(
            MemberId(memberId),
            PartyId(partyId),
            MemberName(memberName),
            PaymentTypeTranslator.translate(paymentType)
        )
        else -> throw RuntimeException("unknown member-type: $memberType")
    }
}
