package com.kit.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.backend.entity.NewsLetter;
@Repository
public interface NewsLetterRepo extends JpaRepository<NewsLetter,String> {

}
