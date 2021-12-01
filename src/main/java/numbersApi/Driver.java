package numbersApi;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {
    String driverProperty = "Chrome";

    private static final Driver DRIVER = new Driver();
    public static Driver getInstance(){
      return DRIVER;
    };

    public WebDriver getDriver() {
        if(driverProperty.equals("Chrome")){
            ChromeDriverManager.getInstance().setup();
            return new ChromeDriver();
        }
        else if(driverProperty.equals("Firefox")){
            //System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
            return new FirefoxDriver();
        }
        else{
            throw new RuntimeException("invalid browser "+driverProperty);
        }
    };
}
