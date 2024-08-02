package baseball.utils

import baseball.model.BaseballNumber
import baseball.utils.GameConstants.MAX_RANGE
import baseball.utils.GameConstants.MIN_RANGE
import camp.nextstep.edu.missionutils.Randoms

object CreateBaseballNumberFactory {
    fun create(count: Int) = createBaseballNumber(count)

    private fun createBaseballNumber(count: Int): BaseballNumber {
        val computer = mutableListOf<Int>()
        while (computer.size < count) {
            val randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

        return BaseballNumber(computer)
    }
}