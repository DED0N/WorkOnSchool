package ext;


public class Dog extends Animals implements animaColor {

    public Dog(String name) {
        super(name);
    }

    public void say() {
        System.out.println("Gav");
    }

    @Override
    public void getColor() {

    }
}
