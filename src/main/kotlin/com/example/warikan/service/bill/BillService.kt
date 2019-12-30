package com.example.warikan.service.bill

import com.example.warikan.domain.bill.BillIssueService
import com.example.warikan.domain.bill.TotalBillingAmount
import com.example.warikan.domain.member.MemberRepository
import com.example.warikan.domain.party.PartyId
import org.springframework.stereotype.Service

@Service
class BillService(private val memberRepository: MemberRepository) {
    fun issue(partyId: PartyId, totalBillingAmount: TotalBillingAmount) =
        BillIssueService(totalBillingAmount, memberRepository.allMembers(partyId)).issue()
}
