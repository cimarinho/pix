package com.payments.buildingBlock.application


import java.util.*

interface ResultCommand<out Result> {
    val correlationId: UUID
}
