package com.lambsroad.trendella.modules.notification.domain.events

import com.lambsroad.trendella.modules.member.domain.events.MemberRegisteredEvent
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

@Component
class MemberRegisteredEventHandler {

    @Async
    @EventListener
    fun handle(event: MemberRegisteredEvent) {}
}
