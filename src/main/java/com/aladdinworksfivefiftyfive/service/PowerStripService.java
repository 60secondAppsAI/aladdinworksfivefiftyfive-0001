package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.PowerStrip;
import com.aladdinworksfivefiftyfive.dto.PowerStripDTO;
import com.aladdinworksfivefiftyfive.dto.PowerStripSearchDTO;
import com.aladdinworksfivefiftyfive.dto.PowerStripPageDTO;
import com.aladdinworksfivefiftyfive.dto.PowerStripConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PowerStripService extends GenericService<PowerStrip, Integer> {

	List<PowerStrip> findAll();

	ResultDTO addPowerStrip(PowerStripDTO powerStripDTO, RequestDTO requestDTO);

	ResultDTO updatePowerStrip(PowerStripDTO powerStripDTO, RequestDTO requestDTO);

    Page<PowerStrip> getAllPowerStrips(Pageable pageable);

    Page<PowerStrip> getAllPowerStrips(Specification<PowerStrip> spec, Pageable pageable);

	ResponseEntity<PowerStripPageDTO> getPowerStrips(PowerStripSearchDTO powerStripSearchDTO);
	
	List<PowerStripDTO> convertPowerStripsToPowerStripDTOs(List<PowerStrip> powerStrips, PowerStripConvertCriteriaDTO convertCriteria);

	PowerStripDTO getPowerStripDTOById(Integer powerStripId);







}





