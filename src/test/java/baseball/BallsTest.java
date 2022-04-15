package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

/**
 * author : citizen103
 */
public class BallsTest {
    
    @Test
    void Balls_숫자길이_Exception_Test() {
        // Then
        assertThatThrownBy(() -> {
            Balls.ofBallsString("12");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Balls.ofBallsString("1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Balls_숫자_중복_Exception_Test() {
        // Then
        assertThatThrownBy(() -> {
            Balls.ofBallsString("121");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Ball_strike_Test() {
        // Given
        Balls balls = Balls.ofBallsString("123");
        Ball userBall = Ball.of(1, 1);

        // When
        BallStatus status = balls.compareBall(userBall);

        // Then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void Ball_ball_Test() {
        // Given
        Balls balls = Balls.ofBallsString("123");
        Ball userBall = Ball.of(1, 2);

        // When
        BallStatus status = balls.compareBall(userBall);

        // Then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void Ball_nothing_Test() {
        // Given
        Balls balls = Balls.ofBallsString("123");
        Ball userBall = Ball.of(4, 1);

        // When
        BallStatus status = balls.compareBall(userBall);

        // Then
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void Balls_not_3strike_Test() {
        // Given
        Balls userBalls = Balls.ofBallsString("123");
        Balls computerBalls = Balls.ofBallsString("124");

        // When
        CompareResult result = computerBalls.compareBalls(userBalls);

        // Then
        assertThat(result.isThreeStrike()).isFalse();
    }

    @Test
    void Balls_3strike_Test() {
        // Given
        Balls userBalls = Balls.ofBallsString("123");
        Balls computerBalls = Balls.ofBallsString("123");

        // When
        CompareResult result = computerBalls.compareBalls(userBalls);

        // Then
        assertThat(result.isThreeStrike()).isTrue();
    }

}
