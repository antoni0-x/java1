package javaProfi.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework31 {

    //1. метод, который который преобразует массив в ArrayList;
    public static <T> ArrayList<T> arrToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    //2. метод, меняющий элементы массива местами
    public static <T> T[] changeElements(T[] arr) {
        T element = arr[1];
        arr[1] = arr[0];
        arr[0] = element;
        return arr;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4};
        Integer[] arr2 = {1, 2};
        System.out.println(arrToArrayList(arr1));
        System.out.println(Arrays.toString(changeElements(arr2)));


        //Большая задача

        FruitBox<Apple> appleFruitBox1 = new FruitBox<>(5, new Apple(), new Apple(), new Apple());
        FruitBox<Apple> appleFruitBox2 = new FruitBox<>(2);

        System.out.println("Вес фруктов в 1 коробке " + appleFruitBox1.getWeight());
        //пересыпаем фрукты из 1 коробки во сторую
        appleFruitBox1.transferFruitsToAntherBox(appleFruitBox2);

        System.out.println("В первой коробке осталось фруктов весом: " + appleFruitBox1.getWeight());
        System.out.println("Во второй коробке фруты весом: " + appleFruitBox2.getWeight());

        //добавляем фрукт в коробку 1
        appleFruitBox1.addFruit(new Apple());
        System.out.println("В первой коробке осталось фруктов весом: " + appleFruitBox1.getWeight());
    }
}





