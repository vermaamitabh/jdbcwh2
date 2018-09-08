package com.edunacor.database.databasedemo;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edunacor.database.databasedemo.entity.Person;
import com.edunacor.database.databasedemo.jpa.PersonJpaRepository;
import com.edunacor.database.databasedemo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(SpringDataDemoApplication.class);
	
	@Autowired
	PersonSpringDataRepository personJpaDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("User id 1000 =>: {}", personJpaDao.findById(10001));
		
		logger.info("Deleting 10002 => No. of rows impacted");
		personJpaDao.deleteById(10002);
		
		logger.info("Insert 10004 => {}",personJpaDao.save
				(new Person("Tara","VA",new Timestamp(System.currentTimeMillis()))));
		
		logger.info("Update 10003=> {}",personJpaDao.save
				(new Person(10003,"Pieter","Utrecht",new Timestamp(System.currentTimeMillis()))));
				
		logger.info("UserList => {}",personJpaDao.findAll());
	}
}
