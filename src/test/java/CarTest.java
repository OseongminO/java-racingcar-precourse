import cargame.Car;
import cargame.CarStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car carGame;

    @BeforeEach
    void setUp() {
        carGame = new Car();
    }

    @Test
    public void carMove() {
        assertThat(carGame.play(5)).isEqualTo(CarStatus.CARMOVE);
    }

    @Test
    public void carStay() {
        assertThat(carGame.play(3)).isEqualTo(CarStatus.CARSTAY);
    }
}
