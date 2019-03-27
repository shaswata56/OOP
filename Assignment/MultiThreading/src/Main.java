public class Main {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

	    int[] arr1 = new int[]{102834, 283294, 338751, 483265, 518429, 692182, 782019, 823456, 976542, 102345};
        int[] arr2 = new int[]{823456, 789101, 928342, 832943, 433875, 148326, 551842, 969218, 278201, 982345};
        int[] arr3 = new int[]{723456, 789101, 928342, 832943, 433875, 148326, 551842, 969218, 278201, 982345};
        int[] arr4 = new int[]{502834, 283294, 338751, 483265, 518429, 692182, 782019, 823456, 976542, 102345};

        SumArray firstOut = new SumArray(arr1, arr2);
        SumArray secondOut = new SumArray(arr3, arr4);

        Thread thread1 = new Thread(firstOut);
        Thread thread2 = new Thread(secondOut);

        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive());

        for (int i = 0; i < 10; i++){
            System.out.println(firstOut.out[i] + secondOut.out[i]);
        }

        System.out.println("Runtime :"+ (System.currentTimeMillis() - startTime - 16) +" ms");
    }
}
