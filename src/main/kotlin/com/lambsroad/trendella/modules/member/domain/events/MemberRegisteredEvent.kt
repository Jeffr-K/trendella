package com.lambsroad.trendella.modules.member.domain.events

data class MemberRegisteredEvent(val username: String, val email: String) {}
