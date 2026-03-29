package br.com.agi.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.agi.actions.HomeActions;
import br.com.agi.core.DriverFactory;
import br.com.agi.elements.HomeElements;

public class HomePage {

    private final WebDriver driver;
    private final HomeActions actions;
    private final WebDriverWait wait;
    private final HomeElements elements;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new HomeActions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.elements = new HomeElements();
    }

    public void open() {
        driver.get(DriverFactory.BASE_URL);
        wait.until(ExpectedConditions.urlContains("agibank"));
    }

    public void goToServicos() {
        wait.until(ExpectedConditions.elementToBeClickable(elements.menuServicos()));
        actions.clickServicos();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        wait.until(ExpectedConditions.urlContains("/servicos"));
    }

    public void goToSuasFinancas() {
        wait.until(ExpectedConditions.elementToBeClickable(elements.menuSuasFinancas()));
        actions.clickSuasFinancas();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
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
