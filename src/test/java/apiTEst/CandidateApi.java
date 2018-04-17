package apiTEst;

import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by rojandhakal on 3/8/2018.
 */
public class CandidateApi {

    private   static  String access=null;

    @BeforeClass
    public void generateToken(){
        GetToken t = new GetToken();
        access = t.getToken();
    }

    @Test
    //to check if number is duplicate or not
    public void candidateValidationByPhone() {


        JSONObject jsonObject = new JSONObject().put("mobilePhone", "9849514267");
        String msg = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject.toString()).post(Constant.baseUrl + "api/search/candidate/phone?access_token="+access ).then().statusCode(401).log().all().extract().path("status");
       Assert.assertEquals(msg,"UNSUCCESS");


        JSONObject jsonObject2 = new JSONObject().put("mobilePhone", "9866954000");
        String mssg = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject2.toString()).post(Constant.baseUrl + "api/search/candidate/phone?access_token="+access ).then().statusCode(200).log().all().extract().path("status");
        Assert.assertEquals(mssg,"SUCCESS");

    }

    @Test
    //to check if number is duplicate or not
    public void changeStatus() {


        JSONObject jsonObject = new JSONObject().put("candidateId", "4");
        JSONObject jsonObject1 = new JSONObject().put("status", "Hired");
        String msg = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject.toString()).post(Constant.baseUrl + "api/candidate/status?access_token="+access ).then().statusCode(200).log().all().extract().path("status");
        Assert.assertEquals(msg,"SUCCESS");




    }


}
