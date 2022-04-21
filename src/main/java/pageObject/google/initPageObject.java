package pageObject.google;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.base;

public class initPageObject extends base {
    @FindBy(xpath = ".//input[@title='Поиск' and @aria-label]")
    private WebElement searchText;

    @FindBy(xpath = "(.//input[@value='Поиск в Google'])[1]")
    private WebElement submitSearch;

    public initPageObject(WebDriver driver) {
        super(driver);
    }


    /**
     * Вводим текст в строку поиска.
     * @param text
     */
    @Step("Enter text to search")
    public void setSetSearchText(String text) {
        setText(searchText, text);
    }

    @Step("Click to button search")
    public void clickSubmitSearch(){
        click(submitSearch);
    }

/*    public void setAndClick(String text){
        setSetSearchText(text);
        click(submitSearch);
        clickSubmitSearch();
    }*/
}
