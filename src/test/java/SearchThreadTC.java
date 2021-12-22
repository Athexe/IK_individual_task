import numbersApi.bo.SearchBO;
import numbersApi.parallel_run.BrowserFactory;
import org.junit.Assert;
import org.testng.annotations.Test;

public class SearchThreadTC extends BaseTC {

    @Test(dataProvider = "browserDataProvider")
    public void SearchTestNumber(String browserName) {
        BrowserFactory.initDriver(browserName);
        BrowserFactory.getDriver().get("http://numbersapi.com/#42");
        SearchBO searchBO = new SearchBO();
        Assert.assertTrue(searchBO.enterSearchInput("24"));
    }

    @Test(dataProvider = "browserDataProvider")
    public void SearchTestString(String browserName){
        BrowserFactory.initDriver(browserName);
        BrowserFactory.getDriver().get("http://numbersapi.com/#42");
        SearchBO searchBO = new SearchBO();
        searchBO.enterSearchInput("gg");
        Assert.assertTrue(searchBO.checkLabel());
    }
}
