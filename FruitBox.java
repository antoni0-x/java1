package javaProfi.lesson1;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class FruitBox<T extends Fruit> {
    private final List<T> container;
    private int capacity;

    public FruitBox(int capacity, T... fruits) {
        this.container = new ArrayList<>(Arrays.asList(fruits));
        this.capacity = capacity;
    }

    //получаем вес общий фруктов в корзине
    public float getWeight() {
        float commonWeight = 0.0f;
        for (T fruit : container) {
            commonWeight += fruit.getWeight();
        }
        return commonWeight;

    }

    // сравниваем вес фруктов в коробке с весом фруктов в другой коробке
    public boolean weightCompare(FruitBox<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.01;

    }

    //метод пересыпания фруктов из коробки в коробку
    public void transferFruitsToAntherBox(FruitBox<T> anotherBox) {
        if (anotherBox == this) return;

        int countSize = Math.min(container.size(), anotherBox.capacity);
        List<T> fruits = container.subList(0, countSize);
        anotherBox.container.addAll(fruits);
        container.removeAll(fruits);
        anotherBox.capacity -= countSize;
        capacity += countSize;

    }

    public void addFruit(T fruit) {
        if (capacity - 1 > 0) {
            container.add(fruit);
            capacity--;
        }
    }
}
