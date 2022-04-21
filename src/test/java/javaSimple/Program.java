package javaSimple;

public class Program {

    public static void main(String[] args) {
        int num = 3;
        System.out.println("Hello Epta");
        System.out.println(helpedMEthods.arg);
        System.out.println("Сумма " + num + " + " + num + " = " + helpedMEthods.sum(num, num));

        String qwe = new String("qwe");
        boolean result = qwe == helpedMEthods.arg;
        System.out.println(result);

        boolean result2 = qwe.equalsIgnoreCase(helpedMEthods.arg);
        System.out.println(result2);

        num = 5;

        helpedMEthods hp = new helpedMEthods();

        hp.switchRadio("Afro");
        System.out.println("Частота радио = " + hp.switchRadio("Afro"));

        int index = 100;
        for (int x = 0; x <= index; x++) {
            x = x + 30;
            System.out.println(x);
        }


    }
}
