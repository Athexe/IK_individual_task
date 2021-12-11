import numbersApi.bo.RandomButtonsBO;
import numbersApi.parallel_run.BrowserFactory;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.DataProvider;

@Listeners({BaseTCListener.class})
public class RandomButtonsThreadTC {

    @DataProvider(parallel=true)
    public static Object[][] browserDataProvider(){
        return new Object[][]{{"chrome"},{"firefox"}};
    }

    @Test(dataProvider = "browserDataProvider")
    public void TryRandomTriviaButton(String browserName){
        BrowserFactory.initDriver(browserName);
        BrowserFactory.getDriver().get("http://numbersapi.com/#42");
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        Assert.assertTrue(randomButtonsBO.test("Trivia"));
    }

    @Test(dataProvider = "browserDataProvider")
    public void TryRandomYearButton(String browserName){
        BrowserFactory.initDriver(browserName);
        BrowserFactory.getDriver().get("http://numbersapi.com/#42");
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        Assert.assertTrue(randomButtonsBO.test("Year"));
    }

    @Test(dataProvider = "browserDataProvider")
    public void TryRandomDateButton(String browserName){
        BrowserFactory.initDriver(browserName);
        BrowserFactory.getDriver().get("http://numbersapi.com/#42");
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        Assert.assertTrue(randomButtonsBO.test("Date"));
    }

    @Test(dataProvider = "browserDataProvider")
    public void TryRandomMathButton(String browserName){
        BrowserFactory.initDriver(browserName);
        BrowserFactory.getDriver().get("http://numbersapi.com/#42");
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        Assert.assertTrue(randomButtonsBO.test("Math"));
    }

    @AfterMethod
    void quitBrowser(){
        BrowserFactory.getDriver().quit();
    }
}
