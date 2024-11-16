package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.StaticTransferSwitch;





public interface StaticTransferSwitchDAO extends GenericDAO<StaticTransferSwitch, Integer> {
  
	List<StaticTransferSwitch> findAll();
	






}


