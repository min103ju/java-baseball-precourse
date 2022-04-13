package baseball;

/**
 * author : citizen103
 */
public class Ball {

    private int number;
    private int position;

    private Ball(int number, int position) {
        validationBallValue(number);
        this.number = number;
        this.position = position;
    }

    private void validationBallValue(int number) {
        if (number < 0 || number > 10) {
            throw new IllegalArgumentException("숫자는 1~9까지만 입력할 수 있습니다.");
        }
    }

    public static Ball of(int number, int position) {
        return new Ball(number, position);
    }

    public BallStatus compareBall(Ball computerBall) {

        if (this.equals(computerBall)) {
            return BallStatus.STRIKE;
        }

        if (this.number == computerBall.number) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ball ball = (Ball) o;

        if (number != ball.number) {
            return false;
        }
        return position == ball.position;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + position;
        return result;
    }
}
