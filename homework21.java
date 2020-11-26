package javaProdv.lesson1;

public class homework21 {
    public static void main(String[] args) {
        IntrfAction[] cont = new IntrfAction[3];
        cont[0] = new Cat(2.3f, 300);
        cont[1] = new Human(2.5f, 500);
        cont[2] = new Robot(10f, 10000);
        IntrfPass[] pass = new IntrfPass[2];
        pass[0] = new Wall(2.4f);
        pass[1] = new Way(100f);

        cont[0].jump(pass[0].pass());
        cont[0].run(pass[1].pass());
        cont[1].jump(pass[0].pass());
        cont[1].run(pass[1].pass());
        cont[2].jump(pass[0].pass());
        cont[2].run(pass[1].pass());


    }


}
