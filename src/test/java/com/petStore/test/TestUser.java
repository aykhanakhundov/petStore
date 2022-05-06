package com.petStore.test;


import static com.petStore.api.UserEndpoints.*;

import com.github.javafaker.Faker;
import com.petStore.api.pojo.User;

import static com.petStore.utilities.PetStore_Utils.*;
import static org.testng.AssertJUnit.assertEquals;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestUser {


    User userPojo;
    Faker faker;

    @Test(priority = 1)
    public void testPostRequest() {
        userPojo = setUser();
        Response response = createUser(userPojo);
        assertEquals(response.statusCode(), 200);
    }


    @Test(priority = 2)
    public void testGetRequest() {
        Response response = getUser(this.userPojo.getUserName());
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
    }


    @Test(priority = 3)
    public void testPutRequest() {

        userPojo.setFirstName(userPojo.getFirstName() + " updated");
        userPojo.setLastName(userPojo.getLastName() + " updated");
        userPojo.setEmail(userPojo.getEmail() + " updated");
        userPojo.setPassword(userPojo.getPassword() + " updated");
        userPojo.setPhone(userPojo.getPhone() + " updated");
        Response response = updateUser(userPojo.getUserName(), userPojo);
        System.out.println("==============");
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
        System.out.println("==============");
        getUser(userPojo.getUserName())
                .prettyPrint();
    }

    @Test(priority = 4)
    public void testDeleteRequest() {
        Response response = deleteUser(userPojo.getUserName());

        assertEquals(response.statusCode(), 200);

        Response responseAfterDelete = getUserAfterDelete(userPojo.getUserName());

        responseAfterDelete.prettyPrint();

        // System.out.println("responseAfterDelete.statusCode() = " + responseAfterDelete.statusCode());

        assertEquals(responseAfterDelete.statusCode(), 404);
    }


    @Test(priority = 5)
    public void testPostRequestWithList() {
        faker = new Faker();
        List<User> listOfUserForPostRequest = new ArrayList<>();
        int randomUserCount = faker.number().numberBetween(4, 10);
        for (int i = 0; i < randomUserCount; i++) {
            listOfUserForPostRequest.add(setUser());
        }
        Response response = createUserWithList(listOfUserForPostRequest);
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
    }


}
