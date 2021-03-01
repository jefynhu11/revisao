package treino.teste.automationPractice.testcases;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import treino.teste.automationPractice.tasks.BlouseTask;
import treino.teste.automationPractice.tasks.CriarContaTask;
import treino.teste.automationPractice.tasks.IndexTask;
import treino.teste.automationPractice.tasks.ProductTask;
import treino.teste.framework.supports.BaseTest;
import treino.teste.framework.tools.Report;
import treino.teste.framework.tools.Screenshot;
import treino.teste.framework.webdrivers.DriverManager;

import java.io.IOException;

import static treino.teste.framework.tools.Report.extentTest;

public class RealizarComprarComSucessoTestCase extends BaseTest {

    private final WebDriver driver = DriverManager.getDriver();
    private final IndexTask indexTask = new IndexTask(driver);
    private final ProductTask productTask = new ProductTask(driver);
    private final BlouseTask blouseTask = new BlouseTask(driver);
    private final CriarContaTask criarContaTask = new CriarContaTask(driver);

    @Test
    public void test() throws InterruptedException {
        //opção 1
        Report.createTest("Realiza de comprar com sucesso");
        extentTest.log(Status.INFO, "Abriu a navegador", Screenshot.screenshotBase64(driver));
        indexTask.escolherProduto();
        blouseTask.adicionaCarrinho();
        criarContaTask.cadastrarConta();

        //opção 2
//        indexTask.digitarPesquisar("Blouse");
//        indexTask.clicarPesquisar();
//        productTask.clicarImagem();

            Thread.sleep(5000);
//            extentTest.log(Status.ERROR, "Realiza de comprar não foi com sucesso", Screenshot.screenshotBase64(driver));

    }
}