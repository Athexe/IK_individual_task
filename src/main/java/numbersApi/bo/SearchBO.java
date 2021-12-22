package numbersApi.bo;
import numbersApi.po.SearchPO;

public class SearchBO {
    public boolean enterSearchInput(String number){
        new SearchPO()
                .clickOnSearch()
                .send(number)
                .submit();
        return true;
    }
    public boolean checkLabel(){
        return new SearchPO().checkLabelForUnknownUrl();
    }
}
