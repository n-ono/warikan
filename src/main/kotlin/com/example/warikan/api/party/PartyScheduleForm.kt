package com.example.warikan.api.party

import com.example.warikan.domain.party.PartyHoldingDateTime
import com.example.warikan.domain.party.PartyName
import io.swagger.annotations.ApiModelProperty
import org.hibernate.validator.constraints.Length
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.Pattern

class PartyScheduleForm(
    @ApiModelProperty(value = "飲み会の名前", example = "", position = 0)
    @Length(min = 1, max = 40)
    private val partyName: String,
    @ApiModelProperty(value = "飲み会の開催日時", example = "2020-01-01 19:00", position = 1)
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")
    private val partyHoldingDateTime: String
) {
    fun getPartyName() = PartyName(partyName)

    fun getPartyHoldingDateTime(): PartyHoldingDateTime {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        return PartyHoldingDateTime.from(LocalDateTime.parse(partyHoldingDateTime, formatter))
    }
}
