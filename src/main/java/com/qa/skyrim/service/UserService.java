package com.qa.skyrim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.skyrim.dto.NewUserDTO;
import com.qa.skyrim.dto.PostDTO;
import com.qa.skyrim.dto.UserDTO;
import com.qa.skyrim.entity.User;
import com.qa.skyrim.repo.UserRepo;



@Service
public class UserService {
	
	private UserRepo userRepository;
	private PostService postService;
	private ModelMapper modelMapper;

	@Autowired
	public UserService(UserRepo userRepository, PostService postService, ModelMapper modelMapper) {
		super();
		this.userRepository = userRepository;
		this.postService = postService;
		this.modelMapper = modelMapper;
	}

	public List<UserDTO> getUsers() {
		List<User> users = userRepository.findAll();
		List<UserDTO> dtos = new ArrayList<>();
		
		for (User user : users) {
			dtos.add(this.toDTO(user));
		}
		return dtos;
	}
	
	public UserDTO getUser(int id) {
		Optional<User> user = userRepository.findById(id);
		
		if (user.isPresent()) {
			return this.toDTO(user.get());
		}
		throw new EntityNotFoundException("User not found with id " + id);
	}
	
	public UserDTO createUser(NewUserDTO user) {
		User toSave = this.modelMapper.map(user, User.class);
		User newUser = userRepository.save(toSave);
		return this.toDTO(newUser);
	}
	
	public UserDTO updateUser(NewUserDTO user, int id) {
		if (userRepository.existsById(id)) {
			User savedUser = userRepository.getById(id);
			savedUser.setEmail(user.getEmail());
			savedUser.setUsername(user.getUsername());
			return this.toDTO(savedUser);
		}
		throw new EntityNotFoundException("User not found with id " + id);
	}
	
	public void deleteUser(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return;
		}
		throw new EntityNotFoundException("User not found with id " + id); 
	}
	
	private UserDTO toDTO(User user) {		
		return this.modelMapper.map(user, UserDTO.class);
	}

	public List<PostDTO> getUserPosts(int userId) {
		UserDTO user = this.getUser(userId);
		List<PostDTO> posts = postService.getPostsByUserId(userId);
		posts.forEach(post -> post.setUserDTO(user));
		return posts;
	}
	
}