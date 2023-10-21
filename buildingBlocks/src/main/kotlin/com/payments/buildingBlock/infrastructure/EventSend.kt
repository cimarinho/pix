package com.payments.buildingBlock.infrastructure

import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import reactor.core.publisher.Sinks

abstract class EventSend<T: Event>  {

    val unicastProcessor = Sinks.many().unicast().onBackpressureBuffer<Message<T>>()

    fun getFlow() = unicastProcessor
    abstract fun send(event: T)

    fun sendMessage(event: T)  {
        val message =  MessageBuilder.withPayload(event).setHeader("correlation_id",event.getCorrelationId()).build()
        unicastProcessor.emitNext(message, Sinks.EmitFailureHandler.FAIL_FAST)
    }
}