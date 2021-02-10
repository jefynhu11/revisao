package treino.teste.automationPractice.tasks;

import org.openqa.selenium.WebDriver;
import treino.teste.automationPractice.pageobjects.IndexPage;

public class IndexTask {
    private final IndexPage indexPage;

    public IndexTask(WebDriver driver){
        indexPage = new IndexPage(driver);
    }

    public void escolherProduto(){
        indexPage.getProductButton().click();
    }

    public void digitarPesquisar(String args){
        indexPage.getSearchField().sendKeys(args);
    }

    public void clicarPesquisar() {
        indexPage.getSearchButtom().click();
    }
}