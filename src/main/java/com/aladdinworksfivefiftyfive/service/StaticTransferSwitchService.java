package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.StaticTransferSwitch;
import com.aladdinworksfivefiftyfive.dto.StaticTransferSwitchDTO;
import com.aladdinworksfivefiftyfive.dto.StaticTransferSwitchSearchDTO;
import com.aladdinworksfivefiftyfive.dto.StaticTransferSwitchPageDTO;
import com.aladdinworksfivefiftyfive.dto.StaticTransferSwitchConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface StaticTransferSwitchService extends GenericService<StaticTransferSwitch, Integer> {

	List<StaticTransferSwitch> findAll();

	ResultDTO addStaticTransferSwitch(StaticTransferSwitchDTO staticTransferSwitchDTO, RequestDTO requestDTO);

	ResultDTO updateStaticTransferSwitch(StaticTransferSwitchDTO staticTransferSwitchDTO, RequestDTO requestDTO);

    Page<StaticTransferSwitch> getAllStaticTransferSwitchs(Pageable pageable);

    Page<StaticTransferSwitch> getAllStaticTransferSwitchs(Specification<StaticTransferSwitch> spec, Pageable pageable);

	ResponseEntity<StaticTransferSwitchPageDTO> getStaticTransferSwitchs(StaticTransferSwitchSearchDTO staticTransferSwitchSearchDTO);
	
	List<StaticTransferSwitchDTO> convertStaticTransferSwitchsToStaticTransferSwitchDTOs(List<StaticTransferSwitch> staticTransferSwitchs, StaticTransferSwitchConvertCriteriaDTO convertCriteria);

	StaticTransferSwitchDTO getStaticTransferSwitchDTOById(Integer staticTransferSwitchId);







}





