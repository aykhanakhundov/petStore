package com.petStore.test;


import com.petStore.api.pojo.Order;
import com.petStore.utilities.PetStore_Utils;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;
import static com.petStore.api.StoreEndpoints.*;

public class TestStore {

    Order orderPojo;

    @Test(priority = 1)
    public void testPostRequest() {
        orderPojo = PetStore_Utils.setOrder();
        Response response = createOrder(orderPojo);
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
    }


    @Test(priority = 2)
    public void testGetRequest() {
        Response response = getOrder(this.orderPojo.getId());
        System.out.println("==============");
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
    }


    @Test(priority = 3)
    public void testDeleteRequest() {
        Response response = deleteOrder(this.orderPojo.getId());
        System.out.println("================");
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
        Response responseAfterDelete = getOrderAfterDelete(this.orderPojo.getId());
        System.out.println("================");
        responseAfterDelete.prettyPrint();
        assertEquals(responseAfterDelete.statusCode(), 404);
    }


    @Test(priority = 4)
    public void testGetInventory() {
        Response response = getInventory();
        System.out.println("================");
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
    }

}
