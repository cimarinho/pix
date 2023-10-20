package com.payments.orchestration.application.balance.validate

import com.payments.buildingBlock.application.Command
import com.payments.orchestration.infrastructure.balance.validate.BalanceValidateEvent
import java.util.*
import javax.money.MonetaryAmount

class BalanceValidateCommand(
    override val correlationId: UUID,
    val name: String,
    val quantity: Int,
    val amount: MonetaryAmount,
) : Command


fun BalanceValidateCommand.toEvent(): BalanceValidateEvent = BalanceValidateEvent(
    correlationId = correlationId,
    name = name,
    quantity = quantity,
    amount = amount,
)