package br.com.agi.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.agi.core.DriverFactory;
import br.com.agi.elements.HomeElements;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final HomeElements elements;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.elements = new HomeElements();
    }

    public void open() {
        driver.get(DriverFactory.BASE_URL);
        wait.until(ExpectedConditions.urlContains("agibank"));
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.elementToBeClickable(elements.cookieConsentButton()));
            driver.findElement(elements.cookieConsentButton()).click();
        } catch (Exception e) {
        }
    }

    public void goToServicos() {
        wait.until(ExpectedConditions.elementToBeClickable(elements.menuServicos()));
        driver.findElement(elements.menuServicos()).click();
        wait.until(ExpectedConditions.urlContains("/servicos"));
    }

    public void goToSuasFinancas() {
        wait.until(ExpectedConditions.elementToBeClickable(elements.menuSuasFinancas()));
        driver.findElement(elements.menuSuasFinancas()).click();
        wait.until(ExpectedConditions.urlContains("/suas-financas"));
    }

    public boolean isServicosPageLoaded() {
        return !driver.findElements(elements.servicosPageTitle()).isEmpty();
    }

    public boolean isSuasFinancasPageLoaded() {
        return !driver.findElements(elements.suasFinancasPageTitle()).isEmpty();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
