package com.qa.skyrim.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewReviewDTO {
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 1024, message = "A review may not be longer than 1024 characters")
	private String reviewDesc;
	
	public NewReviewDTO() {
		super();
	}

	public String getReviewDesc() {
		return reviewDesc;
	}

	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reviewDesc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NewReviewDTO other = (NewReviewDTO) obj;
		return Objects.equals(reviewDesc, other.reviewDesc);
	}
	
}
