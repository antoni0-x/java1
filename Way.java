package javaProdv.lesson1;

public class Way implements IntrfPass {
    public float dist;


    public Way(float dist) {
        this.dist = dist;

    }

    @Override
    public float pass() {
        return dist;
    }
}
