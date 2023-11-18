package com.qacart.todo.api;

import com.qacart.todo.config.EndPoints;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {
    private List<Cookie> restAssuredCookies;
    private String accessToken;
    private String userID;
    private String firstName;

    public List<Cookie> getRestAssuredCookies() {
        return this.restAssuredCookies;
    }

    public String getAccessToken() {
        return this.accessToken;
    }
    public String getUserID() {
        return this.userID;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public void register()
    {
        User user = UserUtils.generateRandomUser();
        Response response =
                given()
                        .baseUri("https://todo.qacart.com/")
                        .header("Content-Type","application/json")
                        .body(user)
                        .log().all()
                .when()
                        .post(EndPoints.API_REGISTER_END_POINT)
                .then()
                        .log().all()
                        .extract().response();

        if(response.statusCode() != 201) {
            throw new RuntimeException("Something went wrong with this request");
        }
        restAssuredCookies = response.detailedCookies().asList();
        accessToken = response.path("access_token");
        userID = response.path("userID");
        firstName = response.path("firstName");
    }
}
