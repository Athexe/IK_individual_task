package numbersApi.bo;

import numbersApi.po.SearchPO;
import org.openqa.selenium.WebDriver;

public class SearchBO {
    WebDriver driver;
    public SearchBO(WebDriver driver){
        this.driver = driver;
    }
    public boolean test(String number){
        SearchPO searchPO = new SearchPO(driver);
        searchPO.clickOnSearch();
        searchPO.send(number);
        searchPO.submit();
        return true;
    };
    public boolean checkLabel(){
        SearchPO searchPO = new SearchPO(driver);
        if(searchPO.checkLabelForUnknownUrl()==true){
            return true;
        }else{
            return false;
        }
    };
}
