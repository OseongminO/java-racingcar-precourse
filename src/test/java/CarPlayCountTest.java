import cargame.InputPlayCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarPlayCountTest {

    private InputPlayCount playCount;

    @BeforeEach
    void setUp() {
        playCount = new InputPlayCount();
    }

    @Test
    @DisplayName("1 보다 작은 게임수 입력 테스트 ")
    void checkPlayMinCount() {
        assertThatThrownBy(() -> {
            playCount.validation(0);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("0과 9사이의 숫자를 입력해주세요");
    }

    @Test
    @DisplayName("9보다 큰 게임수 입력 테스트 ")
    void checkPlayMaxCount() {
        assertThatThrownBy(() -> {
            playCount.validation(10);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("0과 9사이의 숫자를 입력해주세요");
    }
}
