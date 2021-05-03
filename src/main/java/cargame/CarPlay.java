package cargame;

import java.util.Collections;
import java.util.List;

public class CarPlay {

    public static final int CAR_MOVE_RANGE = 4;

    private List<String> carList;
    private List<Integer> carMoveList;
    private StringBuffer sb;
    private int carCount = 0;

    private InputCarInfo carInfo = new InputCarInfo();
    private InputPlayCount playCount = new InputPlayCount();
    private CreateMoveNumber createNumber = new CreateMoveNumber();

    public void ready() {
        this.carList = carInfo.inputCar();
        int gameCount = playCount.inputCount();
        startGame(this.carList, gameCount);
    }

    private void startGame(List<String> carList, int gameCount) {
        this.carMoveList = createNumber.resetCarMoveList(carList.size());
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameCount; i++) {
            carMove(carList);
            printResult();
        }
        printVictory();
    }

    private void printVictory() {
        int maxCount = Collections.max(this.carMoveList);
        this.sb = new StringBuffer();
        victoryCarCount(maxCount);
        for (int i = 0; i < this.carList.size(); i++) {
            printVictoryCar(i, maxCount);
        }
        this.sb.append("가 우승했습니다.");
        System.out.println(this.sb.toString());
    }

    private void victoryCarCount(int maxCount) {
        for (int i = 0; i < this.carMoveList.size(); i++) {
            getCount(maxCount, i);
        }
    }

    private void getCount(int maxCount, int list) {
        if (maxCount == this.carMoveList.get(list)) {
            this.carCount++;
        }
    }

    private void printVictoryCar(int i, int maxCount) {
        if (maxCount == this.carMoveList.get(i)) {
            this.sb.append(this.carList.get(i));
            addAppend(i);
        }
    }

    private void addAppend(int count) {
        if (count < this.carCount - 1) {
            sb.append(", ");
        }
    }

    private void printResult() {
        for (int i = 0; i < this.carList.size(); i++) {
            System.out.print(this.carList.get(i) + ":");
            printCount(i);
        }
        System.out.println();
    }

    private void printCount(int carNumber) {
        int count = this.carMoveList.get(carNumber);
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void carMove(List<String> carList) {
        for (int i = 0; i < carList.size(); i++) {
            int ranNum = createNumber.carMoveNumber();
            inputResult(i, ranNum);
        }
    }

    private void inputResult(int i, int carMoveNumber) {
        if (playCarGame(carMoveNumber).equals(CarStatus.CARMOVE)) {
            this.carMoveList.set(i, this.carMoveList.get(i) + 1);
        }
    }

    public CarStatus playCarGame(int carMoveNumber) {
        if (match(carMoveNumber)) {
            return CarStatus.CARMOVE;
        }
        return CarStatus.CARSTAY;
    }

    private boolean match(int carMoveNumber) {
        return carMoveNumber > CAR_MOVE_RANGE;
    }
}
