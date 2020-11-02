package javaVvod.lesson6;

public class Cats extends Animals{


    public Cats(String name){
        super(name);

    }



    @Override
    public void jump(double jump){

        if (jump>2){
            System.out.println("Слишком высокое препятствие для кота");
        } else System.out.println(name + " прыгнул на " + jump + " метра");
    }

    @Override
    public void run(double run){
        if (run>200){
            System.out.println("Слишком длинная дистанция для кота");
        } else System.out.println(name + " пробежал " + run + " метра");
    }

    @Override
    public void swim(double swim){
       System.out.println("Коты не плавают (");

    }

}
