package baseball.model

@JvmInline
value class BaseballNumber(
    private val numberList: List<Int>
) {
    fun contains(number: Int): Boolean = numberList.any { it == number }
    fun isStrike(index: Int, number: Int): Boolean = numberList.getOrNull(index) == number
    fun isBall(index: Int, number: Int): Boolean = contains(number) && !isStrike(index, number)
}