package com.example.kotlinracingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `start a race`() {
        // given
        val cars = Cars(listOf(Car("dani", 1), Car("dada", 1), Car("hello")))
        val times = Times(10)

        val game = Game(cars, times)

        // when
        val result = game.race(object : MoveStrategy {
            override fun move(): Boolean {
                return true
            }
        })

        // then
        assertThat(result.first).hasSize(times.times)
        assertThat(result.second).hasSize(2)
    }
}
