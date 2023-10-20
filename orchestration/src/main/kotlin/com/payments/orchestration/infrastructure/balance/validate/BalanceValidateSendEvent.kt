package com.payments.orchestration.infrastructure.balance.validate

import com.payments.buildingBlock.infrastructure.EventSend
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component
import reactor.core.publisher.Sinks

@Component
class BalanceValidateSendEvent (

) : EventSend<BalanceValidateEvent> {

    private val unicastProcessor = Sinks.many().unicast().onBackpressureBuffer<Message<BalanceValidateEvent>>()

    fun getProducer() = unicastProcessor

    override fun send(event: BalanceValidateEvent) {
        val message = MessageBuilder.withPayload(event).setHeader("correlation_id",event.correlationId).build()
        unicastProcessor.emitNext(message, Sinks.EmitFailureHandler.FAIL_FAST)
        println("==FOI")
    }
}