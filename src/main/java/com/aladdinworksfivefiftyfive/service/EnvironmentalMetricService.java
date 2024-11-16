package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.EnvironmentalMetric;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricDTO;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricSearchDTO;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricPageDTO;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface EnvironmentalMetricService extends GenericService<EnvironmentalMetric, Integer> {

	List<EnvironmentalMetric> findAll();

	ResultDTO addEnvironmentalMetric(EnvironmentalMetricDTO environmentalMetricDTO, RequestDTO requestDTO);

	ResultDTO updateEnvironmentalMetric(EnvironmentalMetricDTO environmentalMetricDTO, RequestDTO requestDTO);

    Page<EnvironmentalMetric> getAllEnvironmentalMetrics(Pageable pageable);

    Page<EnvironmentalMetric> getAllEnvironmentalMetrics(Specification<EnvironmentalMetric> spec, Pageable pageable);

	ResponseEntity<EnvironmentalMetricPageDTO> getEnvironmentalMetrics(EnvironmentalMetricSearchDTO environmentalMetricSearchDTO);
	
	List<EnvironmentalMetricDTO> convertEnvironmentalMetricsToEnvironmentalMetricDTOs(List<EnvironmentalMetric> environmentalMetrics, EnvironmentalMetricConvertCriteriaDTO convertCriteria);

	EnvironmentalMetricDTO getEnvironmentalMetricDTOById(Integer environmentalMetricId);







}





