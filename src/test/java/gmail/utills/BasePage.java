package gmail.utills;


import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;


public abstract class BasePage {

    private WebDriver webDriver;

    public void open(String url) {
        webDriver.get(url);
    }


    public boolean isElementVisible(WebElement locator) {
        try {
            locator.isDisplayed();
            return true;
        } catch (ElementNotVisibleException ignored) {
            return false;
        } catch (NoSuchElementException ignored) {
            return false;
        } catch (StaleElementReferenceException ignored) {
            return false;
        }
    }

    public boolean isElementVisible(By by) {
        try {
            webDriver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        } catch (ElementNotVisibleException ignored) {
            return false;
        } catch (StaleElementReferenceException ignored) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement locator) {
        try {
            locator.getTagName();
        } catch (NoSuchElementException ignored) {
            return false;
        } catch (StaleElementReferenceException ignored) {
            return false;
        }
        return true;
    }

    public boolean isElementPresent(By by) {
        try {
            webDriver.findElement(by);
            return true;
        } catch (NoSuchElementException ignored) {
            return false;
        } catch (StaleElementReferenceException ignored) {
            return false;
        }
    }

    public boolean isElementTextPresent(By by, String text) {
        try {
            if (webDriver.findElement(by).getText().equals(text)) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementTextPresent(WebElement element, String text) {
        try {
            if (element.getText().equals(text)) {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public boolean isTextPresent(String text) {
        return webDriver.findElement(By.tagName("body")).getText().contains(text);
    }

    public void close() {
        webDriver.quit();
    }

    public void acceptConfirmation() {
        webDriver.switchTo().alert().accept();
    }

    public boolean isTableHeadersPresent(List<String> headerText) {
        List<WebElement> headers = webDriver.findElements(By.xpath("//th"));
        return isHeaderTextEquals(headerText, headers);
    }

    protected boolean isHeaderTextEquals(List<String> headerText, List<WebElement> headers) {
        if (headers.size() != headerText.size()) {
            return false;
        }

        for (int i = 0; i < headers.size(); i++) {
            WebElement webElement = headers.get(i);
            String text = headerText.get(i);
            if (!isElementTextPresent(webElement, text)) {
                return false;
            }
        }
        return true;
    }

    protected Function<WebDriver, Boolean> visibilityOfElement(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();
            }
        };
    }

    protected Function<WebDriver, Boolean> hiddentOfElement(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver arg0) {
                return !element.isDisplayed();
            }
        };
    }

    protected void sleep() {
        try {
            Thread.sleep(Integer.parseInt(TestProperties.getTestProperty("wait.hack.msec")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void clickAt(WebElement webElement, int x, int y) {
        Actions builder = new Actions(webDriver);
        Action action = builder.moveToElement(webElement, x, y).click().build();
        action.perform();
    }


}
