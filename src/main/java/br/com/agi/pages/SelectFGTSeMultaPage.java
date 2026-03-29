package br.com.agi.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.agi.actions.SelectFGTSeMultaActions;
import br.com.agi.core.DriverFactory;
import br.com.agi.elements.SelectFGTSeMultaElements;

public class SelectFGTSeMultaPage {

    public static final String EXPECTED_ARTICLE_TITLE = "Como fazer cálculo rescisão com FGTS e multa? Entenda";
    public static final String EXPECTED_ARTICLE_URL = "https://blog.agibank.com.br/calculo-rescisao-com-fgts-e-multa/";

    private final WebDriver driver;
    private final SelectFGTSeMultaActions actions;
    private final SelectFGTSeMultaElements elements;
    private final WebDriverWait wait;

    public SelectFGTSeMultaPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new SelectFGTSeMultaActions(driver);
        this.elements = new SelectFGTSeMultaElements();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get(DriverFactory.BASE_URL);
        wait.until(ExpectedConditions.urlContains("agibank"));
    }

    public String getFeaturedArticleText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elements.featuredArticleLink()));
        return actions.getFeaturedArticleText();
    }

    public void openFeaturedArticle() {
        wait.until(ExpectedConditions.elementToBeClickable(elements.featuredArticleLink()));
        actions.clickFeaturedArticle();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        wait.until(ExpectedConditions.urlToBe(EXPECTED_ARTICLE_URL));
    }

    public String getArticleTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elements.articleTitleHeading()));
        return driver.findElement(elements.articleTitleHeading()).getText().trim();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
