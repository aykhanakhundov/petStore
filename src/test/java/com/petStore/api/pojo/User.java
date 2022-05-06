package com.petStore.api.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
   private int id;
   @JsonProperty("username")
   private String userName;
   private String firstName, lastName, email, password, phone;
   private int userStatus;
}
