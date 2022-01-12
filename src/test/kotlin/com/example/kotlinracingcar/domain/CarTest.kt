package com.example.kotlinracingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CarTest {

    @ParameterizedTest
    @MethodSource("validCar")
    fun `create a Car - Success`(name: String) {
        assertThatCode { Car(name) }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @MethodSource("invalidCar")
    fun `create a Car - Fail`(name: String) {
        assertThrows<IllegalArgumentException> { Car(name) }
    }

    @Test
    fun `move a car when the strategy is true`() {
        // given
        val car = Car("dani")

        // when
        val movedCar = car.move(object: MoveStrategy {
            override fun move(): Boolean {
                return true
            }
        })

        // then
        assertThat(movedCar.position).isOne
    }

    @Test
    fun `not move a car when the strategy is false`() {
        // given
        val car = Car("dani")

        // when
        val movedCar = car.move(object: MoveStrategy {
            override fun move(): Boolean {
                return false
            }
        })

        // then
        assertThat(movedCar.position).isZero
    }

    @Test
    fun `check the position - True`() {
        // given
        val car = Car("dani")

        val movedCar = car.move(object: MoveStrategy{
            override fun move(): Boolean {
                return true
            }
        })

        // when
        // then
        assertThat(movedCar.isSamePosition(1)).isTrue
    }

    @Test
    fun `check the position - False`() {
        // given
        val car = Car("dani")

        val movedCar = car.move(object: MoveStrategy{
            override fun move(): Boolean {
                return true
            }
        })

        // when
        // then
        assertThat(movedCar.isSamePosition(0)).isFalse
    }

    companion object {
        @JvmStatic
        fun validCar() = Stream.of(
            Arguments.of("dani"),
            Arguments.of("dada"),
            Arguments.of("hello")
        )

        @JvmStatic
        fun invalidCar() = Stream.of(
            Arguments.of(""),
            Arguments.of("kotlin")
        )
    }
}
