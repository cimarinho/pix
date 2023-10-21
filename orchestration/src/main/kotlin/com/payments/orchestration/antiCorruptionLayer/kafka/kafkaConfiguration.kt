package com.payments.orchestration.antiCorruptionLayer.kafka

import com.payments.orchestration.application.pix.receive.PixReceiveCommandHandler
import com.payments.orchestration.infrastructure.balance.validate.BalanceValidateEvent
import com.payments.orchestration.infrastructure.balance.validate.BalanceValidateSendEvent
import com.payments.orchestration.infrastructure.balance.validate.toCommand
import kotlinx.coroutines.reactor.mono
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.Message
import reactor.core.publisher.Flux
import java.util.function.Consumer
import java.util.function.Supplier

@Configuration
class kafkaConfiguration (
    private val balanceValidateSendEvent: BalanceValidateSendEvent,
    private val pixReceiveCommandHandler: PixReceiveCommandHandler,
) {

    @Bean
    fun orchestrationSendPix(): Supplier<Flux<Message<BalanceValidateEvent>>> = Supplier {
        balanceValidateSendEvent.getFlow().asFlux()
    }

    @Bean
    fun orchestrationReceivePix(): Consumer<Flux<Message<BalanceValidateEvent>>> = Consumer { stream ->
        stream.concatMap { msg ->
            println("payload fim ${msg.payload}")
            msg.headers.forEach{
                println("header $it")
            }
            val header = msg.headers["correlation_id"] ?: "nao veio"
            mono {   pixReceiveCommandHandler.handle(msg.payload.toCommand(header.toString())) }
        }.onErrorContinue { e, _ ->
            e.printStackTrace()
        }.subscribe()
    }
}