package treino.teste.automationPractice.testcases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import treino.teste.automationPractice.tasks.BlouseTask;
import treino.teste.automationPractice.tasks.IndexTask;
import treino.teste.automationPractice.tasks.ProductTask;
import treino.teste.framework.supports.BaseTest;
import treino.teste.framework.webdrivers.DriverManager;

public class RealizarComprarComSucessoTestCase extends BaseTest {

    private final WebDriver driver = DriverManager.getDriver();
    private final IndexTask indexTask = new IndexTask(driver);
    private final ProductTask productTask = new ProductTask(driver);
    private final BlouseTask blouseTask = new BlouseTask(driver);

    @Test
    public void test() throws InterruptedException {
        //opção 1
        indexTask.escolherProduto();
        blouseTask.adicionaCarrinho();

        //opção 2
//        indexTask.digitarPesquisar("Blouse");
//        indexTask.clicarPesquisar();
//        productTask.clicarImagem();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}