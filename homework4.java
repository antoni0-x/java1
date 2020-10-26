package javaVvod.lesson4;

import java.util.Random;
import java.util.Scanner;

public class homework4 {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int[] doNotWin = {0, 0}; //массив для хранения координат ячейки, куда компьютеру нужно походить, чтобы заблокировать ход

    public static void main(String[] args) {

        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {
        int sum = 0;
        doNotWin[0] = 0; //обнуляем массив с координатами блокировки хода
        doNotWin[1] = 0;
        for (int i = 0; i < (SIZE * 4); i++) { //цикл пробегает игровое поле 4 раза, чтобы проверить горизонтали, вертикали, диагональ 1, диагональ 2
            if (i < SIZE) { //проверка по горизонталям
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == symb) sum++;
                    if (sum == (DOTS_TO_WIN - 1)) { //передача компьютеру условий для блокировки хода (т.к. в задании не
                        // сказано все ли ходы игрока нужно блокировать, здесь и далее ограничимся блокировкой хода ПОСЛЕ последовательности иксов
                        doNotWin[0] = i;
                        doNotWin[1] = j + 1;
                    }
                    if (j < (SIZE - 1) && map[i][j + 1] != symb) break; // проверка происходит до первого разрыва в последовательности символов

                }
            }
            if (SIZE <= i && i < (SIZE * 2)) { //проверка по вертикалям
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][i - SIZE] == symb) sum++;
                    if (sum == (DOTS_TO_WIN - 1)) {
                        doNotWin[0] = j + 1;
                        doNotWin[1] = i - SIZE;
                    }
                    if (j < (SIZE - 1) && map[j + 1][i - SIZE] != symb) break;
                }
            }
            if (i >= (SIZE * 2)) { //проверка по диагонали 1
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][j] == symb) sum++;
                    if (sum == (DOTS_TO_WIN - 1)) {
                        doNotWin[0] = j + 1;
                        doNotWin[1] = j + 1;
                    }
                    if (j < (SIZE - 1) && map[j + 1][j + 1] != symb) break;
                }
            }
            if (i >= (SIZE * 3)) { //проверка по диагонали 2
                sum = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][(SIZE - 1) - j] == symb) sum++;
                    if (sum == (DOTS_TO_WIN - 1)) {
                        doNotWin[0] = j + 1;
                        doNotWin[1] = SIZE - j - 2;
                    }
                    if (j < (SIZE - 1) && map[j + 1][(SIZE - 2) - j] != symb) break;
                }
            }
            if (sum >= DOTS_TO_WIN) return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        if ((doNotWin[0] == 0 && doNotWin[1] == 0) || map[doNotWin[0]][doNotWin[1]] != DOT_EMPTY) {
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x, y));
        } else {
            x = doNotWin[1];
            y = doNotWin[0];
        }
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


