package cargame;

public class Car {

    public CarStatus play(int carMoveNumber) {
        if (carMoveNumber > 4) {
            return CarStatus.CARMOVE;
        }
        return CarStatus.CARSTAY;
    }

}
