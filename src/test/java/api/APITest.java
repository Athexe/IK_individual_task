package api;
import numbersApi.api.Client;
import numbersApi.api.Request;
import numbersApi.api.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest {

//    ResponseSpecification checkStatusCodeAndContentType =
//            new ResponseSpecBuilder().
//                    expectStatusCode(200).
//                    expectContentType(ContentType.JSON).
//                    build();
//    @Test
//    public void test_ResponseStatusCode(){
//        given().
//                pathParam("number","26").
//                pathParam("type", "math").
//        when().
//                get("http://numbersapi.com/{number}/{type}?json").
//        then().
//                assertThat().
//                spec(checkStatusCodeAndContentType);
//    }
    @Test
    public void test_ResponseStatusCode(){
        Request request = RequestRepo.getPostman("26/math");
        Response response = new Client().send(request);
        System.out.println(response);
        Assert.assertEquals(response.getStatusCode().intValue(), 200, "invalid code");
    }

    @Test
    public void test_FoundNumber(){
        Request request = RequestRepo.getPostman("50");
        Response response = new Client().send(request);
        System.out.println(response);
        Assert.assertEquals(response.getStatusCode().intValue(), 200, "invalid code");
    }
}
