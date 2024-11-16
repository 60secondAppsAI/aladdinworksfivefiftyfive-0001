package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.NetworkSwitch;





public interface NetworkSwitchDAO extends GenericDAO<NetworkSwitch, Integer> {
  
	List<NetworkSwitch> findAll();
	






}


