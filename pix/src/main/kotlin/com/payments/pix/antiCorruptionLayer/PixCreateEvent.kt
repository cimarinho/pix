package com.payments.pix.antiCorruptionLayer

import com.payments.buildingBlock.infrastructure.Event
import com.payments.pix.application.PixCreateQuery
import java.util.*
import javax.money.MonetaryAmount

class PixCreateEvent(
    override val correlationId: UUID,
    val name: String,
    val quantity: Int,
    val amount: MonetaryAmount,
) : Event

fun PixCreateEvent.toCommand(): PixCreateQuery = PixCreateQuery(
    name = name,
    quantity = quantity,
    amount = amount,
    correlationId = correlationId,
)
