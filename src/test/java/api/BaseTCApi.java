package api;

import numbersApi.allure.CustomAllureApiListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

@Listeners({CustomAllureApiListener.class})
public class BaseTCApi{
    @DataProvider()
    public static Object[][] apiStatusCodeDataProvider(){
        return new Object[][]{{"26/math",200},{"gg",404}};
    }

}
