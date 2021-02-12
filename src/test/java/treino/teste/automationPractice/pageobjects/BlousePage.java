package treino.teste.automationPractice.pageobjects;

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

    public WebElement getBlouseText() {
        return driver.findElement(By.cssSelector(".pb-center-column h1"));
    }

    public WebElement getSucessProductText() {
        return driver.findElement(By.cssSelector(".cart-prices .ajax_block_cart_total"));
    }

    public WebElement getAddToCartButton() {
        wait.waitVisibilityElement(By.cssSelector("#add_to_cart button"));
        return driver.findElement(By.cssSelector("#add_to_cart button"));
    }

    public WebElement getIframeProceedToCheckoutButton() {
        wait.waitElementToBeClickable(By.cssSelector(".clearfix a[title='Proceed to checkout']"));
        return driver.findElement(By.cssSelector(".clearfix a[title='Proceed to checkout']"));
    }

    public WebElement getTotalText() {
        return driver.findElement(By.id("total_price"));
//        return driver.findElement(By.id("total_price_container"));
    }

    public WebElement getProceedToCheckoutButton() {
        return driver.findElement(By.cssSelector("p[class='cart_navigation clearfix'] a[title='Proceed to checkout']"));
    }

    public WebElement getTeste() {
        return driver.findElement(By.cssSelector("#product_2_7_0_0 .product-name"));
    }
}
