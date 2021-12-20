package numbersApi.parallel_run;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
    private final static ThreadLocal<WebDriver> INSTANCE = new InheritableThreadLocal<>();

    public static WebDriver getDriver(){
        if(INSTANCE.get()==null){
            throw new RuntimeException("init driver first");
        }
        return INSTANCE.get();
    }
    public static void initDriver(String browserName){
        switch(browserName){
            case "chrome" -> {
                ChromeDriverManager.getInstance().setup();
                INSTANCE.set(new ChromeDriver());
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                INSTANCE.set(new FirefoxDriver());
            }
            case "edge" ->{
                WebDriverManager.edgedriver().setup();
                INSTANCE.set(new EdgeDriver());
            }
            default -> throw new RuntimeException("invalid browser" + browserName);
        }
    }
}
