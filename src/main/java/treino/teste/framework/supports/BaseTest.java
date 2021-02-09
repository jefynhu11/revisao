package treino.teste.framework.supports;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import treino.teste.framework.webdrivers.DriverFactory;
import treino.teste.framework.webdrivers.DriverManager;
import treino.teste.framework.webdrivers.Drivers;

public class BaseTest {

    private static String url = "http://automationpractice.com/";

    @BeforeAll
    public static void setUp(){
        WebDriver driverInstance = DriverFactory.getInstance(Drivers.CHROME);
        DriverManager.setDriver(driverInstance);
        DriverManager.getDriver().manage().window().maximize();
//        DriverManager.getDriver().get("http://automationpractice.com/");
        DriverManager.getDriver().get(url);
    }

    @AfterAll
    public static void tearDown(){
        DriverManager.quit();
    }
}