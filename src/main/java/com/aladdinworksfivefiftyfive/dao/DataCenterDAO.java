package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.DataCenter;





public interface DataCenterDAO extends GenericDAO<DataCenter, Integer> {
  
	List<DataCenter> findAll();
	






}


