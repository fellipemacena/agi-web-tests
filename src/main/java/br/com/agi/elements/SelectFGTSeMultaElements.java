package br.com.agi.elements;

import org.openqa.selenium.By;

public class SelectFGTSeMultaElements {

    public By featuredArticleLink() {
        return By.xpath("/html/body/div[1]/div/div/div/main/article/div/div[6]/article[1]/h3/a | //h3/a[contains(normalize-space(), 'Como fazer cálculo rescisão com FGTS e multa? Entenda')]");
    }

    public By articleTitleHeading() {
        return By.xpath("//h1[normalize-space()='Como fazer cálculo rescisão com FGTS e multa? Entenda']");
    }
}
