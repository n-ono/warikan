package com.example.warikan.api.member

import com.example.warikan.domain.member.PaymentType
import com.example.warikan.domain.member.MemberName
import com.example.warikan.domain.party.PartyId
import io.swagger.annotations.ApiModelProperty
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Pattern

class SecretaryRegisterForm(
    @ApiModelProperty(value = "飲み会の識別子", example = "", position = 0)
    @Length(min = 1, max = 36)
    private val partyId: String,
    @ApiModelProperty(value = "幹事の名前", example = "", position = 1)
    @Length(min = 1, max = 40)
    private val secretaryName: String,
    @ApiModelProperty(value = "支払い区分", example = "plus / default / minus", position = 2)
    @Pattern(regexp = "(plus|default|minus)")
    private val paymentType: String
) {
    fun getPartyId() = PartyId(partyId)

    fun getSecretaryName() = MemberName(secretaryName)

    fun getPaymentType() = when (paymentType) {
        "plus" -> PaymentType.PLUS
        "minus" -> PaymentType.MINUS
        else -> PaymentType.DEFAULT
    }
}
