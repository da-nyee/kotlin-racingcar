package com.example.kotlinracingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @Test
    fun `create cars - Success`() {
        // given
        val cars = listOf(Car("dani"), Car("dada"))

        // when
        // then
        assertThatCode { Cars(cars) }.doesNotThrowAnyException()
    }

    @Test
    fun `create cars - Fail`() {
        // given
        val cars = listOf(Car("dani"), Car("dani"))

        // when
        // then
        assertThrows<IllegalArgumentException> { Cars(cars) }
    }

    @Test
    fun `move each car when the strategy is true`() {
        // given
        val cars = Cars(listOf(Car("dani"), Car("dada")))

        // when
        val movedCars = cars.move(object : MoveStrategy {
            override fun move(): Boolean {
                return true
            }
        })

        // then
        assertThat(movedCars.cars).hasSize(2)
        movedCars.cars.forEach {
            assertThat(it.position).isOne
        }
    }

    @Test
    fun `not move each car when the strategy is false`() {
        // given
        val cars = Cars(listOf(Car("dani"), Car("dada")))

        // when
        val movedCars = cars.move(object : MoveStrategy {
            override fun move(): Boolean {
                return false
            }
        })

        // then
        assertThat(movedCars.cars).hasSize(2)
        movedCars.cars.forEach {
            assertThat(it.position).isZero
        }
    }

    @Test
    fun `find the max position`() {
        // given
        val cars = Cars(listOf(Car("dani", 6), Car("dada", 2)))

        // when
        // then
        assertThat(cars.findMaxPosition()).isEqualTo(6)
    }

    @Test
    fun `find cars in the same position`() {
        // given
        val cars = Cars(listOf(Car("dani", 6), Car("dada", 2), Car("hello", 6)))

        // when
        val findCars = cars.findCarsInTheSamePosition(6)

        // then
        assertThat(findCars.cars).hasSize(2)
    }
}
