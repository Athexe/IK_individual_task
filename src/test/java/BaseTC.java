import numbersApi.Driver;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Listeners({BaseTCListener.class})
public class BaseTC {
    WebDriver driver = Driver.getInstance().getDriver();

    @After
    public void kill(){
        driver.close();
        driver.quit();
    }
}
