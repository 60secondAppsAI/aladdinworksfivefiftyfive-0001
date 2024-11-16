package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.MaintenanceRecord;





public interface MaintenanceRecordDAO extends GenericDAO<MaintenanceRecord, Integer> {
  
	List<MaintenanceRecord> findAll();
	






}


