package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.LightSwitch;
import com.aladdinworksfivefiftyfive.dto.LightSwitchDTO;
import com.aladdinworksfivefiftyfive.dto.LightSwitchSearchDTO;
import com.aladdinworksfivefiftyfive.dto.LightSwitchPageDTO;
import com.aladdinworksfivefiftyfive.dto.LightSwitchConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface LightSwitchService extends GenericService<LightSwitch, Integer> {

	List<LightSwitch> findAll();

	ResultDTO addLightSwitch(LightSwitchDTO lightSwitchDTO, RequestDTO requestDTO);

	ResultDTO updateLightSwitch(LightSwitchDTO lightSwitchDTO, RequestDTO requestDTO);

    Page<LightSwitch> getAllLightSwitchs(Pageable pageable);

    Page<LightSwitch> getAllLightSwitchs(Specification<LightSwitch> spec, Pageable pageable);

	ResponseEntity<LightSwitchPageDTO> getLightSwitchs(LightSwitchSearchDTO lightSwitchSearchDTO);
	
	List<LightSwitchDTO> convertLightSwitchsToLightSwitchDTOs(List<LightSwitch> lightSwitchs, LightSwitchConvertCriteriaDTO convertCriteria);

	LightSwitchDTO getLightSwitchDTOById(Integer lightSwitchId);







}





