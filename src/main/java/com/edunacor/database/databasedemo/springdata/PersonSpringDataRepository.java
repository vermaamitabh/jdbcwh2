package com.edunacor.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edunacor.database.databasedemo.entity.Person;

public interface PersonSpringDataRepository 
					extends JpaRepository<Person, Integer>{
	
}
