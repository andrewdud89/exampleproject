package gmail.pages;

import gmail.utills.Base;
import gmail.utills.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Администратор on 20.06.2018.
 */
public class TestSignIn extends BasePage {
    @FindBy(id = "identifierId")
    private WebElement emailPhoneElement;

    @FindBy(id = "identifierNext")
    private WebElement nextEmailElement;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwordElement;


    @FindBy(id = "passwordNext")
    private WebElement nextPasswordElement;

    @FindBy(xpath = "//*[@id=\"password\"]/div[2]/div[2]")
    private WebElement errorMessageElement;


    public void fillEmailPhone(String emailOrPhone) {
        emailPhoneElement.sendKeys(emailOrPhone);
    }

    public void pressEmailNext() {
        nextEmailElement.click();
    }

    public void fillPassword(String password) {
        passwordElement.sendKeys(password);

    }


    public void pressPasswordNext() {
        JavascriptExecutor executor = (JavascriptExecutor) Base.getDriver();
        executor.executeScript("arguments[0].click();", nextPasswordElement);
    }

    public String getErrorMesage() {
        return errorMessageElement.getText();
    }
}
