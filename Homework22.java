package javaProdv.lesson2;

public class Homework22 {
    public static int sum = 0;

    public static void main(String[] args){

        final String arr[][] = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };


        final String arr2[][] = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        final String arr3[][] = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        final String arr4[][] = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "A"},
                {"1", "2", "3", "4"}
        };

        try {
            vvod(arr);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            vvod(arr2);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            vvod(arr3);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            vvod(arr4);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static void vvod(String arr[][]) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        System.out.println("Успешно");
        if (sum != 0) {
            System.out.println("Сумма ячеек равна " + sum);
        }

    }
}

class MyArraySizeException extends RuntimeException {
}

class MyArrayDataException extends RuntimeException {
    private int i = 0;
    private int j = 0;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
        System.out.println("Ошибка в ячейке: " + (i + 1) + ", " + (j + 1));
    }
}


