package com.petStore.api;

import static com.petStore.api.Routes.*;
import static io.restassured.RestAssured.*;
import com.petStore.api.pojo.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

public class UserEndpoints {


    public static Response getUser(String userName) {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .pathParam("username", userName)
                .when().get(GET_PUT_DELETE)
                .then().statusCode(200)
                .extract().response();
    }


    public static Response getUserAfterDelete(String userName) {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .pathParam("username", userName)
                .when().get(GET_PUT_DELETE)
                .then().statusCode(404)
                .extract().response();
    }


    public static Response updateUser(String username, User body) {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .body(body)
                .when().put(GET_PUT_DELETE)
                .then().statusCode(200)
                .extract().response();
    }

    public static Response deleteUser(String username) {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .pathParam("username", username)
                .when().delete(GET_PUT_DELETE)
                .then().statusCode(200)
                .extract().response();
    }


    public static Response createUser(User body) {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when().post(POST)
                .then().statusCode(200)
                .extract().response();
    }

    public static Response createUserWithList(List<User> listOfUsers) {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(listOfUsers)
                .when().post(POST_LIST)
                .then().statusCode(200)
                .extract().response();
    }

}
