package baseball;

import java.util.List;

/**
 * author : citizen103
 */
public class CompareResult {

    private int strike = 0;
    private int ball = 0;

    public boolean isThreeStrike() {
        if (strike == 3) {
            System.out.print("3개의 숫자를 모두 맞히셨습니다! ");
            return true;
        }
        return false;
    }

    public void checkBallStatus(BallStatus compareBallStatus) {
        if (BallStatus.STRIKE == compareBallStatus) {
            strike++;
        }

        if (BallStatus.BALL == compareBallStatus) {
            ball++;
        }
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(String.format("%d볼 ", ball));
        }

        if (strike != 0) {
            sb.append(String.format("%d스트라이크", strike));
        }
        System.out.println(sb.toString());
    }
}
