package com.payments.orchestration.infrastructure.pix.receiveEvent

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.stereotype.Component
import java.time.Duration
import java.util.*
import org.springframework.kafka.support.serializer.JsonSerializer

@Component
class PixReceiveEvent {

    fun receive(correlationId: String) {
        println("teste")
        val props = Properties()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "localhost:9092"
        props[ConsumerConfig.GROUP_ID_CONFIG] = "uuid"
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = "latest"
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java.name

        val consumer = KafkaConsumer<String, String>(props)
        consumer.subscribe(listOf("saga_consumer_topic"))

        var shouldExit = false

        println("consumer")
        consumer.use { consumer ->
            while (!shouldExit) {
                val records = consumer.poll(Duration.ofMillis(200)) // Faça a leitura das mensagens
                println("while")
                for (record in records) {
                    println("Chave: ${record.key()}, Valor: ${record.value()} Header ${record.headers()} ")
                    val correlationIdHeader = record.headers().lastHeader("correlation_id")
                    if (correlationIdHeader != null) {
                        val receivedCorrelationId = String(correlationIdHeader.value())
                        println("correlationId $receivedCorrelationId ")
                        if (receivedCorrelationId == correlationId) {
                            shouldExit = true
                            break
                        }
                    }
                }
                Thread.sleep(1000)
            }
        }

    }
}