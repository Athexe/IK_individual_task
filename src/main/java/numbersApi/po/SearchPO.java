package numbersApi.po;
import io.qameta.allure.Step;
import numbersApi.decorator.CustomDecorator;
import numbersApi.decorator.InputElement;
import numbersApi.parallel_run.BrowserFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class SearchPO {

    @FindBy(id="search-text")
    private InputElement searchInput;

    @FindBy(id="result-temporary-text")
    private InputElement resultInput;

    public SearchPO(){
        PageFactory.initElements(new CustomDecorator(BrowserFactory.getDriver()),this);
    }

    @Step
    public SearchPO clickOnSearch(){
        searchInput.click();
        return this;
    }

    @Step
    public SearchPO send(String str){
        searchInput.clear();
        searchInput.sendKeys(str);
        return this;
    }

    @Step
    public SearchPO submit(){
        searchInput.sendKeys("\r\n");
        return this;
    }

    @Step
    public boolean checkLabelForUnknownUrl(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException ex){}

        if(resultInput.getText().equals("Uh oh, we don't understand that URL :(\n" +
                "Maybe read the API docs below?")){
            return true;
        }else{
            return false;
        }
    }
}
