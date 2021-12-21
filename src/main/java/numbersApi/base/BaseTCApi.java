package numbersApi.base;

import org.testng.annotations.DataProvider;

public class BaseTCApi {
    @DataProvider()
    public static Object[][] apiStatusCodeDataProvider(){
        return new Object[][]{{"26/math",200},{"gg",404}};
    }
}
