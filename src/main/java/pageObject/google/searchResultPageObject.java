package pageObject.google;

import io.qameta.allure.Step;
import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.base;

public class searchResultPageObject extends base {

    @FindBy(xpath = ".//a[contains(., 'Картинки')]")
    private WebElement imagesTab;

    @FindBy(xpath = ".//a[contains(., 'Картинки')]")
    private WebElement submitImages;

    public searchResultPageObject(WebDriver driver) {
        super(driver);
    }

    /**
     * Проверяем, что кнопка картинки существует на странице
     * @return
     */
    @Step("Check that images is true")
    public boolean istImagesTabButtonIsExist(){
        return waitVisibleElement(imagesTab);
    }

    public void clickSubmitImages(){
        click(submitImages);
    }




}
