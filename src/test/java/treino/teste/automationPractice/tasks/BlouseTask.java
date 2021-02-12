package treino.teste.automationPractice.tasks;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import treino.teste.automationPractice.pageobjects.BlousePage;
import treino.teste.framework.tools.JsExecutor;
import treino.teste.framework.tools.Report;
import treino.teste.framework.tools.Report.*;
import treino.teste.framework.tools.Screenshot;

import java.io.IOException;

public class BlouseTask {

    private final WebDriver driver;
    private final BlousePage blousePage;

    public BlouseTask(WebDriver driver) {
        this.driver = driver;
        blousePage = new BlousePage(driver);
    }

    public void adicionaCarrinho() throws InterruptedException {
        blousePage.getIframe();
        validarNameProduct();
        JsExecutor.highLightElement(driver, blousePage.getAddToCartButton());
        blousePage.getAddToCartButton().click();
        JsExecutor.highLightElement(driver, blousePage.getIframeProceedToCheckoutButton());
        blousePage.getIframeProceedToCheckoutButton().click();

        ((JavascriptExecutor)driver).executeScript("scroll(0,500)");

        validarTotalValor();
        JsExecutor.highLightElement(driver, blousePage.getProceedToCheckoutButton());
    }

    private void validarNameProduct() {
        try {
            JsExecutor.highLightElement(driver, blousePage.getBlouseText());
            String text = blousePage.getBlouseText().getText();
            Assertions.assertEquals("Blouse", text);
            Report.extentTest.log(Status.PASS, "O nome do produto está correto", Screenshot.screenshotBase64(driver));
        } catch (Exception e) {
            Report.extentTest.log(Status.ERROR, "O nome do produto não está correto", Screenshot.screenshotBase64(driver));
        }
    }

    private void validarTotalValor() {
//        try {
//            JsExecutor.highLightElement(driver, blousePage.getTotalText());
//            String text = blousePage.getTotalText().getText();
//            Assertions.assertEquals("$28.00", text);
//            Report.extentTest.log(Status.PASS, "O valor está correto", Screenshot.screenshotBase64(driver));
//        } catch (Exception e) {
//            Report.extentTest.log(Status.ERROR, "O valor não está correto", Screenshot.screenshotBase64(driver));
//
//        }

        JsExecutor.highLightElement(driver, blousePage.getTotalText());
        String text = blousePage.getTotalText().getText();
        System.out.println("Teste > " + text);
        if (text.equals("$29.00")) {
            Report.extentTest.log(Status.PASS, "O valor está correto", Screenshot.screenshotBase64(driver));
        } else {
            Report.extentTest.log(Status.ERROR, "O valor não está correto", Screenshot.screenshotBase64(driver));
        }

    }
}
