package org.testinium.step;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriverException;
import org.testinium.Base.BaseTest;
import org.testinium.model.ElementInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseSteps extends BaseTest {


    public static int DEFAULT_MAX_ITERATION_COUNT = 50; //150
    public static int DEFAULT_MILLISECOND_WAIT_AMOUNT = 50; //100

    public BaseSteps() {
        initMap(getFileList());
    }

    private void clickElement(WebElement element) {
        element.click();
    }

    WebElement findElement(String key) {
        ElementInfo elementInfo = findElementInfoByKey(key);
        if (elementInfo == null) {
            logger.error("ElementInfo bulunamadi, key: {}", key);
            throw new NoSuchElementException("ElementInfo bulunamadi, key: " + key);
        }
        By infoParam = getElementInfoToBy(elementInfo);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        WebElement webElement = webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(infoParam));

        if (webElement == null) {
            logger.error("Web element bulunamadi, key: {}", key);
            throw new NoSuchElementException("Web element bulunamadi, key: " + key);
        }

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
        return webElement;
    }


    List<WebElement> findElements(String key) {
        return driver.findElements(getElementInfoToBy(findElementInfoByKey(key)));
    }

    public By getElementInfoToBy(ElementInfo elementInfo) {
        By by = null;
        if (elementInfo.getType().equals("css")) {
            by = By.cssSelector(elementInfo.getValue());
        } else if (elementInfo.getType().equals(("name"))) {
            by = By.name(elementInfo.getValue());
        } else if (elementInfo.getType().equals("id")) {
            by = By.id(elementInfo.getValue());
        } else if (elementInfo.getType().equals("xpath")) {
            by = By.xpath(elementInfo.getValue());
        } else if (elementInfo.getType().equals("linkText")) {
            by = By.linkText(elementInfo.getValue());
        } else if (elementInfo.getType().equals(("partialLinkText"))) {
            by = By.partialLinkText(elementInfo.getValue());
        }
        return by;
    }

    @Step("<key> elementine <text> textini yaz")
    public void ssendKeys(String key, String text) {
        if (!key.equals("")) {
            findElement(key).sendKeys(text);
            logger.info(key + " elementine " + text + " texti yazildi.");
        }
    }

    @Step("<key> Elementine tıkla")
    public void clickElement(String key) {
        if (!key.isEmpty()) {
            //hoverElement(findElement(key));
            clickElement(findElement(key));
            logger.info(key + " elementine tiklandi.");
        }
    }

    @Step("<url> adresine git")
    public void goToUrl(String url) {
        driver.navigate().to(url);
        Gauge.writeMessage("Page title is %s", driver.getTitle());
        Gauge.captureScreenshot();
    }

    @Step("<saniye> saniye bekle")
    public void bekle(int saniye) throws InterruptedException {
        Thread.sleep(saniye * 1000);
    }

    public void javascriptclicker(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    @Step("<key> elementine javascript ile tıkla")
    public void clickToElementWithJavaScript(String key) {
        WebElement element = findElement(key);
        javascriptclicker(element);
        logger.info(key + " elementine javascript ile tiklandi");
    }

    public WebElement findElementWithKey(String key) {
        return findElement(key);
    }

    @Step({"Wait <value> milliseconds",
            "<long> milisaniye bekle"})
    public void waitByMilliSeconds(long milliseconds) {
        try {
            logger.info(milliseconds + " milisaniye bekleniyor.");
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step({"Check if element <key> exists",
            "Element var mı kontrol et <key>"})
    public WebElement getElementWithKeyIfExists(String key) {
        WebElement webElement;
        int loopCount = 0;
        while (loopCount < DEFAULT_MAX_ITERATION_COUNT) {
            try {
                webElement = findElementWithKey(key);
                logger.info(key + " elementi bulundu.");
                return webElement;
            } catch (WebDriverException e) {
            }
            loopCount++;
            waitByMilliSeconds(DEFAULT_MILLISECOND_WAIT_AMOUNT);
        }
        Assertions.assertTrue(true, "Element Bulunamadi!");
        logger.info(key + " elementi bulundu.");
        return null;
    }
    @Step("<key> elementi gorunur mu kontrol et")
    public void checkElementwithEnable(String key) {
        assertTrue(findElement(key).isEnabled());
        logger.info(key + " elementi gorunur durumda");
    }

    @Step({"<text> textini <key> elemente tek tek yaz",
            "Write <text> to element <key> OnebyOne"})
    public void sendKeyOneByOne(String text, String key) throws InterruptedException {
        WebElement field = findElement(key);
        field.clear();
        if (!key.equals("")) {
            for (char ch : text.toCharArray())
                findElement(key).sendKeys(Character.toString(ch));
            Thread.sleep(10);
            logger.info(key + " elementine " + text + " texti karakterler tek tek girlilerek yazıldı.");
        }
    }
}

























