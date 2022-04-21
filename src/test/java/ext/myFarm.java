package ext;

public class myFarm {

    public static void main(String[] args) {
        Cat Sima = new Cat("Sima");

        Dog Zulka = new Dog("Zulka");

        Sima.eat();
        Sima.say();

        Zulka.eat();
        Zulka.say();

        System.out.println(Zulka.getName());
        Zulka.setName("Gerald");
        System.out.println(Zulka.getName());
        Zulka.getColor();
    }
}
