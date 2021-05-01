package cargame;

import java.util.List;

public class CarPlay {

    private InputCarInfo carInfo = new InputCarInfo();
    private InputPlayCount playCount = new InputPlayCount();

    public void ready() {
        List<String> carList = carInfo.inputCar();
        int gameCount = playCount.inputCount();
    }

    public CarStatus play(int carMoveNumber) {
        if (carMoveNumber > 4) {
            return CarStatus.CARMOVE;
        }
        return CarStatus.CARSTAY;
    }

}
