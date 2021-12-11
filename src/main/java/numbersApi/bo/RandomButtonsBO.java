package numbersApi.bo;

import numbersApi.parallel_run.BrowserFactory;
import numbersApi.po.RandomButtonsPO;
import org.openqa.selenium.WebDriver;

public class RandomButtonsBO {
    WebDriver driver = BrowserFactory.getDriver();
    public boolean test(String type){
        RandomButtonsPO randomButtonsPO = new RandomButtonsPO(driver);
        randomButtonsPO.clickRandomButton(type);
        if(randomButtonsPO.checkResult(type)){
            return true;
        }else{
            System.out.println("false");
            return false;
        }
    }
}
