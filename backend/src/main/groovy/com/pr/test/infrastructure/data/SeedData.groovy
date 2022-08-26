package com.pr.test.infrastructure.data

import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
