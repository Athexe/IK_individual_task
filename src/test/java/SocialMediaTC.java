import numbersApi.bo.SearchBO;
import numbersApi.bo.SocialMediaBO;
import org.junit.Assert;
import org.junit.Test;

public class SocialMediaTC extends BaseTC{
    @Test
    public void TestFacebookLink(){
        driver.get("http://numbersapi.com/#42");
        SocialMediaBO socialMediaBO = new SocialMediaBO(driver);
        socialMediaBO.test("Facebook");
        //Assert.assertTrue(socialMediaBO.test("Facebook"));
    }
}
