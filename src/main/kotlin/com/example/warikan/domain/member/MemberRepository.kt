package com.example.warikan.domain.member

import com.example.warikan.domain.party.PartyId

interface MemberRepository {
    fun nextIdentity(): MemberId
    fun participate(member: Member)
    fun findById(memberId: MemberId): Member
    fun allMembers(partyId: PartyId): Members
}
