package javaVvod.lesson3;

import java.util.Random;
import java.util.Scanner;


public class homework3 {

    public static void main(String[] args) {

        playOne();
        playTwo();

    }

    public static void playOne() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int attempts = 3;
        int doPlay = 1;
        while (doPlay == 1) {
            int number = random.nextInt(9);
            for (int i = 0; i < attempts; i++) {
                System.out.println("Введите число от 0 до 9. У вас осталось " + (attempts - i) + " попыток");
                int x = scanner.nextInt();
                if (x == number) {
                    System.out.println("Выиграли!");
                    break;
                } else if (x < number) {
                    System.out.println("Не верно! Введенное число меньше чем загаданное.");
                    continue;
                } else if (x > number) {
                    System.out.println("Не верно! Введенное число больше чем загаданное.");
                    continue;
                }
            }
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет (1 – повторить, 0 – нет)");
            doPlay = scanner.nextInt();
        }
        System.out.println("Игра окончена!");
    } 

    public static void playTwo() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String wordFromArr = words[random.nextInt(words.length)];
        System.out.println("Загадайте слово из предложенных: \"apple\", \"orange\", \"lemon\", \"banana\", \"apricot\", \"avocado\", \"broccoli\", \"carrot\", \"cherry\", \"garlic\", \"grape\", \"melon\", \"leak\" \n, \"kiwi\", \"mango\", \"mushroom\", \"nut\", \"olive\", \"pea\", \"peanut\", \"pear\", \"pepper\", \"pineapple\", \"pumpkin\", \"potato\"");
        System.out.println("Или введите exit");


        while (true) {
            String word = scanner.nextLine();
            if (word.equals("exit")) {
                break;
            }
            if (word.equals(wordFromArr)) {
                System.out.println("Вы угадали!");
                break;
            } else {
                wordEquals(wordFromArr, word);
                System.out.println(" Вы не угадали( Попробуйте еще раз.");
                continue;
            }

        }
    }

    public static void wordEquals(String wordFromArr, String word) {
        int numOfLetter = 1;
        for (int i = 0; i < wordFromArr.length() && i < word.length(); i++) {
            if (word.charAt(i) == wordFromArr.charAt(i)) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print('#');
            }
            numOfLetter++;
        }
        while (numOfLetter <= 15) {
            System.out.print('#');
            numOfLetter++;
        }

    }

}

