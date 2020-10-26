package javaVvod.lesson2;

import java.util.Arrays;

public class homework2 {
    public static void main(String[] args) {


        System.out.println(Arrays.toString(invert()));
        System.out.println(Arrays.toString(fillArray()));
        System.out.println(Arrays.toString(changeArray()));
        System.out.println(Arrays.deepToString(fillDiagonal()));
        System.out.println("Максимальное и минимальное значения соответственно: " + Arrays.toString(exercise5()));

        int[] arr2 = {2, 2, 2, 1, 2, 2, 10, 1};
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(checkBalance(arr2));
        System.out.println(Arrays.toString(movArr(arr3, -7)));
    }

    public static int[] invert() {
        int[] arr = {1, 0, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static int[] fillArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
        }
        return arr;
    }

    public static int[] changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] = arr[i] * 2;
        }
        return arr;
    }

    public static int[][] fillDiagonal() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            arr[i][i] = 1; //заполняется диагональ, проведенная из левого верхнего угла в нижний правый
            arr[i][4 - i] = 1; //заполняется диагональ, проведенная из правого верхнего угла в нижний левый
        }

        return arr;
    }


    public static int[] exercise5() {
        int[] arr = {-1, 5, 3, 2, 11, 4, 5, 2, 4, 8, -9, 1};
        int[] minMaxArr = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > minMaxArr[0]) {
                minMaxArr[0] = arr[i];
            } else if (arr[i] < minMaxArr[1]) {
                minMaxArr[1] = arr[i];
            }
        }
        return minMaxArr;
    }


    public static boolean checkBalance(int[] arr) {
        int leftSum = 0;
        int rightSum = 0;
        boolean bool = false;
        for (int i = 0; i < arr.length; i++) {
            leftSum = leftSum + arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                rightSum = rightSum + arr[j];
            }

            if (leftSum == rightSum) {
                bool = true;
                break;
            }
            rightSum = 0;
        }
        return bool;
    }

    public static int[] movArr(int[] arr, int a) {
        int temp = 0;
        if (a < 0) {
            for (int i = 0; i < Math.abs(a); i++) {
                for (int j = 0; j < (arr.length - 1); j++) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        } else if (a > 0) {
            for (int i = 0; i < a; i++) {
                for (int j = (arr.length - 1); j > 0; j--) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }

        }
        return arr;
    }

}



