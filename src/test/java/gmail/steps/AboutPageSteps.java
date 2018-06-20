package gmail.steps;


import gmail.pages.TestAbout;
import gmail.utills.PageFactoryEx;
import org.openqa.selenium.support.PageFactory;

import static gmail.utills.Base.getDriver;

/**
 * Created by Администратор on 18.06.2018.
 */
public class AboutPageSteps {
    private TestAbout aboutPage = PageFactoryEx.init(getDriver(), TestAbout.class);


    public TestAbout getAboutPage() {
        return aboutPage;
    }

    public void signIn() {
        aboutPage.signIn();
    }

}
