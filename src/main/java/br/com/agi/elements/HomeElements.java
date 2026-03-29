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
}