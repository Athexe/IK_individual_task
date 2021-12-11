import numbersApi.bo.SearchBO;
import numbersApi.parallel_run.BrowserFactory;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

@Listeners({BaseTCListener.class})
public class SearchThreadTC{

    @DataProvider(parallel=true)
    public static Object[][] browserDataProvider(){
        return new Object[][]{{"chrome"},{"firefox"}};
    }

    @Test(dataProvider = "browserDataProvider")
    public void SearchTestNumber(String browserName) {
        BrowserFactory.initDriver(browserName);
        BrowserFactory.getDriver().get("http://numbersapi.com/#42");
        SearchBO searchBO = new SearchBO();
        Assert.assertTrue(searchBO.test("24"));
    }

    @Test(dataProvider = "browserDataProvider")
    public void SearchTestString(String browserName){
        BrowserFactory.initDriver(browserName);
        BrowserFactory.getDriver().get("http://numbersapi.com/#42");
        SearchBO searchBO = new SearchBO();
        searchBO.test("gg");
        Assert.assertTrue(searchBO.checkLabel());
    }

    @AfterMethod
    void quitBrowser(){
        BrowserFactory.getDriver().quit();
    }
}
