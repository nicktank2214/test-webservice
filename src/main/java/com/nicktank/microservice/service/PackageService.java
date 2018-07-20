package com.nicktank.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicktank.microservice.domain.Package;
import com.nicktank.microservice.repository.PackageRepository;




@Service
public class PackageService {

	//inject package repository
	private PackageRepository packageRepository;

	
	//constructor
	@Autowired
	public PackageService(PackageRepository packageRepository) {
		this.packageRepository = packageRepository;
	}
	
	
	public Iterable<Package> findAllPackages() {
		return packageRepository.findAll();
	}
}
