package ui;

import numbersApi.bo.ArrowsBO;
import org.junit.Assert;
import org.testng.annotations.Test;

public class ArrowsTest extends BaseTC {

    @Test(dataProvider = "arrowsDataProvider")
    public void tryRandomButton(String type){
        ArrowsBO arrowsBO = new ArrowsBO();
        Assert.assertTrue(arrowsBO.pressArrowAndCheckResult(type));
    }
}
