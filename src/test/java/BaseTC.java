import numbersApi.Driver;
import numbersApi.parallel_run.BrowserFactory;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({BaseTCListener.class})
public class BaseTC {

    @DataProvider(parallel=true)
    public static Object[][] browserDataProvider(){
        return new Object[][]{{"chrome"},{"firefox"}};
    }

    @AfterMethod
    void quitBrowser(){
        BrowserFactory.getDriver().quit();
    }
}
