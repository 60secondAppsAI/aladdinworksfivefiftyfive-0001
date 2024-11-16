package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.CapacityAnalysis;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisDTO;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisSearchDTO;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisPageDTO;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CapacityAnalysisService extends GenericService<CapacityAnalysis, Integer> {

	List<CapacityAnalysis> findAll();

	ResultDTO addCapacityAnalysis(CapacityAnalysisDTO capacityAnalysisDTO, RequestDTO requestDTO);

	ResultDTO updateCapacityAnalysis(CapacityAnalysisDTO capacityAnalysisDTO, RequestDTO requestDTO);

    Page<CapacityAnalysis> getAllCapacityAnalysiss(Pageable pageable);

    Page<CapacityAnalysis> getAllCapacityAnalysiss(Specification<CapacityAnalysis> spec, Pageable pageable);

	ResponseEntity<CapacityAnalysisPageDTO> getCapacityAnalysiss(CapacityAnalysisSearchDTO capacityAnalysisSearchDTO);
	
	List<CapacityAnalysisDTO> convertCapacityAnalysissToCapacityAnalysisDTOs(List<CapacityAnalysis> capacityAnalysiss, CapacityAnalysisConvertCriteriaDTO convertCriteria);

	CapacityAnalysisDTO getCapacityAnalysisDTOById(Integer capacityAnalysisId);







}





