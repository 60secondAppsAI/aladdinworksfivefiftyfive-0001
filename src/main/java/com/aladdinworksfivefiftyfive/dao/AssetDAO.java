package com.aladdinworksfivefiftyfive.dao;

import java.util.List;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.domain.Asset;





public interface AssetDAO extends GenericDAO<Asset, Integer> {
  
	List<Asset> findAll();
	






}


