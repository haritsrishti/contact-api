package com.contact.api.response;

import lombok.Data;

import java.util.UUID;

@Data
public class ContactResponse {

    public UUID id;
    public String name;
    public String phone;
    public String email;
}
