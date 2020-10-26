package javaVvod.lesson1;

public class homework1 {
    public static void main(String[] args) {
        float a = 1.2f;
        byte e = 2;
        short f = -3;
        int g = 56342;
        double dbl = 12.567345;
        char chr = '!';
        boolean bool;
        bool = false;

        System.out.println(calc(1f, 2f, 3f, 4f));
        System.out.println(task10and20(14, 7));
        isPositiveOrNegative(-3);
        System.out.println(isNegative(-9));
        greetings("Ник");
        year(2045);
    }

    public static float calc(float a, float b, float c, float d) {
        float rez = a * (b + (c / d));
        return rez;
    }

    public static boolean task10and20(int x1, int x2) {
        if ((x1 + x2) >= 10 && (x1 + x2) <= 20) {
            return true;
        } else
            return false;
    }

    public static void isPositiveOrNegative(int x) {
        if (x >= 0) {
            System.out.println("число положительное");
        } else
            System.out.println("число отрицательное");
    }

    public static boolean isNegative(int x) {
        if (x < 0) {
            return true;
        } else
            return false;
    }

    public static void greetings(String name) {
        System.out.println("Привет, " + name + "!");
    }

    public static void year(float x) {
        if ((x % 4 == 0 && x % 100 != 0) || (x % 4 == 0 && x % 400 == 0)) {
            System.out.println("Год високосный");
        } else
            System.out.println("Год НЕ високосный");
    }
}

