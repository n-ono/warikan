package com.example.warikan.api.party

import com.example.warikan.service.party.PartyService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/party/schedule")
@Api("飲み会を予定する")
class PartyScheduleApi(private val partyService: PartyService) {
    @PostMapping
    @ApiOperation("飲み会を予定する")
    fun schedule(
        @Validated @RequestBody partyScheduleForm: PartyScheduleForm
    ) = partyService.schedule(partyScheduleForm.getPartyName(), partyScheduleForm.getPartyHoldingDateTime()).asString()
}
