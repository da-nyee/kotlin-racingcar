package com.example.kotlinracingcar.domain

class Car(private val name: String, val position: Int = 0) {

    init {
        require(name.isNotBlank() && name.length <= 5) {
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
}
