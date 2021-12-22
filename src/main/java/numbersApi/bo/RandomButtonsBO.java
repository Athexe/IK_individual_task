package numbersApi.bo;
import numbersApi.po.RandomButtonsPO;

public class RandomButtonsBO {
    public boolean pressButtonAndCheckResult(String type){
        new RandomButtonsPO().clickRandomButton(type);
        return new RandomButtonsPO().checkResult(type);
    }
}
