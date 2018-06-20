package gmail.utills;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;


public class Base {

    private static WebDriver driver;

    public static void shutDownDriver() {
        if (driver != null) {
            driver.quit();
        }

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = TestProperties.getTestProperty("browser");
            if ("firefox".equals(browser)) {
                System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Geck\\geckodriver.exe");
                driver = new FirefoxDriver();
                maximizeWindow();
            }
            if ("chrome".equals(browser)) {
                driver = new ChromeDriver();
            }
            driver.manage()
                    .timeouts()
                    .implicitlyWait(TestProperties.getWaitTime(),
                            TimeUnit.SECONDS);
            driver.manage()
                    .timeouts()
                    .pageLoadTimeout(
                            Integer.parseInt(TestProperties
                                    .getTestProperty("wait.page.load")),
                            TimeUnit.SECONDS);
        }
        return driver;
    }

    private static void maximizeWindow() {
        driver.manage().window().setPosition(new Point(0, 0));
        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit()
                .getScreenSize();
        Dimension dim = new Dimension((int) screenSize.getWidth(),
                (int) screenSize.getHeight());
        driver.manage().window().setSize(dim);
    }

    public static void openRelativeUrl(String relativeUrl) {
        getDriver().get(relativeUrl);
    }

}
