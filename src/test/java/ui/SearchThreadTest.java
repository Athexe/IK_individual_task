package ui;

import numbersApi.bo.SearchBO;
import org.junit.Assert;
import org.testng.annotations.Test;

public class SearchThreadTest extends BaseTC {

    @Test
    public void SearchTestNumber() {
        SearchBO searchBO = new SearchBO();
        Assert.assertTrue(searchBO.enterSearchInput("24"));
    }

    @Test
    public void SearchTestString(){
        SearchBO searchBO = new SearchBO();
        searchBO.enterSearchInput("gg");
        Assert.assertTrue(searchBO.checkLabel());
    }
}
