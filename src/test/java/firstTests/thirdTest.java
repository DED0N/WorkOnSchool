package firstTests;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class thirdTest extends baseTests {
    String firstParam = "Кто виноват";
    String secondParam = "noBody";

    @Parameters({"firstParam", "secondParam"})

    @Test

    public void startTest(String firstParam, String secondParam) {
        System.out.println("Первый параметр: " + firstParam);
        System.out.println("Второй параметр: " + secondParam);
        System.out.println("Но на самом деле " + this.firstParam + " " + this.secondParam);

        this.firstParam = firstParam;
        this.secondParam = secondParam;
    }

    @Test()

    public void startTest() {
        System.out.println(firstParam);
        System.out.println(secondParam);
        System.out.println("Но на самом деле " + this.firstParam + " " + this.secondParam);

    }

    @Test()

    public void startTestVersionTwo() {

        forConstructor con = new forConstructor();
        System.out.println(firstParam);
        System.out.println(secondParam);
        System.out.println("Но на самом деле " + con.constParam1 + " " + con.consParam2);

    }


}
