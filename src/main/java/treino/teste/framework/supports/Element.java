package treino.teste.framework.supports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import treino.teste.framework.tools.JsExecutor;

public class Element {

    public void elemento(WebDriver driver, WebElement page) {
        JsExecutor.highLightElement(driver, page);
    }

}
