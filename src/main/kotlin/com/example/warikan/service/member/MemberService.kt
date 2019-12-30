package com.example.warikan.service.member

import com.example.warikan.domain.member.PaymentType
import com.example.warikan.domain.member.Member
import com.example.warikan.domain.member.MemberId
import com.example.warikan.domain.member.MemberName
import com.example.warikan.domain.member.MemberRepository
import com.example.warikan.domain.party.PartyId
import org.springframework.stereotype.Service

@Service
class MemberService(private val memberRepository: MemberRepository) {
    fun addSecretary(partyId: PartyId, memberName: MemberName, paymentType: PaymentType): MemberId {
        val memberId = memberRepository.nextIdentity()
        memberRepository.participate(Member.asSecretary(memberId, partyId, memberName, paymentType))
        return memberId
    }

    fun addParticipant(
        partyId: PartyId,
        memberName: MemberName,
        paymentType: PaymentType
    ): MemberId {
        val memberId = memberRepository.nextIdentity()
        memberRepository.participate(Member.asParticipant(memberId, partyId, memberName, paymentType))
        return memberId
    }
}
