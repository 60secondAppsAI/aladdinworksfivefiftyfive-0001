package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.CurrentSensor;
import com.aladdinworksfivefiftyfive.dto.CurrentSensorDTO;
import com.aladdinworksfivefiftyfive.dto.CurrentSensorSearchDTO;
import com.aladdinworksfivefiftyfive.dto.CurrentSensorPageDTO;
import com.aladdinworksfivefiftyfive.dto.CurrentSensorConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CurrentSensorService extends GenericService<CurrentSensor, Integer> {

	List<CurrentSensor> findAll();

	ResultDTO addCurrentSensor(CurrentSensorDTO currentSensorDTO, RequestDTO requestDTO);

	ResultDTO updateCurrentSensor(CurrentSensorDTO currentSensorDTO, RequestDTO requestDTO);

    Page<CurrentSensor> getAllCurrentSensors(Pageable pageable);

    Page<CurrentSensor> getAllCurrentSensors(Specification<CurrentSensor> spec, Pageable pageable);

	ResponseEntity<CurrentSensorPageDTO> getCurrentSensors(CurrentSensorSearchDTO currentSensorSearchDTO);
	
	List<CurrentSensorDTO> convertCurrentSensorsToCurrentSensorDTOs(List<CurrentSensor> currentSensors, CurrentSensorConvertCriteriaDTO convertCriteria);

	CurrentSensorDTO getCurrentSensorDTOById(Integer currentSensorId);







}





