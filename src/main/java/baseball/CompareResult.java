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
}
