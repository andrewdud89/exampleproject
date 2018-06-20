package gmail.pages;

import gmail.utills.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Администратор on 20.06.2018.
 */
public class TestAbout extends BasePage {
    @FindBy(xpath = "/html/body/nav/div/a[2]")
    private WebElement signIn;


    public void signIn() {
        signIn.click();
    }
}
