package com.payments.orchestration.antiCorruptionLayer.kafka

import com.payments.orchestration.infrastructure.balance.validate.BalanceValidateEvent
import com.payments.orchestration.infrastructure.balance.validate.BalanceValidateSendEvent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import reactor.core.publisher.Flux
import java.util.function.Supplier

@Configuration
class kafkaConfiguration constructor(
    private val balanceValidateSendEvent: BalanceValidateSendEvent,
) {

    @Bean
    fun orchestrationSendOrder(): Supplier<Flux<Message<BalanceValidateEvent>>> = Supplier {
        balanceValidateSendEvent.getProducer().asFlux()
    }
}