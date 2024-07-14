package baseball.player

import baseball.model.PlayerAnswer
import camp.nextstep.edu.missionutils.Console

class BaseballPlayer : Player {

    override fun input(): String {
        return Console.readLine()
    }

    fun enterAnswer(baseballNumberLength: Int): PlayerAnswer {
        return PlayerAnswer.initPlayerAnswer(input(), baseballNumberLength)
    }
}