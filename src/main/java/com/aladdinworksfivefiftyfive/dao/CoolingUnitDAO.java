package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.CoolingUnit;





public interface CoolingUnitDAO extends GenericDAO<CoolingUnit, Integer> {
  
	List<CoolingUnit> findAll();
	






}


