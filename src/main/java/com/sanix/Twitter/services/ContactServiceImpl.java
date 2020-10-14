package com.sanix.Twitter.services;

import com.sanix.Twitter.models.Contact;
import com.sanix.Twitter.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAll(){
        return contactRepository.findAll()
                .stream()
                .collect(toList());
    }

}
