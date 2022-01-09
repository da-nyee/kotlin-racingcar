package com.example.kotlinracingcar.utils

import kotlin.random.Random

class RandomUtils {

    companion object {
        fun nextInt(): Int {
            return Random.nextInt(10)
        }
    }
}
