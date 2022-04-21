package firstTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class baseTests {

    @BeforeTest

    public void beforeT() {
        System.out.println("Действие перед началом теста");
    }

    @AfterTest

    public void afterT() {
        System.out.println("Действие после начала теста");
    }

    @BeforeMethod

    public void beforeM() {
        System.out.println("Действие перед началом метода");
    }

    @AfterMethod

    public void afterM() {
        System.out.println("Действие после начала метода");
    }
}
