package seleniumTests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObject.Common;
import utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class metTest {

    WebDriver driver;
    protected Common common = new Common();
    public String setStandKey = System.setProperty("standKey", "stand1");
    public String standKey = System.getProperty("standKey");
    public String standURL = PropertyLoader.loadProperty(standKey);

    @BeforeTest
    public void beforeTest() {
        // FirefoxOptions firefoxOptions = new FirefoxOptions();
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();

        /*firefoxOptions.setCapability("version", "97.0");
        URL hub = null;
        try {
            hub = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new RemoteWebDriver(hub, firefoxOptions);*/


        // chromeOptions.setCapability("version", "100.0");
        
/*        URL hub = null;

        try {
            hub = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new RemoteWebDriver(hub, chromeOptions);*/
    }


    @AfterTest
    public void afterTest() {
        getScreenShots();
        driver.quit();
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Attachment(value = "Screenshot result", type = "image/png")
    public byte[] getScreenShots() {

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
