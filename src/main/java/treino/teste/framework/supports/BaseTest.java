package treino.teste.framework.supports;

import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import treino.teste.framework.tools.Report;
import treino.teste.framework.tools.Screenshot;
import treino.teste.framework.webdrivers.DriverFactory;
import treino.teste.framework.webdrivers.DriverManager;
import treino.teste.framework.webdrivers.Drivers;

public class BaseTest extends DriverFactory {

    private static String url = "http://automationpractice.com/index.php";

    @BeforeAll
    public static void setUp(){
        Report.configurarExtentReport();
        driver = getBrowser(Drivers.CHROME);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(url);
    }

    @AfterAll
    public static void tearDown(){
        Report.extentTest.log(Status.INFO,"Finalmente de teste", Screenshot.screenshotBase64(driver));
        Report.closeReport();
        DriverManager.quit();
    }
}