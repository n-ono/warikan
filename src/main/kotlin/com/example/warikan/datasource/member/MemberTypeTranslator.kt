package com.example.warikan.datasource.member

import com.example.warikan.domain.member.MemberType
import java.lang.RuntimeException

class MemberTypeTranslator {
    companion object {
        fun translate(value: String) = when (value) {
            "participant" -> MemberType.PARTICIPANT
            "secretary" -> MemberType.SECRETARY
            else -> throw RuntimeException("unknown value: $value")
        }

        fun translate(memberType: MemberType) = when (memberType) {
            MemberType.PARTICIPANT -> "participant"
            MemberType.SECRETARY -> "secretary"
        }
    }
}