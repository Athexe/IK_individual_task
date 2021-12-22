import numbersApi.bo.RandomButtonsBO;
import numbersApi.parallel_run.BrowserFactory;
import org.junit.Assert;
import org.testng.annotations.Test;

public class ArrowsTC extends BaseTC{
    @Test
    public void tryRandomButton(){
        BrowserFactory.initDriver("chrome");
        BrowserFactory.getDriver().get("http://numbersapi.com/#42");
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        //Assert.assertTrue();
    }
}
