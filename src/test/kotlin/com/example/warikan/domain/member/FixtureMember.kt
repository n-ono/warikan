package com.example.warikan.domain.member

import com.example.warikan.domain.party.FixturePartyId

class FixtureMember {
    private var memberId = FixtureMemberId().get(1)
    private var partyId = FixturePartyId().get(1)
    private var memberName = MemberName("test-member")
    private var paymentType = PaymentType.DEFAULT

    fun asParticipant() = Member.asParticipant(memberId, partyId, memberName, paymentType)

    fun asSecretary() = Member.asSecretary(memberId, partyId, memberName, paymentType)

    fun memberId(value: Int): FixtureMember {
        memberId = FixtureMemberId().get(value)
        return this;
    }

    fun partyId(value: Int): FixtureMember {
        partyId = FixturePartyId().get(value)
        return this
    }

    fun memberName(value: String): FixtureMember {
        memberName = MemberName(value)
        return this
    }

    fun plus(): FixtureMember {
        paymentType = PaymentType.PLUS
        return this
    }

    fun minus(): FixtureMember {
        paymentType = PaymentType.MINUS
        return this
    }
}
