package com.payments.pix.application

import com.payments.buildingBlock.application.Query
import com.payments.pix.antiCorruptionLayer.PixCreateEvent
import java.util.*
import javax.money.MonetaryAmount

data class PixCreateQuery (
    override val correlationId: UUID,
    val name: String,
    val quantity: Int,
    val amount: MonetaryAmount,
) : Query<PixCreateResult>