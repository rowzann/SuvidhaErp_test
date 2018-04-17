package apiTEst;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

/**
 * Created by rojandhakal on 3/12/2018.
 */
public class CommonApi {





    @Test
    // is location is according to parent -child order?
        public void getLocationById(){
        GetToken t = new GetToken();
        String access = t.getToken();
//find district name from state id
        JSONObject jsonObject=new JSONObject().put("parentLocationId","73").put("type","Dist");
            given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject.toString()).post(Constant.baseUrl+"api/location/type?access_token="+access).then().statusCode(200).log().all();
//find state from country id
        JSONObject jsonObject2=new JSONObject().put("parentLocationId","1").put("type","ST");
      List<String> location= given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject2.toString()).post(Constant.baseUrl+"api/location/type?access_token="+access).then().body("isEmpty()",Matchers.is(false)).statusCode(200).extract().path("locationName");

Assert.assertTrue(location.contains("Bagmati")&&location.contains("Gandaki")&&location.contains("Narayani")&&location.contains("Seti"));

    //find city name from district id
        JSONObject jsonObject3=new JSONObject().put("parentLocationId","3").put("type","City");
        List<String> location2=     given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject3.toString()).post(Constant.baseUrl+"api/location/type?access_token="+access).then().body("isEmpty()",Matchers.is(false)).statusCode(200).extract().path("locationName");
        Assert.assertTrue(location2.contains("Lalitpur")&&location2.contains("Bhaktapur")&&location2.contains("Dhading")&&location2.contains("Nuwakot"));

    }





    }
