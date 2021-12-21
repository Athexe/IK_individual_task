import numbersApi.base.BaseTCListener;
import numbersApi.parallel_run.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({BaseTCListener.class})
public class BaseTC {

    @DataProvider()
    public static Object[][] browserDataProvider(){
        return new Object[][]{{"chrome"},{"edge"}};
    }

    @DataProvider()
    public static Object[][] randomButtonsDataProvider(){
        return new Object[][]{{"42","Year"},{"42","Trivia"},{"42","Math"},{"2/6","Date"}};
    }

    @AfterMethod
    void quitBrowser(){
        BrowserFactory.getDriver().quit();
    }
}