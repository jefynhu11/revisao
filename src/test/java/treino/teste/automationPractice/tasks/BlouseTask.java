package treino.teste.automationPractice.tasks;

import org.openqa.selenium.WebDriver;
import treino.teste.automationPractice.pageObjects.BlousePage;

public class BlouseTask {

    private final BlousePage blousePage;

    public BlouseTask(WebDriver driver) {
        blousePage = new BlousePage(driver);
    }

    public void adicionaCarrinho() throws InterruptedException {
        blousePage.getIframe();
        blousePage.getAddToCartButton().click();
        blousePage.getProceedToCheckoutButton().click();
    }
}
