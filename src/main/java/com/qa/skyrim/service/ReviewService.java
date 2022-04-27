package com.qa.skyrim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.skyrim.dto.NewReviewDTO;
import com.qa.skyrim.dto.PostDTO;
import com.qa.skyrim.dto.ReviewDTO;
import com.qa.skyrim.entity.Review;
import com.qa.skyrim.repo.ReviewRepo;

@Service
public class ReviewService {
	
	private ReviewRepo reviewRepository;
	private PostService postService;
	private ModelMapper modelMapper;
	
	@Autowired
	public ReviewService(ReviewRepo reviewRepository, PostService postService, ModelMapper modelMapper) {
		super();
		this.reviewRepository = reviewRepository;
		this.postService = postService;
		this.modelMapper = modelMapper;
	}
	
	public List<ReviewDTO> getReviews() {
		List<Review> reviews = reviewRepository.findAll();
		List<ReviewDTO> dtos = new ArrayList<>();
		
		for (Review review : reviews) {
			dtos.add(this.toDTO(review));
		}
		return dtos;
	}
	
	public ReviewDTO getReview(int id) {
		Optional<Review> review = reviewRepository.findById(id);
		
		if (review.isPresent()) {
			return this.toDTO(review.get());
		}
		throw new EntityNotFoundException("Review not found with id " + id);
	}
	
	public ReviewDTO createReview(NewReviewDTO review) {
		Review toSave = this.modelMapper.map(review, Review.class);
		Review newReview = reviewRepository.save(toSave);
		return this.toDTO(newReview);
	}
	
	@Transactional
	public ReviewDTO updateReview(NewReviewDTO review, int id) {
		if (reviewRepository.existsById(id)) {
			Review savedReview = reviewRepository.getById(id);
			savedReview.setReviewDesc(review.getReviewDesc());
			return this.toDTO(savedReview);
		}
		throw new EntityNotFoundException("Review not found with id " + id);
	}
	
	public void deleteReview(int id) {
		if (reviewRepository.existsById(id)) {
			reviewRepository.deleteById(id);
			return;
		}
		throw new EntityNotFoundException("Review not found with id " + id); 
	}
	
	private ReviewDTO toDTO(Review review) {		
		return this.modelMapper.map(review, ReviewDTO.class);
	}
	
	public List<PostDTO> getReviewPosts(int reviewId) {
		ReviewDTO review = this.getReview(reviewId);
		List<PostDTO> posts = postService.getPostsByReviewId(reviewId);
		posts.forEach(post -> post.setReviewDTO(review));
		return posts;
	}
		

}
	
