package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.CapacityAnalysis;





public interface CapacityAnalysisDAO extends GenericDAO<CapacityAnalysis, Integer> {
  
	List<CapacityAnalysis> findAll();
	






}


