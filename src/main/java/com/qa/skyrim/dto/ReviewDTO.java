package com.qa.skyrim.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ReviewDTO {
	
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 1024, message = "A review may not be longer than 1024 characters")
	private String reviewDesc;
	
	public ReviewDTO() {
		super();
	}

	public ReviewDTO(int id, String reviewDesc) {
		super();
		this.id = id;
		this.reviewDesc = reviewDesc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReviewDesc() {
		return reviewDesc;
	}

	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}

	@Override
	public String toString() {
		return "ReviewDTO [id=" + id + ", reviewDesc=" + reviewDesc + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, reviewDesc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewDTO other = (ReviewDTO) obj;
		return id == other.id && Objects.equals(reviewDesc, other.reviewDesc);
	}
	
	
	
}
