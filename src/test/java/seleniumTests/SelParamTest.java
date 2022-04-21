package seleniumTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pageObject.google.initPageObject;
import pageObject.google.searchResultPageObject;
import testData.WordsTestData;


public class SelParamTest extends metTest {

    @DataProvider(name = "setWords")
    public Object[][] getData() {
        Object[][] words = new Object[][]{
                {new WordsTestData("word").getWord1(), "word1"},
                {new WordsTestData("word").getWord2(), "word2"},
                {new WordsTestData("word").getWord3(), "word3"},
        };
        return words;
    }

    @Test(dataProvider = "setWords")
    @Epic("Selenium")
    @Feature("GoogleTests")
    @Story("CheckSearchWithParams")
    @Description("Words")
    public void startTest(String word, String testName) {
        common.logToReport("link to stand: " + standURL);
        getDriver().get(standURL);
        getDriver().manage().window().maximize();

        initPageObject init = new initPageObject(getDriver());
        init.setSetSearchText(word);
        init.clickSubmitSearch();

        searchResultPageObject searchResultPageObject = new searchResultPageObject(getDriver());
        Assertion assertion = new Assertion();
        assertion.assertTrue(searchResultPageObject.istImagesTabButtonIsExist());
        searchResultPageObject.clickSubmitImages();

/*        File file = new File("./src/main/resources/" + testName + ".jpg");
        try {
            FileUtils.writeByteArrayToFile(file, getScreenShots());
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
