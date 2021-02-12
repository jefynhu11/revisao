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
        JsExecutor.highLightElement(driver, indexPage.getProductButton());
        indexPage.getProductButton().click();
    }

    public void digitarPesquisar(String args){
        JsExecutor.highLightElement(driver, indexPage.getSearchField());
        indexPage.getSearchField().sendKeys(args);
    }

    public void clicarPesquisar() {
        indexPage.getSearchButtom().click();
    }
}