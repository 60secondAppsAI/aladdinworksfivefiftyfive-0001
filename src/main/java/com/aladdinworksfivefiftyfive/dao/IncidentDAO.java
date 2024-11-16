package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.Incident;





public interface IncidentDAO extends GenericDAO<Incident, Integer> {
  
	List<Incident> findAll();
	






}


