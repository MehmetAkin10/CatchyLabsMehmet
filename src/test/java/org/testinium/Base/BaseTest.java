package org.testinium.Base;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariOptions;
import org.testinium.model.ElementInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class BaseTest {

    public static WebDriver driver;
    String browser="chrome";
    private static final String DEFAULT_DIRECTORY_PATH = "elementValues";
    ConcurrentMap<String, Object> elementMapList = new ConcurrentHashMap<>();
    protected Logger logger = LoggerFactory.getLogger(getClass());


    @BeforeScenario
    public void setUp(){

        if (driver == null) {

            if("chrome".equalsIgnoreCase(browser)) {

                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--kiosk");
                driver = new ChromeDriver(chromeOptions);

            }

            if("firefox".equalsIgnoreCase(browser)) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.addArguments("--kiosk");
                driver = new FirefoxDriver(firefoxOptions);
            }
            if("edge".equalsIgnoreCase(browser)) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setPageLoadStrategy("--disable-notifications");
                edgeOptions.setPageLoadStrategy("--kiosk");
                driver = new EdgeDriver(edgeOptions);
            }

        }
        driver.manage().window().maximize();
    }

    @AfterScenario
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void initMap(File[] fileList) {
        Type elementType = new TypeToken<List<ElementInfo>>() {}.getType();
        Gson gson = new Gson();
        List<ElementInfo> elementInfoList;
        for (File file : fileList) {
            try {
                elementInfoList = gson.fromJson(new FileReader(file), elementType);
                if (elementInfoList != null) {
                    elementInfoList.parallelStream()
                            .forEach(elementInfo -> elementMapList.put(elementInfo.getKey(), elementInfo));
                } else {
                    logger.warn("ElementInfo list is null for file: {}", file.getName());
                }
            } catch (FileNotFoundException e) {
                logger.warn("File not found: {}", e);
            } catch (Exception e) {
                logger.error("Error reading JSON file: {}", file.getName(), e);
            }
        }
    }

    public File[] getFileList() {
        File directory = new File(this.getClass().getClassLoader().getResource(DEFAULT_DIRECTORY_PATH).getFile());
        if (directory == null || !directory.exists()) {
            logger.warn("File Directory Is Not Found! Please Check Directory Location. Default Directory Path = {}", DEFAULT_DIRECTORY_PATH);
            throw new NullPointerException("Directory not found: " + DEFAULT_DIRECTORY_PATH);
        }

        File[] fileList = directory.listFiles(pathname -> !pathname.isDirectory() && pathname.getName().endsWith(".json"));
        if (fileList == null) {
            logger.warn("No JSON files found in directory: {}", DEFAULT_DIRECTORY_PATH);
            throw new NullPointerException("No JSON files found in directory.");
        }
        return fileList;
    }

    public ElementInfo findElementInfoByKey(String key) {
        return (ElementInfo) elementMapList.get(key);
    }
}
