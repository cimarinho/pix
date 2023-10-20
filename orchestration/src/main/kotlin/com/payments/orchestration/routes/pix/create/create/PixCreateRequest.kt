package com.payments.orchestration.routes.pix.create.create

import com.fasterxml.jackson.annotation.JsonProperty
import javax.money.MonetaryAmount


data class PixCreateRequest(
    @JsonProperty("name") var name: String,
    @JsonProperty("quantity") var quantity: Int,
    @JsonProperty("amount") var amount: MonetaryAmount,
)


