package com.payments.orchestration.application.pix.receive

import com.payments.buildingBlock.application.Command
import java.util.*
import javax.money.MonetaryAmount

data class PixReceiveCommand(
    override val correlationId: UUID,
    val header: String,
    val name: String,
    val quantity: Int,
    val amount: MonetaryAmount,
) : Command