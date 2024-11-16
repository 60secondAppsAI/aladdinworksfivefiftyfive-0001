package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.PowerSupply;





public interface PowerSupplyDAO extends GenericDAO<PowerSupply, Integer> {
  
	List<PowerSupply> findAll();
	






}


