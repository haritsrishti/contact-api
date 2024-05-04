package com.contact.api.controller;

import com.contact.api.request.ContactRequest;
import com.contact.api.response.ContactResponse;
import com.contact.api.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@ResponseBody
@RequestMapping("/v1/contacts")
public class ContactController {

        //This Controller is going to accept incoming request and deligate to service

    @Autowired
    private ContactService contactService;

    @GetMapping("/{id}")
    public ResponseEntity getContactDetails(@PathVariable UUID id){
        ContactResponse contactById = contactService.findContactById(id);
        if(contactById.getId() == null){
          return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contactById);
    }

    @PostMapping()
    public ContactResponse contectDetails(@RequestBody ContactRequest contactRequest){

        ContactResponse contact = contactService.createContact(contactRequest);
        return contact;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> updateContact(@PathVariable int id, @RequestBody ContactRequest contactRequest) {

        ContactResponse updatedContact = contactService.updateContact(id, contactRequest);
        if (updatedContact != null) {
            return new ResponseEntity<>(updatedContact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable UUID id) {

        contactService.deleteContactById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

}


