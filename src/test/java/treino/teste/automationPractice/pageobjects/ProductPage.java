package treino.teste.automationPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductButton() {
        return driver.findElement(By.cssSelector("#center_column img"));
    }

}
