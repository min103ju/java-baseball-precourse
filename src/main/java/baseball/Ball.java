package baseball;

/**
 * author : citizen103
 */
public class Ball {

    private int number;
    private int position;

    private Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public static Ball of(int number, int position) {
        return new Ball(number, position);
    }

    public BallStatus compareBall(Ball computerBall) {

        if (this.equals(computerBall)) {
            return BallStatus.STRIKE;
        }

        if (this.number == computerBall.number && this.position != computerBall.position) {
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
