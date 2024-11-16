package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.CoolingUnit;
import com.aladdinworksfivefiftyfive.dto.CoolingUnitDTO;
import com.aladdinworksfivefiftyfive.dto.CoolingUnitSearchDTO;
import com.aladdinworksfivefiftyfive.dto.CoolingUnitPageDTO;
import com.aladdinworksfivefiftyfive.dto.CoolingUnitConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CoolingUnitService extends GenericService<CoolingUnit, Integer> {

	List<CoolingUnit> findAll();

	ResultDTO addCoolingUnit(CoolingUnitDTO coolingUnitDTO, RequestDTO requestDTO);

	ResultDTO updateCoolingUnit(CoolingUnitDTO coolingUnitDTO, RequestDTO requestDTO);

    Page<CoolingUnit> getAllCoolingUnits(Pageable pageable);

    Page<CoolingUnit> getAllCoolingUnits(Specification<CoolingUnit> spec, Pageable pageable);

	ResponseEntity<CoolingUnitPageDTO> getCoolingUnits(CoolingUnitSearchDTO coolingUnitSearchDTO);
	
	List<CoolingUnitDTO> convertCoolingUnitsToCoolingUnitDTOs(List<CoolingUnit> coolingUnits, CoolingUnitConvertCriteriaDTO convertCriteria);

	CoolingUnitDTO getCoolingUnitDTOById(Integer coolingUnitId);







}





