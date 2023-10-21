package com.payments.pix.antiCorruptionLayer

import com.payments.pix.application.PixCreateCommandHandler
import com.payments.pix.application.toEvent
import kotlinx.coroutines.reactor.mono
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import reactor.core.publisher.Flux
import java.util.function.Function

@Configuration
class PixKafkaReceiveOrder(
    private val pixCreateCommandHandler: PixCreateCommandHandler,
) {

    @Bean
    fun createPix(): Function<Flux<Message<PixCreateEvent>>, Flux<Message<PixCreateEvent>>> =
        Function { stream ->
            stream.concatMap {
                println("pixCreateCommandHandler correlationID ${it.payload.correlationId}")
                mono {
                    val result = pixCreateCommandHandler.handle(it.payload.toCommand())
                    result.toEvent()
                }
            }.map {
                MessageBuilder.withPayload(it).build()
            }
        }

}