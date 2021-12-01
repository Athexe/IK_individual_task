package numbersApi.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class RandomButtonsPO {
    WebDriver driver;
    public RandomButtonsPO(WebDriver driver){
        this.driver=driver;
    }
    public void clickRandomButton(String type){
        switch(type){
            case "Trivia":
                driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div[3]/div[2]/ul/li[1]/a")).click();
                break;
            case "Year":
                driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div[3]/div[2]/ul/li[2]/a")).click();
                break;
            case "Date":
                driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div[3]/div[2]/ul/li[3]/a")).click();
                break;
            case "Math":
                driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div[3]/div[2]/ul/li[4]/a")).click();
                break;

        }
    }
    public boolean checkResult(String type){
        switch(type){
            case("Trivia"):
                type = "random/trivia";
                break;
            case("Year"):
                type = "random/year";
                break;
            case("Date"):
                type = "random/date";
                break;
            case("Math"):
                type = "random/math";
                break;
        }
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException ex){}
        String searchText = driver.findElement(By.id("search-text")).getAttribute("value");;
        //System.out.println(searchText);
        //System.out.println(type);
        if (searchText.equals(type)) {
            return true;
        }else{
            System.out.println("false");
            return false;
        }
    }
}
