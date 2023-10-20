package com.payments.orchestration.infrastructure.balance.validate

import com.payments.buildingBlock.infrastructure.Event
import java.util.*
import javax.money.MonetaryAmount

class BalanceValidateEvent (
    override val correlationId: UUID,
    val name: String,
    val quantity: Int,
    val amount: MonetaryAmount,
) : Event
