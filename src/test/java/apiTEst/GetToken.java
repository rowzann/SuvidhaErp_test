package apiTEst;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

/**
 * Created by rojandhakal on 3/12/2018.
 */
public class GetToken {



    private static String access = null;
    public String getToken() {
        Credentials credentials = new Credentials();
        credentials.setGrant_type("password");
        credentials.setPassword("password123");
        credentials.setUsername("ramesh.khadka@suvidhatech.com");

//
        access = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic c3V2aWRoYUFkbWluOnVzZXJzdXZpZGhh")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("grant_type", credentials.getGrant_type()).formParam("username", credentials.getUsername()).formParam("password", credentials.getPassword())
                .when()
                .post(Constant.baseUrl + "oauth/token")
                .then().log().all().extract().path("access_token");
        return access;
    }
}
