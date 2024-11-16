package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.MonitoringPoint;





public interface MonitoringPointDAO extends GenericDAO<MonitoringPoint, Integer> {
  
	List<MonitoringPoint> findAll();
	






}


