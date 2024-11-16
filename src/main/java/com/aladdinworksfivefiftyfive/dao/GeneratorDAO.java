package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.Generator;





public interface GeneratorDAO extends GenericDAO<Generator, Integer> {
  
	List<Generator> findAll();
	






}


