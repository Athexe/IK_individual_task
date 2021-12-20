package numbersApi.decorator;

import org.openqa.selenium.WebElement;

public class InputElement extends CustomElement {

    public InputElement(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String str) {
        getWebElement().sendKeys(str);
    }

    public Object getText() {
        return getWebElement().getText();
    }

    public void clear() {
        getWebElement().clear();
    }

    public void click() {
        getWebElement().click();
    }

    public Object getAttribute(String value) {
        return getWebElement().getAttribute(value);
    }
}
