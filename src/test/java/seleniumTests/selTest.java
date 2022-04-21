package seleniumTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pageObject.google.initPageObject;
import pageObject.google.searchResultPageObject;

public class selTest extends metTest {

    @Test
    @Epic("Selenium")
    @Feature("GoogleTests")
    @Story("CheckSearch")
    public void startTest() {

        getDriver().get("https://www.google.com/");
        getDriver().manage().window().maximize();

        initPageObject init = new initPageObject(getDriver());
        init.setSetSearchText("Привет");
        init.clickSubmitSearch();

        searchResultPageObject searchResultPageObject = new searchResultPageObject(getDriver());
        Assertion assertion = new Assertion();
        assertion.assertTrue(searchResultPageObject.istImagesTabButtonIsExist());
        searchResultPageObject.clickSubmitImages();

    }
}
