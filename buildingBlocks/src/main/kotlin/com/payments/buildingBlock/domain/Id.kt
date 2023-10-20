package com.payments.buildingBlock.domain
abstract class Id protected constructor(
    id: Long = 0
) {

    val value: Long = id

    override fun equals(other: Any?): Boolean {
        if (other == null || this::class.simpleName != other::class.simpleName) {
            return false
        }
        return if (other is Id) return this.value == other.value
        else false
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }
}
