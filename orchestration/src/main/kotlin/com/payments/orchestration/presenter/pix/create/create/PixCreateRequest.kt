package com.payments.orchestration.presenter.pix.create.create

import com.fasterxml.jackson.annotation.JsonProperty
import com.payments.orchestration.application.balance.validate.BalanceValidateCommand
import java.util.*
import javax.money.MonetaryAmount


data class PixCreateRequest(
    @JsonProperty("name") var name: String,
    @JsonProperty("quantity") var quantity: Int,
    @JsonProperty("amount") var amount: MonetaryAmount,
)

fun PixCreateRequest.toCommand(correlationId: UUID): BalanceValidateCommand = BalanceValidateCommand(
    correlationId = correlationId,
    name = name,
    quantity = quantity,
    amount = amount,
)