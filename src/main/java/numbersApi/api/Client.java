package numbersApi.api;

import org.testng.Assert;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

public class Client {
    public Response send(Request request){
        Response res = new Response();

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
            res.setHeaderMap(response.headers().map());
            res.setTime(new Date().getTime()-start);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return res;
    }
    public static void main(String[] args){
        Request request = new Request();
        request.setProtocol("http");
        request.setHost("numbersapi.com");
        request.setPath("24");
        request.setMethod("GET");

        Response response = new Client().send(request);

        Assert.assertEquals(response.getStatusCode().intValue(),200,"invalid code");
    }
}
