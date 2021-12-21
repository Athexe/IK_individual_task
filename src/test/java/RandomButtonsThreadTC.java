import numbersApi.bo.RandomButtonsBO;
import numbersApi.parallel_run.BrowserFactory;
import org.junit.Assert;
import org.testng.annotations.Test;

public class RandomButtonsThreadTC extends BaseTC {

    @Test(dataProvider = "randomButtonsDataProvider")
    public void tryRandomButton(String id, String type){
        BrowserFactory.initDriver("chrome");
        BrowserFactory.getDriver().get("http://numbersapi.com/#"+id);
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        Assert.assertTrue(randomButtonsBO.test(type));
    }
}
