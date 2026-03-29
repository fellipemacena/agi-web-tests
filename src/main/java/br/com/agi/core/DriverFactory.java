package br.com.agi.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    public static final String BASE_URL = "https://blog.agibank.com.br";
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            String chromePath = System.getenv("CHROME_PATH");
            String browserVersionMajor = System.getenv("BROWSER_VERSION_MAJOR");
            if (browserVersionMajor != null && !browserVersionMajor.isEmpty()) {
                WebDriverManager.chromedriver().browserVersion(browserVersionMajor).setup();
            } else {
                WebDriverManager.chromedriver().setup();
            }
            if (chromePath != null && !chromePath.isEmpty()) {
                options.setBinary(chromePath);
            }

            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            options.addArguments("--window-size=1920,1080");
            boolean isHeadless = !"true".equalsIgnoreCase(System.getenv("NOHEADLESS"));
            if (isHeadless) {
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
            }

            driver = new ChromeDriver(options);

            if (!isHeadless) {
                driver.manage().window().maximize();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}