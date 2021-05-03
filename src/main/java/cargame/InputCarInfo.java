package cargame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputCarInfo {

    public static final int CAR_NAME_RANGE = 5;
    public static final int CAR_MIN_RANGE = 1;
    private List<String> carList;
    private final Scanner scan = new Scanner(System.in);

    public List<String> inputCar() {
        while (true) {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String carInfo = scan.nextLine();
            this.carList = Arrays.asList(carInfo.split(","));
            try {
                validation(this.carList);
                break;
            } catch (IllegalArgumentException e) {
            }
        }
        return this.carList;
    }

    public void validation(List<String> carList) {
        if (carList.size() <= CAR_MIN_RANGE) {
            System.out.println("경주 차량이 부족합니다.");
            throw new IllegalArgumentException("경주 차량이 부족합니다.");
        }
        for (int i = 0; i < carList.size(); i++) {
            checkCarName(carList.get(i));
        }
        carDoubleCheck(carList);
    }

    private void carDoubleCheck(List<String> carList) {
        for (int i = 0; i < carList.size(); i++) {
            String checkCar = carList.get(i);
            carList.set(i, "");
            doubleCheck(carList, checkCar, i);
        }
    }

    private void doubleCheck(List<String> carList, String checkCar, int i) {
        if (carList.contains(checkCar)) {
            System.out.println("중복된 차량이 존재합니다.");
            throw new IllegalArgumentException("중복된 차량이 존재합니다.");
        }
        carList.set(i, checkCar);
    }

    private void checkCarName(String s) {
        if (s.length() > CAR_NAME_RANGE) {
            System.out.println("자동차 이름은 5자 이내로 입력해주세요.");
            throw new IllegalArgumentException("자동차 이름은 5자 이내로 입력해주세요.");
        }
    }
}
