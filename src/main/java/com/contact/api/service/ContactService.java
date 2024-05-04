package com.contact.api.service;

import com.contact.api.Entity.Contact;
import com.contact.api.repository.ContactRepository;
import com.contact.api.request.ContactRequest;
import com.contact.api.response.ContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class ContactService {


    //Services going to perform functional operations depending on requirments and perform the crud operations

    @Autowired
    ContactRepository contactRepository;

    public ContactResponse createContact(ContactRequest contactRequest){
        Contact contact = new Contact();

        contact.setName(contactRequest.getName());
        contact.setPhone(contactRequest.getPhone());
        contact.setEmail(contactRequest.getEmail());

        Contact saveContact = contactRepository.save(contact);

        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setId(saveContact.getId());
        contactResponse.setName(saveContact.getName());
        contactResponse.setEmail(saveContact.getEmail());
        contactResponse.setPhone(saveContact.getPhone());

        return contactResponse;
    }

    public ContactResponse updateContact(int id, ContactRequest contactRequest) {

        Contact contact = new Contact();

        contact.setName(contactRequest.getName());
        contact.setPhone(contactRequest.getPhone());
        contact.setEmail(contactRequest.getEmail());

        Contact entityResponse = contactRepository.save(contact);

        ContactResponse updatedContact = new ContactResponse();
        updatedContact.setId(entityResponse.getId());
        updatedContact.setName(entityResponse.getName());
        updatedContact.setEmail(entityResponse.getEmail());
        updatedContact.setPhone(entityResponse.getPhone());
        return updatedContact;
    }

    public void deleteContactById(UUID id) {

        Optional<Contact> dltContact = contactRepository.findById(id);
        dltContact.ifPresent(a -> {
            contactRepository.deleteById(a.getId());
        });


    }

    public ContactResponse findContactById(UUID id) {
        Optional<Contact> contact = contactRepository.findById(id);

        ContactResponse contactResponse = new ContactResponse();
        if(contact.isPresent()){

            contactResponse.setId(contact.get().getId());
            contactResponse.setName(contact.get().getName());
            contactResponse.setEmail(contact.get().getEmail());
            contactResponse.setPhone(contact.get().getPhone());

        }



        return contactResponse;
    }
}