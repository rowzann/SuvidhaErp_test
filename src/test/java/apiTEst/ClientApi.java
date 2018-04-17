package apiTEst;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

/**
 * Created by rojandhakal on 3/19/2018.
 */
public class ClientApi {

    private   static  String access=null;

    @BeforeClass
    public void generateToken(){
        GetToken t = new GetToken();
        access = t.getToken();
    }

    @Test(enabled = true,priority = 1)
    public void listClient(){
        given().get(Constant.baseUrl + "api/client?access_token=" + access).then().statusCode(200).log().all();
        ResponseBody body=get(Constant.baseUrl+"api/client?access_token="+access).getBody();
        JsonPath response=body.jsonPath();
        Assert.assertEquals(body.asString().contains("Summit Hotel"),true);



    }
    @Test(enabled = true)
    public  void ClientProfileById(){
        JSONObject jsonObject = new JSONObject().put("clientId", 237);
      String Company_name=  given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject.toString()).post(Constant.baseUrl + "api/client/profile?access_token=" + access).then().statusCode(200).body("isEmpty()", Matchers.is(false)).log().all().extract().path("companyName");
        System.out.println(Company_name);
        Assert.assertEquals(Company_name,"client test 0799");

    }

    @Test(enabled = true)
    public  void NoClientProfileById(){
        JSONObject jsonObject = new JSONObject().put("clientId", 1000);
        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject.toString()).post(Constant.baseUrl + "api/client/profile?access_token=" + access).then().statusCode(200).body("isEmpty()", Matchers.is(true)).log().all();


    }

    @Test
    public void updateMeetingStatus(){
        JSONObject jsonObject = new JSONObject().put("meetingId", 34).put("meetingStatus","completed");
        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject.toString()).post(Constant.baseUrl + "api/meeting/status?access_token=" + access).then().statusCode(200).body("isEmpty()", Matchers.is(false)).log().all();
     String body=   given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject.toString()).post(Constant.baseUrl + "api/meeting/status?access_token=" + access).then().statusCode(200).log().all().extract().path("status");
Assert.assertEquals(body,"SUCCESS");

    }


}
