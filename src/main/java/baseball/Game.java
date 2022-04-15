package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

/**
 * author : citizen103
 */
public class Game {

    private Balls computerBalls;
    private CompareResult compareResult;

    public Game() {
        this.computerBalls = createComputerBalls();
    }

    private Balls createComputerBalls() {
        int firstComputerBall = Randoms.pickNumberInRange(1, 9);
        int secondComputerBall = Randoms.pickNumberInRange(1, 9);
        int thirdComputerBall = Randoms.pickNumberInRange(1, 9);
        return new Balls(Arrays.asList(
            firstComputerBall, secondComputerBall, thirdComputerBall
        ));
    }

    public void play() {
        System.out.println("숫자를 입력해주세요.");
        Balls userBalls = Balls.ofBallsString(Console.readLine());
        compareResult = this.computerBalls.compareBalls(userBalls);
        compareResult.printResult();
    }

    public boolean isGameEnd() {
        boolean isThreeStrike = compareResult.isThreeStrike();
        if (isThreeStrike) {
            System.out.println("게임종료");
            isThreeStrike = isRestart();
        }
        return isThreeStrike;
    }

    public boolean isRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restartFlag = Console.readLine();
        if (restartFlag.equals("1")) {
            this.computerBalls = createComputerBalls();
            return false;
        }
        return true;
    }
}
