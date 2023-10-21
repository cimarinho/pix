package com.payments.orchestration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.payments.orchestration","com.payments.pix"])
open class KotlinSagaApllication

fun main() {

    runApplication<KotlinSagaApllication>()

}


