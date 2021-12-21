package numbersApi.decorator;

import org.openqa.selenium.WebElement;

public class InputElement extends CustomElement {

    public InputElement(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String str) {
        getWebElement().sendKeys(str);
        if(str.equals("\r\n")){
            System.out.println("Send keys Enter");
        }
        if(!str.equals("\r\n")){
            System.out.println("Send keys "+str);
        }

    }

    public Object getText() {
        System.out.println("Get Text "+getWebElement().getText());
        return getWebElement().getText();
    }

    public void clear() {
        System.out.println("Clear input");
        getWebElement().clear();
    }

    public void click() {
        System.out.println("Click "+getWebElement().getAriaRole());
        getWebElement().click();
    }

    public Object getAttribute(String value) {
        System.out.println("Get attribute by "+value+" "+getWebElement().getAttribute(value));
        return getWebElement().getAttribute(value);
    }
}