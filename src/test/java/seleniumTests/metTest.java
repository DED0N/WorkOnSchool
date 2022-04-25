package seleniumTests;

import com.codeborne.selenide.Browser;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObject.Common;
import utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class metTest {

    WebDriver driver;
    protected Common common = new Common();
    //public String setStandKey = System.setProperty("standKey", "stand2");
    //public String setBrowserVersion = System.setProperty("selectBrowser", "browserFFVersion");
    //public String setBrowserName = System.setProperty("selectBrowserName", "browserFFName");
    public String standKey = System.getProperty("standKey");
    public String standURL = PropertyLoader.loadProperty(standKey);
    public String getPropertyBrowserVersion = System.getProperty("selectBrowser");
    public String selectBrowserVersion = PropertyLoader.loadPropertyBrowser(getPropertyBrowserVersion);
    public String getPropertyBrowserName = System.getProperty("selectBrowserName");
    public String selectBrowserName  = PropertyLoader.loadPropertyBrowser(getPropertyBrowserName);


    @BeforeTest
    public void beforeTest() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

/*       System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        driver = new ChromeDriver();*/

        capabilities.setBrowserName(selectBrowserName);
        capabilities.setCapability("version", selectBrowserVersion);

        URL hub = null;
        try {
            hub = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new RemoteWebDriver(hub, capabilities);


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
