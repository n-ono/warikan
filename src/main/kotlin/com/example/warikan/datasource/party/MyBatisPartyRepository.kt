package com.example.warikan.datasource.party

import com.example.warikan.domain.party.Party
import com.example.warikan.domain.party.PartyId
import com.example.warikan.domain.party.PartyRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class MyBatisPartyRepository(private val mapper: PartyRepositoryMapper) : PartyRepository {
    override fun nextIdentity() = PartyId(UUID.randomUUID().toString())

    override fun schedule(party: Party): PartyId {
        mapper.schedule(party.id.asString(), party.name.asString(), party.holdingDateTime.asLocalDateTime())
        return party.id
    }
}