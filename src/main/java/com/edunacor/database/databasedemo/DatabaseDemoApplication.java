package com.edunacor.database.databasedemo;

import java.sql.Date;
import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edunacor.database.databasedemo.entity.Person;
import com.edunacor.database.databasedemo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(DatabaseDemoApplication.class);
	
	@Autowired
	PersonJdbcDAO personJdbcDao;
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("UserList => {}",personJdbcDao.findAll());
		logger.info("User id 1000 =>: {}", personJdbcDao.findById(10001));
		logger.info("Deleting 10002 => No. of rows impacted {}",personJdbcDao.deleteById(10002));
		
		logger.info("Insert 10004 => {}",personJdbcDao.insert
				(new Person(10004,"Tara","VA",new Timestamp(System.currentTimeMillis()))));
		
		logger.info("Update 10003=> {}",personJdbcDao.update
				(new Person(10003,"Pieter","Utrecht",new Timestamp(System.currentTimeMillis()))));
	}
}
