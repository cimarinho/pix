package com.payments.orchestration.infrastructure.balance.validate

import com.payments.buildingBlock.infrastructure.Event
import com.payments.orchestration.application.pix.receive.PixReceiveCommand
import java.util.*
import javax.money.MonetaryAmount

class BalanceValidateEvent (
    override val correlationId: UUID,
    val name: String,
    val quantity: Int,
    val amount: MonetaryAmount,
) : Event


fun BalanceValidateEvent.toCommand(header: String): PixReceiveCommand = PixReceiveCommand(
    name = name,
    quantity = quantity,
    amount = amount,
    correlationId = correlationId,
    header = header,
)