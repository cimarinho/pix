package com.payments.pix.application

import java.util.*
import javax.money.MonetaryAmount

data class PixCreateResult(
    val correlationId: UUID,
    val name: String,
    val quantity: Int,
    val amount: MonetaryAmount,
)