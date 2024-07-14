package baseball.utils

import baseball.model.BaseballNumber
import camp.nextstep.edu.missionutils.Randoms

object CreateBaseballNumberFactory {
    fun create(count: Int) = createBaseballNumber(count)

    private fun createBaseballNumber(count: Int): BaseballNumber {
        val computer = mutableListOf<Int>()
        while (computer.size < count) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        return BaseballNumber(computer)
    }
}