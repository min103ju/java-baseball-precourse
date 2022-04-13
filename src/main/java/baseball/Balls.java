package baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * author : citizen103
 */
public class Balls {

    private List<Ball> balls;

    public Balls(String balls) {
        validationBalls(balls);
        this.balls = convertToBalls(balls);
    }

    private List<Ball> convertToBalls(String balls) {
        ArrayList<Ball> result = new ArrayList<>();
        for (int i = 0; i < balls.length(); i++) {
            result.add(Ball.of(Character.getNumericValue(balls.charAt(i)), i + 1));
        }
        return result;
    }

    private void validationBalls(String balls) {
        if (balls.length() != 3) {
            throw new IllegalArgumentException("숫자는 3개이어야 합니다.");
        }
    }

    public BallStatus compareBall(Ball userBall) {
        List<BallStatus> statuses = new ArrayList<>();
        for (Ball ball : this.balls) {
            statuses.add(ball.compareBall(userBall));
        }

        return getCompareBallResultStatus(statuses);
    }

    private BallStatus getCompareBallResultStatus(List<BallStatus> statuses) {
        if (statuses.contains(BallStatus.STRIKE)) {
            return BallStatus.STRIKE;
        }

        if (statuses.contains(BallStatus.BALL)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

}
