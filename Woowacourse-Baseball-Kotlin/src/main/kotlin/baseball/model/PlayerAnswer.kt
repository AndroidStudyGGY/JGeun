package baseball.model

import baseball.utils.ExceptionConstants.DUPLICATED_DIGIT_EXCEPTION
import baseball.utils.ExceptionConstants.LENGTH_MISMATCH_EXCEPTION
import baseball.utils.ExceptionConstants.NON_DIGIT_EXCEPTION
import baseball.utils.ExceptionConstants.OUT_OF_RANGE_EXCEPTION
import baseball.utils.GameConstants

@JvmInline
value class PlayerAnswer(
    val numberList: List<Int>
) {
    companion object {
        fun initPlayerAnswer(answer: String, exceptedLength: Int): PlayerAnswer {
            // 입력과 숫자의 길이가 같아야 합니다.
            require(validateInputLength(answer, exceptedLength)) { LENGTH_MISMATCH_EXCEPTION }

            // 중복된 값은 존재해서는 안됩니다.
            require(validateDuplicate(answer)) { DUPLICATED_DIGIT_EXCEPTION }

            val numberList = mutableListOf<Int>()
            answer.forEach {
                // 각 자리 수는 숫자여야 합니다.
                require(it.isDigit()) { NON_DIGIT_EXCEPTION }
                val number = it.digitToInt()

                // 입력된 값은 게임에서 제한된 범위여야 합니다.
                require(validateNumberRange(number)) { OUT_OF_RANGE_EXCEPTION }

                numberList.add(number)
            }

            return PlayerAnswer(numberList)
        }

        private fun validateDuplicate(answer: String): Boolean {
            return answer.toSet().size == answer.length
        }

        private fun validateNumberRange(number: Int): Boolean {
            return number in GameConstants.MIN_RANGE..GameConstants.MAX_RANGE
        }

        private fun validateInputLength(input: String, exceptedLength: Int): Boolean {
            return input.length == exceptedLength
        }
    }
}