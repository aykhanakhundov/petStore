package com.petStore.utilities;

import com.github.javafaker.Faker;
import com.petStore.api.Status;
import com.petStore.api.pojo.Order;
import com.petStore.api.pojo.User;

public class PetStore_Utils {


    public static User setUser() {
        User userPojo = new User();
        Faker faker = new Faker();
        userPojo.setId(faker.number().numberBetween(1, 1000));
        userPojo.setUserName(faker.bothify("???#?#??#"));
        userPojo.setFirstName(faker.name().firstName());
        userPojo.setLastName(faker.name().lastName());
        userPojo.setEmail(faker.internet().emailAddress());
        userPojo.setPassword(faker.internet().password());
        userPojo.setPhone(faker.phoneNumber().cellPhone());
        userPojo.setUserStatus(faker.number().numberBetween(1, 5));
        return userPojo;
    }


    public static Order setOrder() {
        Order orderPojo = new Order();
        Faker faker = new Faker();
        orderPojo.setId(faker.number().numberBetween(1, 1000));
        orderPojo.setPetId(faker.number().numberBetween(1, 1000));
        orderPojo.setQuantity(faker.number().numberBetween(1, 10));
        //orderPojo.setShipDate();
        orderPojo.setStatus(Status.values()[faker.number().numberBetween(0, 2)]);
        orderPojo.setComplete(true);
        //System.out.println("orderPojo = " + orderPojo);
        return orderPojo;
    }
}
