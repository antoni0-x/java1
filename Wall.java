package javaProdv.lesson1;

public class Wall implements IntrfPass {
    public float h;


    public Wall(float h) {
        this.h = h;

    }

    @Override
    public float pass() {
        return h;
    }
}
