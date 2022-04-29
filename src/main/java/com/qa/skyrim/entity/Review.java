package com.qa.skyrim.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity 
@Table(name = "review")
public class Review {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 2, max = 1024, message = "A review may not be more than 1024 characters long")
	private String reviewDesc;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int id, String reviewDesc) {
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
		return "Review [id=" + id + ", reviewDesc=" + reviewDesc + "]";
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
		Review other = (Review) obj;
		return id == other.id && Objects.equals(reviewDesc, other.reviewDesc);
	}
	
	
	
	
}
