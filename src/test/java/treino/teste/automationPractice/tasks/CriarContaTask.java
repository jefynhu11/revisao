package treino.teste.automationPractice.tasks;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import treino.teste.automationPractice.pageobjects.CriarContaPage;
import treino.teste.framework.supports.Fakers;
import treino.teste.framework.tools.JsExecutor;
import treino.teste.framework.tools.Report;
import treino.teste.framework.tools.Screenshot;

public class CriarContaTask {
    private final WebDriver driver;
    private final CriarContaPage criarContaPage;
    private final Faker faker;
    private final Fakers fakers;

    public CriarContaTask(WebDriver driver){
        this.driver = driver;
        criarContaPage = new CriarContaPage(driver);
        faker = new Faker();
        fakers = new Fakers();
    }

    public void cadastrarConta() {
        criarEmail();
        cadastrarDados();
    }

    private void criarEmail() {
        try {
            ((JavascriptExecutor)driver).executeScript("scroll(0,300)");
            JsExecutor.highLightElement(driver, criarContaPage.getCreateAnAccountText());
            Assertions.assertEquals("CREATE AN ACCOUNT", criarContaPage.getCreateAnAccountText().getText());
            Report.extentTest.log(Status.PASS, "A pagina de login e parte cria a conta está correto", Screenshot.screenshotBase64(driver));
            JsExecutor.highLightElementWithSend(driver, criarContaPage.getCreateContaEmailFieldText(), fakers.getEmail());
            JsExecutor.highLightElementWithClick(   driver, criarContaPage.getCreateAnAccountButton());
        } catch (Exception e) {
            Report.extentTest.log(Status.ERROR, "A pagina de login e parte cria a conta não está correto", Screenshot.screenshotBase64(driver));
        }
    }

    private void cadastrarDados() {

        try{
            JsExecutor.highLightElement(driver, criarContaPage.getYourPersonalInformationText());
            Assertions.assertEquals("YOUR PERSONAL INFORMATION", criarContaPage.getYourPersonalInformationText().getText());
            Report.extentTest.log(Status.PASS, "O titulo da cadastrar está correto", Screenshot.screenshotBase64(driver));
            JsExecutor.highLightElementWithClick(driver, criarContaPage.getTitleMrCheckBox());
            JsExecutor.highLightElementWithSend(driver, criarContaPage.getFirstNameFieldText(), fakers.getFirstName());
            JsExecutor.highLightElementWithSend(driver, criarContaPage.getLastNameFieldText(), fakers.getLastName());
        } catch (Exception e) {
            Report.extentTest.log(Status.ERROR, "O titulo da cadastrar não está correto", Screenshot.screenshotBase64(driver));
        }
    }

}
