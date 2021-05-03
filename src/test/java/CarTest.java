import cargame.CarPlay;
import cargame.CarStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private CarPlay carGame;

    @BeforeEach
    void setUp() {
        carGame = new CarPlay();
    }

    @Test
    @DisplayName("자동차의 전진 확인")
    public void carMove() {
        assertThat(carGame.playCarGame(5)).isEqualTo(CarStatus.CARMOVE);
    }

    @Test
    @DisplayName("자동차의 멈춤 확인")
    public void carStay() {
        assertThat(carGame.playCarGame(3)).isEqualTo(CarStatus.CARSTAY);
    }
}
