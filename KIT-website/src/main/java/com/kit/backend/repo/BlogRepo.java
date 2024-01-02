package com.kit.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.backend.entity.Blog;

@Repository
public interface BlogRepo extends JpaRepository<Blog, String> {

}
