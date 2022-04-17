package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * author : citizen103
 */
public class Balls {

    private List<Ball> balls;

    public Balls(List<Integer> balls) {
        validateBalls(balls);
        this.balls = convertToBalls(balls);
    }

    public static Balls ofBallsString(String balls) {
        List<Integer> convertedBalls = new ArrayList<>();
        for (int i = 0; i < balls.length(); i++) {
            convertedBalls.add(Character.getNumericValue(balls.charAt(i)));
        }
        return new Balls(convertedBalls);
    }

    private List<Ball> convertToBalls(List<Integer> balls) {
        ArrayList<Ball> result = new ArrayList<>();
        for (int i = 0; i < balls.size(); i++) {
            result.add(Ball.of(balls.get(i), i + 1));
        }
        return result;
    }

    private void validateBalls(List<Integer> balls) {
        validateBallLength(balls);
        validateBallDuplicated(balls);
    }

    private void validateBallDuplicated(List<Integer> balls) {
        HashSet<Integer> set = new HashSet<>(balls);
        if (set.size() < balls.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있어선 안됩니다.");
        }
    }

    private void validateBallLength(List<Integer> balls) {
        if (balls.size() != 3) {
            throw new IllegalArgumentException("숫자는 3개이어야 합니다.");
        }
    }

    public BallStatus compareBall(Ball targetBall) {
        List<BallStatus> statuses = new ArrayList<>();
        for (Ball ball : this.balls) {
            statuses.add(ball.compareBall(targetBall));
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

    public CompareResult compareBalls(Balls targetBalls) {
        CompareResult compareResult = new CompareResult();
        for (Ball ball : this.balls) {
            compareResult.checkBallStatus(targetBalls.compareBall(ball));
        }
        return compareResult;
    }
}
