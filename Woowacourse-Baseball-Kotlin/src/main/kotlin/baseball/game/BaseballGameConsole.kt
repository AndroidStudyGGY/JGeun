package baseball.game

import baseball.model.PlayerAnswer
import baseball.model.RestartCode
import baseball.player.BaseballPlayer
import baseball.utils.GameConstants.NO_BALL
import baseball.utils.GameConstants.NO_STRIKE
import baseball.utils.GameScripts
import camp.nextstep.edu.missionutils.Console

object BaseballGameConsole {

    fun printGameStartText() {
        println(GameScripts.START_GAME_TEXT)
    }

    fun inputPlayerAnswer(baseballPlayer: BaseballPlayer, numberLength: Int): PlayerAnswer {
        // 숫자 입력 문구 출력
        print(GameScripts.ENTER_NUMBER_TEXT)

        // 사용자 숫자 입력
       return baseballPlayer.enterAnswer(numberLength)
    }

    fun inputRestartCode(): RestartCode {
        // 게임 재시작 의사 확인 문구 출력
        println(GameScripts.RESTART_ASK_TEXT)

        val restartInput = Console.readLine()

        return RestartCode.createRestartCode(restartInput)
    }

    fun printHint(strike: Int, ball: Int) {
        when {
            (strike != NO_STRIKE && ball != NO_BALL) -> println("${ball}볼 ${strike}스트라이크")
            (strike != NO_STRIKE && ball == NO_BALL) -> println("${strike}스트라이크")
            (strike == NO_STRIKE && ball != NO_BALL) -> println("${ball}볼")
            (strike == NO_STRIKE && ball == NO_BALL) -> println("낫싱")
        }
    }

    fun printGameClearText(numberLength: Int) {
        println(GameScripts.getGameClearText(numberLength))
    }
}