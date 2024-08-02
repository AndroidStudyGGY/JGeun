package com.jgeun.domain.model

import kotlin.random.Random

data class MovieModel(
    val movieCode: String,
    val movieName: String,
    val genre: String,
    val nation: String,
    val price: Int = createRandomPrice()
) {
    companion object {
        fun createRandomPrice(from: Int = 10000, to: Int = 20000): Int {
            return Random.nextInt(to - from, to) + from
        }
    }
}