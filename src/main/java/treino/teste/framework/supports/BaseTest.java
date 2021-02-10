package treino.teste.framework.supports;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import treino.teste.framework.webdrivers.DriverFactory;
import treino.teste.framework.webdrivers.DriverManager;
import treino.teste.framework.webdrivers.Drivers;

public class BaseTest extends DriverFactory {

    private static String url = "http://automationpractice.com/";

    @BeforeAll
    public static void setUp(){
        driver = getBrowser(Drivers.CHROME);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(url);
    }

    @AfterAll
    public static void tearDown(){
        DriverManager.quit();
    }
}