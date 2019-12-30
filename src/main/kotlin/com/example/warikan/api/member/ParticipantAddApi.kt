package com.example.warikan.api.member

import com.example.warikan.service.member.MemberService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/participant/add")
@Api("参加者を追加する")
class ParticipantAddApi(private val memberService: MemberService) {
    @PostMapping
    @ApiOperation("参加者を追加する")
    fun register(
        @Validated @RequestBody participantAddForm: ParticipantAddForm
    ) = memberService.addParticipant(
        participantAddForm.getPartyId(),
        participantAddForm.getParticipantName(),
        participantAddForm.getPaymentType()
    ).asString()
}
