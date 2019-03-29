package TryCatchThrows;

class TryCatch {

    private String x;

    TryCatch(String x) {
        this.x = x;
    }

    void run() throws InterruptedException {
        Thread.sleep(10);
        System.out.println(x);
    }
}
