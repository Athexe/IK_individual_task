import numbersApi.bo.SearchBO;
import org.junit.Assert;
import org.junit.Test;


public class SearchTC extends BaseTC{
    @Test
    public void SearchTestNumber(){
        driver.get("http://numbersapi.com/#42");
        driver.manage().window().maximize();
        SearchBO searchBO = new SearchBO(driver);
        Assert.assertTrue(searchBO.test("24"));
    }
    @Test
    public void SearchTestString(){
        driver.get("http://numbersapi.com/#42");
        driver.manage().window().maximize();
        SearchBO searchBO = new SearchBO(driver);
        searchBO.test("gg");
        Assert.assertTrue(searchBO.checkLabel());
    }

}
