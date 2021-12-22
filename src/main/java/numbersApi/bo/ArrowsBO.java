package numbersApi.bo;

import numbersApi.po.ArrowsPO;


public class ArrowsBO {
    public boolean pressArrowAndCheckResult(String type){
        ArrowsPO arrowsPO = new ArrowsPO();
        arrowsPO.clickArrow(type);
        return arrowsPO.checkResult(type);
    }
}
