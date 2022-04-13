package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * author : citizen103
 */
public class BallTest {

    @Test
    void strike_Test() {
        // Given
        Ball computerBall = Ball.of(1, 1);
        Ball humanBall = Ball.of(1, 1);

        // When
        BallStatus status = humanBall.compareBall(computerBall);

        // Then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball_Test() {
        // Given
        Ball computerBall = Ball.of(1, 1);
        Ball humanBall = Ball.of(1, 2);

        // When
        BallStatus status = humanBall.compareBall(computerBall);

        // Then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing_Test() {
        // Given
        Ball computerBall = Ball.of(1, 1);
        Ball humanBall = Ball.of(2, 2);

        // When
        BallStatus status = humanBall.compareBall(computerBall);

        // Then
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

}