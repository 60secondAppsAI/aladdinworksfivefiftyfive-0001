package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.User;

import java.util.Optional;




public interface UserDAO extends GenericDAO<User, Integer> {
  
	List<User> findAll();
	






}


