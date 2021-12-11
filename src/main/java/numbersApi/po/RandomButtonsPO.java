package numbersApi.po;
import numbersApi.parallel_run.BrowserFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class RandomButtonsPO {

    @FindBy(xpath="/html/body/div[1]/div/section[2]/div/div[3]/div[2]/ul/li[1]/a")
    private WebElement triviaButton;

    @FindBy(xpath="/html/body/div[1]/div/section[2]/div/div[3]/div[2]/ul/li[2]/a")
    private WebElement yearButton;

    @FindBy(xpath="/html/body/div[1]/div/section[2]/div/div[3]/div[2]/ul/li[3]/a")
    private WebElement dateButton;

    @FindBy(xpath="/html/body/div[1]/div/section[2]/div/div[3]/div[2]/ul/li[4]/a")
    private WebElement mathButton;

    @FindBy(id="search-text")
    private WebElement searchInput;

    public RandomButtonsPO(){
        PageFactory.initElements(BrowserFactory.getDriver(),this);
    }

    public void clickRandomButton(String type){
        switch(type){
            case "Trivia":
                triviaButton.click();
                break;
            case "Year":
                yearButton.click();
                break;
            case "Date":
                dateButton.click();
                break;
            case "Math":
                mathButton.click();
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

        if (searchInput.getAttribute("value").equals(type)) {
            return true;
        }else{
            return false;
        }
    }
}
