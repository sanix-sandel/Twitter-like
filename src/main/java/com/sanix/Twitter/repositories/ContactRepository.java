package com.sanix.Twitter.repositories;

import com.sanix.Twitter.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
