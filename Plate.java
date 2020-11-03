package javaVvod.lesson7;

public class Plate {
    protected int food;

    public int getFood() {

        return food;
    }

    public void setFood(int food) {
        this.food += food;
        System.out.println("Добавлена еда в тарелку в количестве " + food + " Теперь там " + this.food);
    }

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void getFood(int food) {
        this.food -= food;
    }
}
