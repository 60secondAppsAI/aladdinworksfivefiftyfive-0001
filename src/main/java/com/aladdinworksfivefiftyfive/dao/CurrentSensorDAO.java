package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.CurrentSensor;





public interface CurrentSensorDAO extends GenericDAO<CurrentSensor, Integer> {
  
	List<CurrentSensor> findAll();
	






}


