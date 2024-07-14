package baseball.game

import baseball.model.BaseballNumber
import baseball.model.PlayerAnswer
import baseball.player.BaseballPlayer
import baseball.utils.CreateBaseballNumberFactory
import baseball.utils.GameConstants

class BaseballGame : Game {

    override fun start() {
        // 게임 시작 문구 출력
        BaseballGameConsole.printGameStartText()

        // 플레이어 생성
        val baseballPlayer = BaseballPlayer()

        // 게임 시작
        do {
            startGame(baseballPlayer)
        } while (askRestart())
    }

    override fun askRestart(): Boolean {
        val restartCode = BaseballGameConsole.inputRestartCode()
        return restartCode.isRestart()
    }

    private fun startGame(
        baseballPlayer: BaseballPlayer,
        numberLength: Int = GameConstants.BASE_NUMBER_LENGTH
    ) {
        // 정답 숫자 생성
        val answerNumber = CreateBaseballNumberFactory.create(numberLength)

        do {
            // 사용자 숫자 입력
            val playerAnswer = BaseballGameConsole.inputPlayerAnswer(baseballPlayer, numberLength)

            // Strike, Ball 계산 후 Hint 출력
            val (strike, ball) = calculateStrikeAndBall(answerNumber, playerAnswer)
            BaseballGameConsole.printHint(strike, ball)

        } while (isAnswer(strike, numberLength).not())

        BaseballGameConsole.printGameClearText(numberLength)
    }

    private fun calculateStrikeAndBall(answerNumber: BaseballNumber, playerAnswer: PlayerAnswer): Pair<Int, Int> {
        val strike = playerAnswer.numberList.filterIndexed { index, number ->
            answerNumber.isStrike(index, number)
        }.count()

        val ball = playerAnswer.numberList.filterIndexed { index, number ->
            answerNumber.isBall(index, number)
        }.count()

        return Pair(strike, ball)
    }

    private fun isAnswer(strike: Int, numberLength: Int) = strike == numberLength
}












