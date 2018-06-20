package gmail.steps;


import gmail.pages.TestAbout;
import gmail.pages.TestSignIn;
import gmail.utills.Base;
import gmail.utills.BasePage;
import gmail.utills.BaseStep;
import gmail.utills.PageFactoryEx;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static gmail.utills.Base.getDriver;

/**
 * Created by Администратор on 18.06.2018.
 */
public class SigInPageSteps  {
    private TestSignIn signInPage = PageFactoryEx.init(Base.getDriver(),TestSignIn.class);

    public void fillPhoneOrEmailAndNext(String emailOrPhone) {
        signInPage.fillEmailPhone(emailOrPhone);
        signInPage.pressEmailNext();
    }
    public void fillPasswordAndNext(String password) {
        signInPage.fillPassword(password);
        signInPage.pressPasswordNext();
    }
    public String getErrorMessage(){
        return signInPage.getErrorMesage();
    }


}
