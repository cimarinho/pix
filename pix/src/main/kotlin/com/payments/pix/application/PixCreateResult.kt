package com.payments.pix.application

import com.payments.pix.antiCorruptionLayer.PixCreateEvent
import java.util.*
import javax.money.MonetaryAmount

data class PixCreateResult(
    val correlationId: UUID,
    val name: String,
    val quantity: Int,
    val amount: MonetaryAmount,
)

fun PixCreateResult.toEvent() : PixCreateEvent = PixCreateEvent(
    correlationId = correlationId,
    name = name,
    quantity = quantity,
    amount = amount,
)