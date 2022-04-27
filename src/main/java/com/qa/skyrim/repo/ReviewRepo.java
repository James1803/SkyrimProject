package com.qa.skyrim.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.skyrim.entity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

}
