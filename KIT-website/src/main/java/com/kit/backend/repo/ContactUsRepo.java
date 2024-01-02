package com.kit.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.backend.entity.ContactUs;
@Repository
public interface ContactUsRepo extends JpaRepository<ContactUs,String> {

}
