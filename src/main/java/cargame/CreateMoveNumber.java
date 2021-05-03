package cargame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateMoveNumber {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    public static final int SET_COUNT = 0;

    public List<Integer> resetCarMoveList(int carCount) {
        List<Integer> carMoveList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carMoveList.add(SET_COUNT);
        }
        return carMoveList;
    }

    public int carMoveNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUM) + MIN_NUM;
    }
}
