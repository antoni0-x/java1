package javaVvod.lesson7;

public class Animal {
    public static int animalsCount;
    protected String name;
    protected int appetite;

    public Animal(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        animalsCount++;
    }

    public int getAppetite() {
            return appetite;

    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        if (appetite == 0 || (appetite > plate.getFood() && plate.getFood() < (appetite * 0.5))) {//кот не ест если
            // он полностью утолил свой аппетит, либо аппетит слишком большой (в два раза больше, чем заполнена тарелка)
            System.out.println(getName() + " не голоден");
        } else if (appetite < plate.getFood()) {
            System.out.println("Я, " + getName() + " пошел кушать. Аппетита у меня на " + appetite);
            plate.getFood(appetite);
            System.out.println("Я покушал " + appetite + ". Осталось в тарелке: " + plate.getFood());
            appetite -= appetite;
        } else if (appetite > plate.getFood()) {
            System.out.println("Я, " + getName() + " пошел кушать. Аппетита у меня на " + appetite);
            appetite -= plate.getFood();
            System.out.println("Я покушал " + plate.getFood() + ". Но еще бы съел еды в количестве:" + appetite);
            plate.food = 0;


        }
    }

}
