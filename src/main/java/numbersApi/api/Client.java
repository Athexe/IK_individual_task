package numbersApi.api;

import io.qameta.allure.Step;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

public class Client {
    @Step
    public Response send(Request request){
        Response res = new Response();

        System.out.println(request.getProtocol()+"://"+request.getHost()+"/"+request.getPath()+"?json "+request.getMethod());

        HttpRequest httpRequest;
        try {
            httpRequest = HttpRequest.newBuilder().
                    uri(request.getURI()).
                    method(request.getMethod(), HttpRequest.BodyPublishers.noBody()).
                    build();
            long start = new Date().getTime();
            HttpResponse<String> response = HttpClient.newBuilder().
                    followRedirects(HttpClient.Redirect.ALWAYS).
                    build().
                    send(httpRequest, HttpResponse.BodyHandlers.ofString());

            res.setStatusCode(response.statusCode());
            res.setBody(response.body());
            //res.setHeaderMap(response.headers().map());
            res.setTime(new Date().getTime()-start);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(res);
        return res;
    }
}