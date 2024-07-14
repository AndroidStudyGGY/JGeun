package baseball.model

import baseball.utils.ExceptionConstants.LENGTH_MISMATCH_EXCEPTION
import baseball.utils.ExceptionConstants.WRONG_FORMAT_EXCEPTION
import baseball.utils.GameConstants

enum class RestartCode {
    RESTART_YES, RESTART_NO;

    fun isRestart() = this == RESTART_YES

    companion object {
        fun createRestartCode(input: String): RestartCode {
            // 재시작 코드의 길이가 RESTART_ANSWER_LENGTH(1)과 동일해야 합니다.
            require(input.length == GameConstants.RESTART_ANSWER_LENGTH) { LENGTH_MISMATCH_EXCEPTION }

            // 재시작 코드는 1 or 2 여야만 합니다.
            require(input == GameConstants.RESTART_YES || input == GameConstants.RESTART_NO) {
                WRONG_FORMAT_EXCEPTION
            }

            return if (input == GameConstants.RESTART_YES) {
                RESTART_YES
            } else {
                RESTART_NO
            }
        }
    }
}