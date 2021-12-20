import numbersApi.base.BaseTCListener;
import numbersApi.parallel_run.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({BaseTCListener.class})
public class BaseTC {

    @DataProvider(parallel=true)
    public static Object[][] browserDataProvider(){
        return new Object[][]{{"chrome"},{"firefox"},{"edge"}};
    }

    @DataProvider(parallel=true)
    public static Object[][] edgeDataProvider(){
        return new Object[][]{{"edge"}};
    }

    @DataProvider(parallel=true)
    public static Object[][] chromeDataProvider(){
        return new Object[][]{{"chrome"}};
    }

    @DataProvider(parallel=true)
    public static Object[][] firefoxDataProvider(){
        return new Object[][]{{"firefox"}};
    }

    @AfterMethod
    void quitBrowser(){
        BrowserFactory.getDriver().quit();
    }
}