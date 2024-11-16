package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.IncidentReport;





public interface IncidentReportDAO extends GenericDAO<IncidentReport, Integer> {
  
	List<IncidentReport> findAll();
	






}


