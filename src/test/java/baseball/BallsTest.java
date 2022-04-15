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
            new Balls("12");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Balls("1234");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Balls_숫자_중복_Exception_Test() {
        // Then
        assertThatThrownBy(() -> {
            new Balls("121");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void strike_Test() {
        // Given
        Balls balls = new Balls("123");
        Ball userBall = Ball.of(1, 1);

        // When
        BallStatus status = balls.compareBall(userBall);

        // Then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball_Test() {
        // Given
        Balls balls = new Balls("123");
        Ball userBall = Ball.of(1, 2);

        // When
        BallStatus status = balls.compareBall(userBall);

        // Then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing_Test() {
        // Given
        Balls balls = new Balls("123");
        Ball userBall = Ball.of(4, 1);

        // When
        BallStatus status = balls.compareBall(userBall);

        // Then
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

}
