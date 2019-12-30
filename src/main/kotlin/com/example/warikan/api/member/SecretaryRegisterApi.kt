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
@RequestMapping("/api/secretary/register")
@Api("幹事を登録する")
class SecretaryRegisterApi(private val memberService: MemberService) {
    @PostMapping
    @ApiOperation("幹事を登録する")
    fun register(
        @Validated @RequestBody secretaryRegisterForm: SecretaryRegisterForm
    ) = memberService.addSecretary(
        secretaryRegisterForm.getPartyId(),
        secretaryRegisterForm.getSecretaryName(),
        secretaryRegisterForm.getPaymentType()
    ).asString()
}
