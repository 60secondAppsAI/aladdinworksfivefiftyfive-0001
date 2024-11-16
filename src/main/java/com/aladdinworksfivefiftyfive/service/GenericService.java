package com.aladdinworksfivefiftyfive.service;

import com.aladdinworksfivefiftyfive.dao.GenericDAO;

public interface GenericService<T, ID> {

    abstract GenericDAO<T, ID> getDAO();

    T getById(Integer id) ;

}