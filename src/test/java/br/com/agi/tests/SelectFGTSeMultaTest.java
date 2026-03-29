package br.com.agi.tests;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.agi.core.DriverFactory;
import br.com.agi.pages.SelectFGTSeMultaPage;

public class SelectFGTSeMultaTest {

    private SelectFGTSeMultaPage selectFGTSeMultaPage;

    @BeforeEach
    public void setUp() {
        selectFGTSeMultaPage = new SelectFGTSeMultaPage(DriverFactory.getDriver());
        selectFGTSeMultaPage.open();
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Test
    public void shouldValidateAndOpenFeaturedFgtsArticle() {
        assertEquals(SelectFGTSeMultaPage.EXPECTED_ARTICLE_TITLE, selectFGTSeMultaPage.getFeaturedArticleText());
        selectFGTSeMultaPage.openFeaturedArticle();
        assertEquals(SelectFGTSeMultaPage.EXPECTED_ARTICLE_TITLE, selectFGTSeMultaPage.getArticleTitle());
        assertEquals(SelectFGTSeMultaPage.EXPECTED_ARTICLE_URL, selectFGTSeMultaPage.getCurrentUrl());
    }
}
