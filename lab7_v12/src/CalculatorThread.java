public class CalculatorThread implements Runnable {
    private int a;
    private long result;

    public long getResult() {
        return result;
    }

    public CalculatorThread(int a) {
        this.a = a;
        this.result = 1;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start");
        if (a % 2 == 1) {
            for (int j = 1; j <= a; j += 2) {
                result *= j;
            }
        }
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
