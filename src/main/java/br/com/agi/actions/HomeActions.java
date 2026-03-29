package br.com.agi.actions;

import br.com.agi.elements.HomeElements;
import org.openqa.selenium.WebDriver;

public class HomeActions {

    private final WebDriver driver;
    private final HomeElements elements;

    public HomeActions(WebDriver driver) {
        this.driver = driver;
        this.elements = new HomeElements();
    }

    public void clickServicos() {
        driver.findElement(elements.menuServicos()).click();
    }

    public void clickSuasFinancas() {
        driver.findElement(elements.menuSuasFinancas()).click();
    }
}
