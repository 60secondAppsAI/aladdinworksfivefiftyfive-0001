package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.PowerUsageReport;





public interface PowerUsageReportDAO extends GenericDAO<PowerUsageReport, Integer> {
  
	List<PowerUsageReport> findAll();
	






}


