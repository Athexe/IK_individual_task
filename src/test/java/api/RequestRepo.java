package api;

import numbersApi.api.Request;

import java.util.Map;

public class RequestRepo {
    public static Request getPostman(String path){
        Request request = new Request();
        request.setProtocol("http");
        request.setHost("numbersapi.com");
        request.setPath(path);
        request.setMethod("GET");
        return request;
    }
}
