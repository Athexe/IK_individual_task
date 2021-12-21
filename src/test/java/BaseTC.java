import numbersApi.base.BaseTCListener;
import numbersApi.parallel_run.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.util.Date;

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
    void screenshotAndQuitBrowser() throws Exception {
        BrowserFactory.takeSnapShot(BrowserFactory.getDriver(), "C:/Users/Athexe/Desktop/screenshots/Test"+new Date().getTime()+".png") ;
        BrowserFactory.getDriver().quit();
    }
}