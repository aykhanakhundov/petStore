package com.petStore.api;

public class Routes {

    public static final String BASE_URI = "https://petstore.swagger.io/v2";

    public static final String POST = "/user";

    public static final String POST_LIST = "user/createWithList";

    public static final String GET_PUT_DELETE = "/user/{username}";

    public static final String POST_STORE = "store/order";

    public static final String GET_DELETE_STORE = "/store/order/{orderId}";

    public static final String GET_INVENTORY_STORE = "store/inventory";

}
