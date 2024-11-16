package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.PowerStrip;





public interface PowerStripDAO extends GenericDAO<PowerStrip, Integer> {
  
	List<PowerStrip> findAll();
	






}


