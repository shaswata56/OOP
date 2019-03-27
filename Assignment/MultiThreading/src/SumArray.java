
public class SumArray implements Runnable {

    private int[] arr1;
    private int[] arr2;
    int[] out = new int[10];

    SumArray(int[] arr1, int[] arr2){
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    @Override
    public synchronized void run() {
        int i = 10;
        while(i-- >= 1){
            out[i] = arr1[i] + arr2[i];
            try {
                Thread.sleep(100);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
        }
    }
}
