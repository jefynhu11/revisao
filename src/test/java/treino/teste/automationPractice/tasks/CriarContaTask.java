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
//        criarContaPage.getCreateContaEmailFieldText().sendKeys(faker.internet().emailAddress());
            String email = fakers.getEmail();
            JsExecutor.highLightElement(driver, criarContaPage.getCreateContaEmailFieldText());
            criarContaPage.getCreateContaEmailFieldText().sendKeys(email);
            JsExecutor.highLightElement(driver, criarContaPage.getCreateAnAccountButton());
            criarContaPage.getCreateAnAccountButton().click();
        } catch (Exception e) {
            Report.extentTest.log(Status.ERROR, "A pagina de login e parte cria a conta não está correto", Screenshot.screenshotBase64(driver));
        }
    }

    private void cadastrarDados() {

        try{
            String text = criarContaPage.getYourPersonalInformationText().getText();
            JsExecutor.highLightElement(driver, criarContaPage.getYourPersonalInformationText());
            Assertions.assertEquals("YOUR PERSONAL INFORMATION", text);
            if(text.equals("YOUR PERSONAL INFORMATION")){
                System.out.println("OK");
            } else {
                System.out.println("FAIL");
            }
            Report.extentTest.log(Status.PASS, "O titulo da cadastrar está correto", Screenshot.screenshotBase64(driver));
            criarContaPage.getTitleMrCheckBox().click();
            JsExecutor.highLightElement(driver, criarContaPage.getFirstNameFieldText());
            criarContaPage.getFirstNameFieldText().sendKeys(fakers.getFirstName());

            JsExecutor.highLightElementTest(driver, criarContaPage.getLastNameFieldText());
            criarContaPage.getLastNameFieldText().sendKeys(fakers.getLastName());
        } catch (Exception e) {
            Report.extentTest.log(Status.ERROR, "O titulo da cadastrar não está correto", Screenshot.screenshotBase64(driver));
        }
    }

}
