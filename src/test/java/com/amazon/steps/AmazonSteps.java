package com.amazon.steps;

import com.amazon.pages.AmazonPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;


public class AmazonSteps {
    @Steps(shared = true)
    AmazonPage amazonPage;

    @Given("^he user navigates to amazon$")
    public void userNavigatesTo() throws InterruptedException {
        amazonPage.setDefaultBaseUrl("https://www.amazon.com/");
        amazonPage.getDriver().manage().deleteAllCookies();
        amazonPage.open();
        Thread.sleep(10000);
        Serenity.takeScreenshot();
    }

    @When("^search for (.*)$")
    public void userTypesWord(String palabra){
        amazonPage.escribirTexto(palabra);
        Serenity.takeScreenshot();
        userClickButton();
    }

    @When("^navigates to the second page$")
    public void navigatesToTheSecondPage(){
        amazonPage.irSegundaPagina();
        Serenity.takeScreenshot();

    }

    @When("^select the third item$")
    public void selectTheThirdItem(){
        amazonPage.seleccionarTercerItem();
        Serenity.takeScreenshot();
    }

    public void userClickButton(){
        amazonPage.buscar();
        Serenity.takeScreenshot();
    }

    @Then("^assert that the items would be available for purchase$")
    public void assertThatTheItemsWouldBeAvailableForPurchase(){
        Assert.assertTrue(amazonPage.resultadosVisualizados());
        Serenity.takeScreenshot();
    }
}
