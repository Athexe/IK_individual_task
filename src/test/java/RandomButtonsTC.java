import numbersApi.bo.RandomButtonsBO;
import numbersApi.bo.SearchBO;
import org.junit.Assert;
import org.junit.Test;

public class RandomButtonsTC extends BaseTC{
    @Test
    public void TryRandomTriviaButton(){
        driver.get("http://numbersapi.com/#42");
        driver.manage().window().maximize();
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        Assert.assertTrue(randomButtonsBO.test("Trivia"));
    }
    @Test
    public void TryRandomYearButton(){
        driver.get("http://numbersapi.com/#42");
        driver.manage().window().maximize();
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        Assert.assertTrue(randomButtonsBO.test("Year"));
    }
    @Test
    public void TryRandomDateButton(){
        driver.get("http://numbersapi.com/#42");
        driver.manage().window().maximize();
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        Assert.assertTrue(randomButtonsBO.test("Date"));
    }
    @Test
    public void TryRandomMathButton(){
        driver.get("http://numbersapi.com/#42");
        driver.manage().window().maximize();
        RandomButtonsBO randomButtonsBO = new RandomButtonsBO();
        Assert.assertTrue(randomButtonsBO.test("Math"));
    }
}
