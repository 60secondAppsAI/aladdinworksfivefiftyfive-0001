package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.LightSwitch;





public interface LightSwitchDAO extends GenericDAO<LightSwitch, Integer> {
  
	List<LightSwitch> findAll();
	






}


