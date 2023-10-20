package com.payments.buildingBlock.application

import java.util.*

interface Command {
    val correlationId: UUID
}
