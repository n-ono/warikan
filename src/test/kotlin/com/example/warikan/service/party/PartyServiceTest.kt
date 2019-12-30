package com.example.warikan.service.party

import com.example.warikan.domain.party.FixturePartyHoldingDateTime
import com.example.warikan.domain.party.FixturePartyName
import com.example.warikan.domain.party.PartyRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class PartyServiceTest {
    @Autowired
    private lateinit var partyRepository: PartyRepository

    @Test
    fun canScheduleParty() {
        val partyName = FixturePartyName().get()
        val partyHoldingDateTime = FixturePartyHoldingDateTime().get()

        val partyId = PartyService(partyRepository).schedule(partyName, partyHoldingDateTime)

        assertNotNull(partyId)
    }
}
