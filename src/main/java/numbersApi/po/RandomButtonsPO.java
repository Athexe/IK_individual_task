package numbersApi.po;
import io.qameta.allure.Step;
import numbersApi.decorator.ButtonElement;
import numbersApi.decorator.CustomDecorator;
import numbersApi.decorator.InputElement;
import numbersApi.parallel_run.BrowserFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class RandomButtonsPO {

    @FindBy(xpath="//*[@href=\"#random/trivia\"]")
    private ButtonElement triviaButton;

    @FindBy(xpath="//*[@href=\"#random/year\"]")
    private ButtonElement yearButton;

    @FindBy(xpath="//*[@href=\"#random/date\"]")
    private ButtonElement dateButton;

    @FindBy(xpath="//*[@href=\"#random/math\"]")
    private ButtonElement mathButton;

    @FindBy(id="search-text")
    private InputElement searchInput;

    public RandomButtonsPO(){
        PageFactory.initElements(new CustomDecorator(BrowserFactory.getDriver()),this);
    }

    @Step
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
    @Step
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
