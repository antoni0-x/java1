package javaVvod.lesson7;

public class homework7 {
    public static void main(String[] args) {
        Cat[] myCat = new Cat[3]; //массив котов
        myCat[0] = new Cat("Пушистик1", 100);
        myCat[1] = new Cat("Пушистик2", 200);
        myCat[2] = new Cat("Пушистик3", 300);
        Plate plate = new Plate(0);
        plate.setFood(210);//добавляем еду


        myCat[0].eat(plate);
        myCat[1].eat(plate);
        myCat[2].eat(plate);

        plate.setFood(310);//добавляем опять еду

        myCat[2].eat(plate); //даем шанс наесться пушистику 3
        myCat[1].eat(plate); //даем шанс наесться пушистику 2
        myCat[0].eat(plate); //ну и пушистику 1 предложим тоже

        System.out.println("Кот " + myCat[0].getName() + " еще бы поел " + myCat[0].getAppetite());
        System.out.println("Кот " + myCat[1].getName() + " еще бы поел " + myCat[1].getAppetite());
        System.out.println("Кот " + myCat[2].getName() + " еще бы поел " + myCat[2].getAppetite());
    }
}
