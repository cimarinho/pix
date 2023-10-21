package com.payments.buildingBlock.infrastructure

import java.util.*

interface Event {
    val correlationId: UUID
    fun getCorrelationId(): String = correlationId.toString()
}