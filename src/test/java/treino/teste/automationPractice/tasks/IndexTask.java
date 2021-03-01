package treino.teste.automationPractice.tasks;

import org.openqa.selenium.WebDriver;
import treino.teste.automationPractice.pageobjects.IndexPage;
import treino.teste.framework.tools.JsExecutor;

public class IndexTask {
    private final WebDriver driver;
    private final IndexPage indexPage;

    public IndexTask(WebDriver driver){
        this.driver = driver;
        indexPage = new IndexPage(driver);
    }

    public void escolherProduto(){
        JsExecutor.highLightElementWithClick(driver, indexPage.getProductButton());
    }

    public void digitarPesquisar(String value){
        JsExecutor.highLightElementWithSend(driver, indexPage.getSearchField(), value);
    }

    public void clicarPesquisar() {
        JsExecutor.highLightElementWithClick(driver, indexPage.getSearchField());
    }
}