import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadGenerator {
    private static List<CalculatorThread> calcList = new ArrayList<>();
    private static int thrNum;
    private static char action;

    public static void main(String[] args) {
        int number = 1;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Number threads");
            thrNum = Integer.parseInt(sc.nextLine());
            System.out.println("Number ");
            number = Integer.parseInt(sc.nextLine());
            if (number % 2 == 0) {
                System.out.println("not even number");
                return;
            }
            System.out.println("Action (+/-/*)");
            action = sc.next().charAt(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        execute(number);
        getResult();
    }

    private static void execute(int number) {
        for (int i = 0; i < thrNum; i++) {
            CalculatorThread cl = new CalculatorThread(number);
            calcList.add(cl);
            Thread thr = new Thread(cl);
            try {
                thr.start();
                thr.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
            System.out.println(cl.getResult());
        }
    }

    private static void getResult() {
        BigInteger tmp = BigInteger.valueOf(0);
        switch (action) {
            case '+' -> {
                for (var i : calcList) {
                    tmp = tmp.add(BigInteger.valueOf(i.getResult()));
                }
            }
            case '-' -> {
                for (var i : calcList) {
                    tmp = tmp.subtract(BigInteger.valueOf(i.getResult()));
                }
            }
            case '*' -> {
                tmp = BigInteger.valueOf(1);
                for (var i : calcList) {
                    tmp = tmp.multiply(BigInteger.valueOf(i.getResult()));
                }
            }
            default -> {
                System.out.println("Not valid action");
                return;
            }
        }
        System.out.println("Result = " + tmp);
    }
}
