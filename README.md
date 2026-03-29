# AGI Web Tests

Projeto de automacao E2E com Java 17, Selenium WebDriver, JUnit 5 e Maven.

## Estrutura

- pom.xml
- src/main/java/br/com/agi/
  - core/DriverFactory.java
  - elements/SearchElements.java
  - actions/SearchActions.java
  - pages/SearchPage.java
- src/test/java/br/com/agi/tests/
  - SearchTest.java

## Cenarios cobertos

1. Busca e valida se na barra de opções da Home as opções Serviços e Suas finanças estão visíveis e em seguida clica para acessar a suas páginas.
2. Em seguida valida o acesso delas
3. Busca e valida na seção Últimas do Blog do Agi a opção "Como fazer cálculo rescisão com FGTS e multa? Entenda" e depois clica para acessar página.
4. Em seguida valida o acesso a ela.

## Execucao

```bash
mvn clean test
```
