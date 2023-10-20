package com.payments.buildingBlock.application


import java.util.*

interface Query<out TResult> {
    val correlationId: UUID
}