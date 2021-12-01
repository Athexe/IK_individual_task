package numbersApi.bo;

import numbersApi.po.SearchPO;
import numbersApi.po.SocialMediaPO;
import org.openqa.selenium.WebDriver;

public class SocialMediaBO {
    WebDriver driver;
    public SocialMediaBO(WebDriver driver){
        this.driver = driver;
    }
    public boolean test(String site){
        SocialMediaPO socialMediaPO = new SocialMediaPO(driver);
        socialMediaPO.clickOnSite(site);
        //socialMediaPO.checkResultUrl();
        return true;
    };
}
