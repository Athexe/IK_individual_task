package ui;

import numbersApi.base.BaseTCListener;
import numbersApi.parallel_run.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
        return new Object[][]{{"Year"},{"Trivia"},{"Math"},{"Date"}};
    }

    @DataProvider()
    public static Object[][] arrowsDataProvider(){
        return new Object[][]{{"Up"},{"Down"}};
    }

    @AfterMethod
    void screenshotAndQuitBrowser() throws Exception {
        BrowserFactory.takeSnapShot(BrowserFactory.getDriver(), "C:/Users/Athexe/Desktop/screenshots/Test"+new Date().getTime()+".png") ;
        BrowserFactory.getDriver().quit();
    }

    @BeforeMethod
    void initBrowserAndGetPage() {
        BrowserFactory.initDriver("chrome");
        BrowserFactory.getDriver().get("http://numbersapi.com/#42");
    }
}