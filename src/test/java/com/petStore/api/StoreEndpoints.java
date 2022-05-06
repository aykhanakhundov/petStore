package com.petStore.api;

import com.petStore.api.pojo.Order;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.petStore.api.Routes.*;
import static io.restassured.RestAssured.*;

public class StoreEndpoints {


    public static Response createOrder(Order body) {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(body)
                .when().post(POST_STORE)
                .then().statusCode(200)
                .extract().response();
    }


    public static Response getOrder(int orderId) {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .pathParam("orderId", orderId)
                .when().get(GET_DELETE_STORE)
                .then().statusCode(200)
                .extract().response();
    }

    public static Response deleteOrder(int orderId) {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .pathParam("orderId", orderId)
                .when().delete(GET_DELETE_STORE)
                .then().statusCode(200)
                .extract().response();
    }

    public static Response getOrderAfterDelete(int orderId) {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .pathParam("orderId", orderId)
                .when().get(GET_DELETE_STORE)
                .then().statusCode(404)
                .extract().response();
    }

    public static Response getInventory() {
        baseURI = BASE_URI;
        return given().accept(ContentType.JSON)
                .when().get(GET_INVENTORY_STORE)
                .then().statusCode(200)
                .extract().response();
    }
}
