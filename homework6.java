package javaVvod.lesson6;

public class homework6 {

    public static void main(String[] args) {
        Animals animal = new Animals("Чупакабра");
        Cats cat1 = new Cats("Барсик");
        Cats cat2 = new Cats("Мурзик");
        Cats cat3 = new Cats("Ванька");
        Dogs dog1 = new Dogs("Мишка");
        Dogs dog2 = new Dogs("Тузик");

        animal.name();
        animal.jump(2);
        animal.run(200);
        animal.swim(10);

        cat1.name();
        cat1.jump(2);
        cat1.run(200);
        cat1.swim(10);

        cat2.name();
        cat2.jump(3);
        cat2.run(200);
        cat2.swim(10);

        cat3.name();
        cat3.jump(5);
        cat3.run(300);
        cat3.swim(10);


        dog1.name();
        dog1.jump(0.5);
        dog1.run(200);
        dog1.swim(20);

        dog2.name();
        dog2.jump(0.5);
        dog2.run(100);
        dog2.swim(8);

        System.out.println("Всего в соревнованиях учавствовало " + Animals.sumAnimals + " животных");


    }
}
