package com.payments.orchestration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@ComponentScan(basePackages = ["com.saga.presenter","com.saga.order","com.saga.inventory","com.saga.orchestration"])
open class KotlinSagaApllication

fun main() {

    runApplication<KotlinSagaApllication>()

}


