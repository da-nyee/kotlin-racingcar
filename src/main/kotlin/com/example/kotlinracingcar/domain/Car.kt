package com.example.kotlinracingcar.domain

class Car(val name: String, val position: Int = 0) {

    init {
        require(name.isNotEmpty() && name.length <= 5) {
            "이름은 1자 이상, 5자 이하여야 합니다."
        }
    }

    fun move(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.move()) {
            return Car(name, position + 1)
        }
        return this
    }

    fun isSamePosition(position: Int): Boolean {
        return this.position == position
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
