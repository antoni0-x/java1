package javaProdv.lesson5;

public class Homework25 {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {

        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;

        }
        long a = System.currentTimeMillis();
        massOne(arr);
        System.out.println("Time 1 = " + (System.currentTimeMillis() - a));

        a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread thread1 = new Thread(() -> massOne(a1));
        Thread thread2 = new Thread(() -> massOne(a2));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Time 2 = " + (System.currentTimeMillis() - a));
    }

    public static void massOne(float arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public static void massTwo(float arr[]) {


    }
}
