package numbersApi.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SocialMediaPO {
    WebDriver driver;
    public SocialMediaPO(WebDriver driver){
        this.driver=driver;
    }
    public void clickOnSite(String site){
        switch(site){
            case("Facebook"):
                driver.findElement(By.xpath("//a[@title='Facebook']")).click();
                try{
                    TimeUnit.SECONDS.sleep(1);
                }catch(InterruptedException ex){

                }
                break;
            case("Twitter"):
                break;
            default:
                throw new RuntimeException("invalid social media");
        }
    }
}
