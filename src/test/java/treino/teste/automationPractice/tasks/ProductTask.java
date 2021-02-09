package treino.teste.automationPractice.tasks;

import org.openqa.selenium.WebDriver;
import treino.teste.automationPractice.pageObjects.ProductPage;

public class ProductTask {
    private final ProductPage productPage;

    public ProductTask(WebDriver driver) {
        productPage = new ProductPage(driver);
    }

    public void clicarImagem() {
        productPage.getProductButton().click();
    }
}
