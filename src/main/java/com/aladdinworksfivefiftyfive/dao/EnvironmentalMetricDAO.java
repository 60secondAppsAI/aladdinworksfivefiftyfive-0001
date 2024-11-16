package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.EnvironmentalMetric;





public interface EnvironmentalMetricDAO extends GenericDAO<EnvironmentalMetric, Integer> {
  
	List<EnvironmentalMetric> findAll();
	






}


