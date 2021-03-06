package treino.teste.automationPractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {

    private final WebDriver driver;

    public IndexPage(WebDriver webDriver){
        this.driver = webDriver;
    }

    public WebElement getProductButton(){
        return driver.findElement(By.cssSelector("#homefeatured img[title='Blouse']"));
    }

    public WebElement getSearchField() {
        return driver.findElement(By.id("search_query_top"));
    }

    public WebElement getSearchButtom() {
        return driver.findElement(By.name("submit_search"));
    }
}
