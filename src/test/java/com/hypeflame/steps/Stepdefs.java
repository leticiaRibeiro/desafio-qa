package com.hypeflame.steps;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Stepdefs {

    WebDriver driver;
    String homePage = "https://hypeflame.blog/";
    List<String> urls = new ArrayList<>();

    @Given("^Acessar homepage do blog$")
    public void acessar_home_page() {
//        System.setProperty("webdriver.chrome.driver", "./driver/linux/chromedriver");
        System.setProperty("webdriver.chrome.driver", "./driver/windows/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("Acessando " + homePage);
        driver.get(homePage);
    }


    @When("^Fazer uma busca vazia de um post$")
    public void pesquisa_vazia() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.findElement(By.id("header-search")).click();
        driver.findElement(By.className("search-field")).sendKeys("" + Keys.ENTER);
    }

    @When("^Fazer uma pesquisa por um título que não existe$")
    public void pesquisa_com_titulo_inexistente() {
        driver.findElement(By.id("header-search")).click();
        driver.findElement(By.className("search-field")).sendKeys("Primeiros passos com Cypress" + Keys.ENTER);
    }


    //UNFINISHED
    @When("^Fazer uma busca por uma parte de um título$")
    public void pesquisa_parte_titulo() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver.findElement(By.id("header-search")).click();
        driver.findElement(By.className("search-field")).sendKeys("vamos falar de" + Keys.ENTER);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@id='content']//article//header//h2//a"));
        elements.forEach(elemento -> urls.add(elemento.getAttribute("href")));
    }

    @When("^Fazer uma busca pelo dígito \"(.*)\"$")
    public void pesquisa_digito_numerico(String digito) {
        driver.findElement(By.id("header-search")).click();
        driver.findElement(By.className("search-field")).sendKeys(digito + Keys.ENTER);
    }

    @When("^Fazer uma busca somente por caracteres especiais$")
    public void pesquisa_caractere_especial() {
        driver.findElement(By.id("header-search")).click();
        driver.findElement(By.className("search-field")).sendKeys("%" + Keys.ENTER);
    }

    @When("^Fazer uma busca por palavra e caractere especial$")
    public void pesquisa_caractere_palavra() {
        driver.findElement(By.id("header-search")).click();
        driver.findElement(By.className("search-field")).sendKeys("né?" + Keys.ENTER);
    }

    @When("^Fazer uma busca pela categoria ou tag$")
    public void pesquisa_por_categoria_tag() {
        driver.findElement(By.id("header-search")).click();
        driver.findElement(By.className("search-field")).sendKeys("Arquitetura" + Keys.ENTER);
    }


    @Then("^Todos os posts da página inicial devem aparecer$")
    public void deve_exibir_todos_posts_pagina_inicial() throws Throwable{
        driver.quit();
    }

    @Then("^A mensagem de erro \"Nenhum resultado\" deve aparecer$")
    public void deve_exibir_uma_mensagem_de_erro() throws Throwable{
        String msgError = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("Nenhum resultado", msgError);
        driver.quit();
    }

    //UNFINISHED
    @Then("^Os posts que contém as partes de um título digitadas devem aparecer$")
    public void posts_com_parte_titulo_digitada() throws Throwable{
        for (String url : urls) {

        }
        driver.quit();
    }

    @Then("^Os posts que contém esse dígito deve ser listado$")
    public void posts_digitos_numericos() throws Throwable{
        driver.quit();
    }

    @Then("^Os posts que contém a palavra com o caractere especial devem ser listados$")
    public void posts_palavra_com_caractere_especial() throws Throwable{
        driver.quit();
    }

    @Then("^Os posts relacionados com a categoria pesquisada devem aparecer$")
    public void posts_categoria_pesquisada() throws Throwable{
        driver.quit();
    }
}
