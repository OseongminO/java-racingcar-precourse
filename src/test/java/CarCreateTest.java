import cargame.InputCarInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarCreateTest {

    private InputCarInfo carInfo;

    @BeforeEach
    void setUp() {
        carInfo = new InputCarInfo();
    }

    @Test
    @DisplayName("경주 차량 숫자 체크")
    void checkCarCount() {
        List<String> list = Arrays.asList("pobi");
        assertThatThrownBy(() -> {
            carInfo.validation(list);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("경주 차량이 부족합니다.");
    }

    @Test
    @DisplayName("차량이름 중복 체크")
    void checkCarDoubleCheck() {
        List<String> list = Arrays.asList("pobi", "pobi");
        assertThatThrownBy(() -> {
            carInfo.validation(list);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복된 차량이 존재합니다.");
    }

    @Test
    @DisplayName("차량이름 자릿수 체크")
    void checkCarNameCount() {
        List<String> list = Arrays.asList("cristal", "pobi");
        List<String> list2 = Arrays.asList("tom", "seongmin");
        assertThatThrownBy(() -> {
            carInfo.validation(list);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름은 5자 이내로 입력해주세요.");
        assertThatThrownBy(() -> {
            carInfo.validation(list2);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름은 5자 이내로 입력해주세요.");
    }
}
