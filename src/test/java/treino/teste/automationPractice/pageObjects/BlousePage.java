package treino.teste.automationPractice.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import treino.teste.framework.supports.Wait;

public class BlousePage {
    private final WebDriver driver;
    private final Wait wait;

    public BlousePage(WebDriver driver) {
        this.driver = driver;
        wait = new Wait(driver);
    }

    public WebDriver getIframe() {
        WebElement iframe = driver.findElement(By.className("fancybox-iframe"));
        driver.switchTo().frame(iframe);
        return driver;
    }

    public WebElement getAddToCartButton() throws InterruptedException {
//        Thread.sleep(5000);
        wait.waitVisibilityElement(By.cssSelector("#add_to_cart button"));
        return driver.findElement(By.cssSelector("#add_to_cart button"));
    }

    public WebElement getProceedToCheckoutButton() {
        wait.waitElementToBeClickable(By.cssSelector(".clearfix a[title='Proceed to checkout']"));
        return driver.findElement(By.cssSelector(".clearfix a[title='Proceed to checkout']"));
    }
}
