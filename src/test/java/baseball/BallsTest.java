package baseball;

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

}
