package firstTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class secondTest {


    @DataProvider(name = "setEnvironment", parallel = true)
    public Object[][] getData() {
        Object[][] browserVersion = new Object[][]{
                {"Chrome", "95"},
                {"Yandex", "13"}
        };
        return browserVersion;
    }

    @Test
    public void startTest() {
        System.out.println("Запуск теста");
    }

    @Test(dataProvider = "setEnvironment")

    public void startTest(String browser, String version) {
        System.out.println("Баузер: " + browser + "= " + version);

        Assertion asert = new Assertion();
        asert.assertTrue(version.equalsIgnoreCase("95"));
    }
}
