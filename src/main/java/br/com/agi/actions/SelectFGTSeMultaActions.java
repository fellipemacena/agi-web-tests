package br.com.agi.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.agi.elements.SelectFGTSeMultaElements;

public class SelectFGTSeMultaActions {

    private final WebDriver driver;
    private final SelectFGTSeMultaElements elements;

    public SelectFGTSeMultaActions(WebDriver driver) {
        this.driver = driver;
        this.elements = new SelectFGTSeMultaElements();
    }

    public String getFeaturedArticleText() {
        return driver.findElement(elements.featuredArticleLink()).getText().trim();
    }

    public void clickFeaturedArticle() {
        WebElement featuredArticle = driver.findElement(elements.featuredArticleLink());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", featuredArticle);
        try {
            featuredArticle.click();
        } catch (Exception ex) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", featuredArticle);
        }
    }
}
