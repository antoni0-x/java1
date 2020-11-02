package javaVvod.lesson6;

public class Dogs extends Animals{
    public Dogs(String name){
        super(name);

    }



    @Override
    public void jump(double jump){

        if (jump>0.5d){
            System.out.println("Слишком высокое препятствие для собаки");
        } else System.out.println(name + " прыгнул на " + jump + " метра");
    }

    @Override
    public void run(double run){
        if (run>500){
            System.out.println("Слишком длинная дистанция для собаки");
        } else System.out.println(name + " пробежал " + run + " метра");
    }

    @Override
    public void swim(double swim){
        if (swim>10){
        System.out.println("Так далеко собака не сможет уплыть");
        } else System.out.println(name + " проплыл " + swim + " метра");

    }

}
