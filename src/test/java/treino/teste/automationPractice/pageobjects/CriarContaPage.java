package treino.teste.automationPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import treino.teste.framework.supports.Wait;

public class CriarContaPage {
    private final WebDriver driver;
    private final Wait wait;

    public CriarContaPage(WebDriver driver){
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebElement getCreateContaEmailFieldText() {
        return driver.findElement(By.id("email_create"));
    }

    public WebElement getCreateAnAccountButton() {
        return driver.findElement(By.id("SubmitCreate"));
    }

    public WebElement getCreateAnAccountText() {
        return driver.findElement(By.cssSelector("#create-account_form h3"));
    }

    public WebElement getYourPersonalInformationText(){
        wait.waitVisibilityElement(By.xpath("//div[@class='clearfix']//..//h3"));
        return driver.findElement(By.xpath("//div[@class='clearfix']//..//h3"));
    }
}
