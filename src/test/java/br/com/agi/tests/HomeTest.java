package br.com.agi.tests;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.agi.core.DriverFactory;
import br.com.agi.pages.HomePage;

public class HomeTest {

    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(DriverFactory.getDriver());
        homePage.open();
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Test
    public void menuServicosShouldNavigateToServicosPage() {
        homePage.goToServicos();
        assertTrue(homePage.getCurrentUrl().contains("/servicos"));
        assertTrue(homePage.isServicosPageLoaded());
    }

    @Test
    public void menuSuasFinancasShouldNavigateToSuasFinancasPage() {
        homePage.goToSuasFinancas();
        assertTrue(homePage.getCurrentUrl().contains("/suas-financas"));
        assertTrue(homePage.isSuasFinancasPageLoaded());
    }
}
