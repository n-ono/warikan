package com.example.warikan.domain.member

class FixtureMemberId {
    fun get(n: Int) = MemberId(n.toString().padStart(36, '0'))
}
