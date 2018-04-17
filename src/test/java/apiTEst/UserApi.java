package apiTEst;



import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

/**
 * Created by rojandhakal on 3/4/2018.
 */
public class UserApi {

    private   static  String access=null;

@BeforeClass
    public void generateToken(){
        GetToken t = new GetToken();
         access = t.getToken();
    }



    @Test(enabled = true,priority = 2)
    public void loginTest(){
        ResponseBody body=get(Constant.baseUrl+"api/user/authenticated?access_token="+access).getBody();
        JsonPath response=body.jsonPath();
        Assert.assertEquals(body.asString().contains("ramesh.khadka@suvidhatech.com"),true);
        Assert.assertEquals(response.get("email"),"ramesh.khadka@suvidhatech.com","valid id");



    }

    @Test(enabled = false)
    public void clientList(){

       Response body= (Response) given().accept(ContentType.JSON)
                .contentType(ContentType.JSON).body("{}")
                .post(Constant.baseUrl+"api/client/info?page=0&size=10&access_token="+access).getBody();
       JsonPath res=body.jsonPath();
    int j=   res.get("totalPages");


    for(int i=0;i<j;i++){
        System.out.println("test for "+i);
        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON).body("{}")
                .post(Constant.baseUrl+"api/client/info?page="+i+"&size="+j+"&access_token="+access).then().statusCode(200).body("isEmpty()", Matchers.is(false)).log().all();
    }



    }


    @Test
    public void searchUserByName() {
        JSONObject jsonObject = new JSONObject().put("userName", "Alex");
        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject.toString()).post(Constant.baseUrl + "api/user/search?access_token=" + access).then().log().all();

    }


    @Test
    public void getAllUser(){
        JSONObject jsonObject = new JSONObject().put("userName", "");
        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject.toString()).post(Constant.baseUrl + "api/user/search?access_token=" + access).then().log().all();
    }


}
