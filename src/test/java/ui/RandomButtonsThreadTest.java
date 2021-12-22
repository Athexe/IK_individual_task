package ui;

import numbersApi.bo.RandomButtonsBO;
import org.junit.Assert;
import org.testng.annotations.Test;

public class RandomButtonsThreadTest extends BaseTC {

    @Test(dataProvider = "randomButtonsDataProvider")
    public void tryRandomButton(String type){
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        Assert.assertTrue(randomButtonsBO.pressButtonAndCheckResult(type));
    }
}
