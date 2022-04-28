package com.qa.skyrim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.skyrim.repo.OneRepo;

//@Service
//public class OneService {
//	
//	private OneRepo oneRepository;
//
//	@Autowired
//	public OneService(OneRepo oneRepo) {
//		super();
//		this.oneRepository = oneRepository;
//	}
//
//	public List<OneDTO> getOnes() {
//		List<One> ones = oneRepository.findAll();
//		List<OneDTO> dtos = new ArrayList<>();
//		
//		for (One one : ones) {
//			dtos.add(this.toDTO(one));
//		}
//		return dtos;
//	}
//	
//	public OneDTO getOne(int id) {
//		Optional<One> one = oneRepository.findById(id);
//		
//		if (one.isPresent()) {
//			return this.toDTO(one.get());
//		}
//		throw new EntityNotFoundException("One not found with id " + id);
//	}