package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.Rack;





public interface RackDAO extends GenericDAO<Rack, Integer> {
  
	List<Rack> findAll();
	






}


