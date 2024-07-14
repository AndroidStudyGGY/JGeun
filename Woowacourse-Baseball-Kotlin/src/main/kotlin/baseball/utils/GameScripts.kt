package baseball.utils

object GameScripts {
    const val ENTER_NUMBER_TEXT = "숫자를 입력해주세요 : "
    const val START_GAME_TEXT = "숫자 야구 게임을 시작합니다."
    const val RESTART_ASK_TEXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

    private const val GAME_CLEAR_TEXT = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료"
    fun getGameClearText(count: Int) = String.format(GAME_CLEAR_TEXT, count)
}