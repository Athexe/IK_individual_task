package numbersApi.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

public class SearchPO {
    WebDriver driver;
    public SearchPO(WebDriver driver){
        this.driver=driver;
    }
    public void clickOnSearch(){
        driver.findElement(By.id("search-text")).click();
    }
    public void send(String str){
        driver.findElement(By.id("search-text")).clear();
        driver.findElement(By.id("search-text")).sendKeys(str);
    }
    public void submit(){
        driver.findElement(By.id("search-text")).sendKeys("\r\n");
    }
    public boolean checkLabelForUnknownUrl(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException ex){}

        String text = driver.findElement(By.id("result-temporary-text")).getText();

        if(text.equals("Uh oh, we don't understand that URL :(\n" +
                "Maybe read the API docs below?")){
            return true;
        }else {
            return false;

        }
    }
}
