package cargame;

import java.util.Arrays;
import java.util.Scanner;

public class InputPlayCount {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;
    private int gameCount = 0;

    private final Scanner scan = new Scanner(System.in);

    public int inputCount() {
        while (true) {
            System.out.println("시도할 회수는 몇회인가요?");
            this.gameCount = scan.nextInt();
            try {
                validation(this.gameCount);
                break;
            } catch (IllegalArgumentException e) {
            }
        }
        return this.gameCount;
    }

    public void validation(int gameCount) {
        if (gameCount < MIN_NUM || gameCount > MAX_NUM) {
            System.out.println("0과 9사이의 숫자를 입력해주세요");
            throw new IllegalArgumentException("0과 9사이의 숫자를 입력해주세요");
        }
    }
}
