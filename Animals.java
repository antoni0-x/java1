package javaVvod.lesson6;

public class Animals {
    protected String name;
    public static int sumAnimals;


    public Animals(String name) {
        this.name = name;
        sumAnimals++;

    }

    public void name (){
        System.out.println("Животное зовут " + name);
    }


    public void jump(double jump){
        System.out.println(name + " прыгнул на " + jump + " метра");
    }


    public void run(double run){
        System.out.println(name + " пробежал " + run + " метра");
    }


    public void swim(double swim){
        System.out.println(name + " проплыл " + swim + " метра");

    }


}



