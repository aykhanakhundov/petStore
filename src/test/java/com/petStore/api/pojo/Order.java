package com.petStore.api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.petStore.api.Status;
import lombok.Data;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
    private int id, petId, quantity;
    //private DateAndTime shipDate;
    private String shipDate;
    private Status status;
    private boolean complete;

}
