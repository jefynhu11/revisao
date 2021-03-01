package treino.teste.automationPractice.tasks;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import treino.teste.automationPractice.pageobjects.BlousePage;
import treino.teste.framework.tools.JsExecutor;
import treino.teste.framework.tools.Report;
import treino.teste.framework.tools.Screenshot;


public class BlouseTask {

    private final WebDriver driver;
    private final BlousePage blousePage;

    public BlouseTask(WebDriver driver) {
        this.driver = driver;
        blousePage = new BlousePage(driver);
    }

    public void adicionaCarrinho() {
        blousePage.getIframe();
        validarNameProduct();
        JsExecutor.highLightElementWithClick(driver, blousePage.getAddToCartButton());
        JsExecutor.highLightElementWithClick(driver, blousePage.getIframeProceedToCheckoutButton());

        ((JavascriptExecutor)driver).executeScript("scroll(0,500)");

        validarTotalValor();
        JsExecutor.highLightElementWithClick(driver, blousePage.getProceedToCheckoutButton());
    }

    private void validarNameProduct() {
        try {
            JsExecutor.highLightElement(driver, blousePage.getBlouseText());
            Assertions.assertEquals("Blouse", blousePage.getBlouseText().getText());
            Report.extentTest.log(Status.PASS, "O nome do produto está correto", Screenshot.screenshotBase64(driver));
        } catch (Exception e) {
            Report.extentTest.log(Status.ERROR, "O nome do produto não está correto", Screenshot.screenshotBase64(driver));
        }
    }

    private void validarTotalValor() {
        try {
            JsExecutor.highLightElement(driver, blousePage.getTotalText());
            Assertions.assertEquals("$29.00", blousePage.getTotalText().getText());
            Report.extentTest.log(Status.PASS, "O valor está correto", Screenshot.screenshotBase64(driver));
        } catch (Exception e) {
            Report.extentTest.log(Status.ERROR, "O valor não está correto", Screenshot.screenshotBase64(driver));
        }
    }
}
