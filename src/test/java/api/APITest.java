package api;
import numbersApi.api.Client;
import numbersApi.api.Request;
import numbersApi.api.RequestRepo;
import numbersApi.api.Response;
import numbersApi.base.BaseTCApi;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest extends BaseTCApi {

    @Test(dataProvider = "apiStatusCodeDataProvider")
    public void test_ResponseStatusCode(String path, int statusCode){
        Request request = RequestRepo.getPostman(path);
        Response response = new Client().send(request);
        Assert.assertEquals(response.getStatusCode().intValue(), statusCode, "invalid code");
    }

    @Test
    public void test_FoundNumber(){
        Request request = RequestRepo.getPostman("50");
        Response response = new Client().send(request);
        Assert.assertEquals(response.bodyToJSON().get("number"), 50,"invalid response" );
    }


    @Test
    public void test_RandomYear(){
        Request request = RequestRepo.getPostman("random/year");
        Response response = new Client().send(request);
        Assert.assertTrue(response.bodyToJSON().get("found").equals(true) & response.bodyToJSON().get("type").equals("year"));
    }

    @Test
    public void test_textByNumberAndType(){
        Request request = RequestRepo.getPostman("1457/math");
        Response response = new Client().send(request);
        Assert.assertTrue(response.bodyToJSON().get("text").equals("1457 is a number that does not have any digits in common with its cube.") & response.bodyToJSON().get("type").equals("math"));
    }
}
