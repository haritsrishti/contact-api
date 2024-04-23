package com.contact.api.controller;

import com.contact.api.request.Contacts;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/v1/contacts")
public class ContactController {

        //This Controller is going to accept incoming request and deligate to service

    @GetMapping()
    public Contacts getContactDetails(String id){
        return new Contacts("c1","Srishti Harit","haritsrishti@gmail.com","8800138219");
    }

}


