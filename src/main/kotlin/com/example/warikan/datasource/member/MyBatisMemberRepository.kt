package com.example.warikan.datasource.member

import com.example.warikan.domain.member.Member
import com.example.warikan.domain.member.MemberId
import com.example.warikan.domain.member.MemberRepository
import com.example.warikan.domain.member.Members
import com.example.warikan.domain.party.PartyId
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MyBatisMemberRepository(private val mapper: MemberRepositoryMapper) : MemberRepository {
    override fun nextIdentity(): MemberId =
        MemberId(UUID.randomUUID().toString())

    override fun findById(memberId: MemberId) =
        mapper.findById(memberId.asString()).toDomainObject()

    override fun participate(member: Member) =
        mapper.participate(
            member.memberId.asString(),
            member.partyId.asString(),
            member.name.asString(),
            PaymentTypeTranslator.translate(member.paymentType),
            MemberTypeTranslator.translate(member.memberType)
        )

    override fun allMembers(partyId: PartyId): Members {
        val members = mapper.allMembers(partyId.asString()).map { it.toDomainObject() }
        return Members(members)
    }
}
