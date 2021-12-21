package numbersApi.decorator;

import org.openqa.selenium.WebElement;

public class ButtonElement extends CustomElement {

    public ButtonElement(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        System.out.println("Click "+getWebElement().getAccessibleName());
        getWebElement().click();
    }
}
//logging