package treino.teste.automationPractice.tasks;

import org.openqa.selenium.WebDriver;
import treino.teste.automationPractice.pageobjects.BlousePage;
import treino.teste.framework.tools.JsExecutor;

public class BlouseTask {

    private final WebDriver driver;
    private final BlousePage blousePage;

    public BlouseTask(WebDriver driver) {
        this.driver = driver;
        blousePage = new BlousePage(driver);
    }

    public void adicionaCarrinho() throws InterruptedException {
        blousePage.getIframe();
        JsExecutor.highLightElement(driver, blousePage.getAddToCartButton());
        blousePage.getAddToCartButton().click();
        JsExecutor.highLightElement(driver, blousePage.getProceedToCheckoutButton());
        blousePage.getProceedToCheckoutButton().click();
    }
}
