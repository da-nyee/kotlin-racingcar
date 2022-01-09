package com.example.kotlinracingcar.domain

import com.example.kotlinracingcar.utils.RandomUtils

class RandomMoveStrategy : MoveStrategy {

    override fun move(): Boolean {
        return RandomUtils.nextInt() >= 4
    }
}
