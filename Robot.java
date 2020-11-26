package javaProdv.lesson1;

public class Robot implements IntrfAction{

    private float maxH;
    private float distanse;

    public Robot(float maxH, float distanse) {
        this.maxH = maxH;
        this.distanse = distanse;
    }


    @Override
    public void run(float dist) {
        if (dist > distanse) {
            System.out.println("Слишком далеко бежать");
        } else {
            System.out.println("Пробежал на " + dist + " метров");
        }
    }

    @Override
    public void jump(float h) {
        if (h > maxH) {
            System.out.println("Слишком высоко");
        } else {
            System.out.println("Подпрыгнул на " + maxH + " метра");
        }
    }
}