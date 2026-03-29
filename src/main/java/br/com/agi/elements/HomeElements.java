package br.com.agi.elements;

import org.openqa.selenium.By;

public class HomeElements {

    public By menuServicos() {
        return By.xpath("(//span[@class='menu-text'][normalize-space()='Serviços'])[1]");
    }

    public By menuSuasFinancas() {
        return By.xpath("(//span[@class='menu-text'][normalize-space()='Suas finanças'])[1]");
    }

    public By servicosPageTitle() {
        return By.xpath("//h1[contains(normalize-space(), 'Serviços') or contains(normalize-space(), 'serviços')]");
    }

    public By suasFinancasPageTitle() {
        return By.xpath("(//h1[normalize-space()='Suas finanças'])[1]");
    }

    public By cookieConsentButton() {
        return By.xpath(
            "//*[self::button or self::a][" +
            "normalize-space()='Aceitar' or normalize-space()='Aceitar tudo' or " +
            "normalize-space()='Concordo' or normalize-space()='Concordar' or " +
            "contains(translate(normalize-space(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'aceitar') or " +
            "contains(@class,'accept') or contains(@id,'accept') or " +
            "contains(@class,'lgpd') or contains(@id,'lgpd')]"
        );
    }
}