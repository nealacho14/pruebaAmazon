package com.amazon.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;



public class AmazonPage extends PageObject {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElementFacade searchBox;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a")
    WebElementFacade segundoItem;

    @FindBy(xpath = "//input[contains(@title,'Agregar al Carrito')]")
    WebElementFacade botonAlcarrito;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]/a[1]/span[1]")
    WebElementFacade tituloEnlista;

    @FindBy(xpath = "//span[@id='productTitle']")
    WebElement tituloIrCarro;
    public void escribirTexto(String palabra){
        searchBox.sendKeys(palabra);
    }

    public void irSegundaPagina(){
        WebElement element = getDriver().findElement(By.xpath("//a[contains(@aria-label,'Ir a la página 3')]"));
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public void seleccionarTercerItem(){
        String nombreEnlista = tituloEnlista.getText();
        System.out.println(nombreEnlista);
        segundoItem.click();
        String tituloParticular = tituloIrCarro.getText();
        System.out.println(tituloParticular);
        Assert.assertEquals(nombreEnlista,tituloParticular);
        botonAlcarrito.click();

    }

    public void buscar(){
        searchBox.sendKeys(Keys.ENTER);
    }

    public boolean resultadosVisualizados(){
        String busqueda = "//h1[contains(.,'Agregado al carrito')]";
        WebElementFacade resultado = withTimeoutOf(Duration.ofSeconds(1000)).find(By.xpath(busqueda));
        return resultado.isDisplayed();
    }

}
