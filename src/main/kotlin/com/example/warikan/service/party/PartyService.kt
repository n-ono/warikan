package com.example.warikan.service.party

import com.example.warikan.domain.party.*
import org.springframework.stereotype.Service

@Service
class PartyService(private val partyRepository: PartyRepository) {
    fun schedule(partyName: PartyName, partyHoldingDateTime: PartyHoldingDateTime): PartyId {
        val partyId = partyRepository.nextIdentity()
        partyRepository.schedule(Party(partyId, partyName, partyHoldingDateTime))
        return partyId
    }
}
