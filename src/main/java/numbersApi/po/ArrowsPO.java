package numbersApi.po;

import numbersApi.decorator.ButtonElement;
import numbersApi.decorator.CustomDecorator;
import numbersApi.decorator.InputElement;
import numbersApi.parallel_run.BrowserFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArrowsPO {

    @FindBy(className="counter-button-up")
    private ButtonElement upButton;

    @FindBy(className="counter-button-down")
    private ButtonElement downButton;

    @FindBy(id="search-text")
    private InputElement searchInput;

    public ArrowsPO(){
        PageFactory.initElements(new CustomDecorator(BrowserFactory.getDriver()),this);
    }

    public void clickArrow(String type){
        switch(type){
            case "Up":
                upButton.click();
                break;
            case "Down":
                downButton.click();
                break;
        }
    }
    public boolean checkResult(String type) {
        switch (type) {
            case ("Up"):
                if (searchInput.getAttribute("value").equals("43")) {
                    return true;
                }
            case ("Down"):
                if (searchInput.getAttribute("value").equals("41")) {
                    return true;
                }
            default: return false;
        }
    }
}