package numbersApi.api;

import io.qameta.allure.Step;

public class RequestRepo {
    @Step
    public static Request getPostman(String path){
        Request request = new Request();
        request.setProtocol("http");
        request.setHost("numbersapi.com");
        request.setPath(path);
        request.setMethod("GET");
        return request;
    }
}
