package com.aladdinworksfivefiftyfive.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.service.impl.GenericServiceImpl;
import com.aladdinworksfivefiftyfive.dao.EnvironmentalMetricDAO;
import com.aladdinworksfivefiftyfive.domain.EnvironmentalMetric;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricDTO;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricSearchDTO;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricPageDTO;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import com.aladdinworksfivefiftyfive.service.EnvironmentalMetricService;
import com.aladdinworksfivefiftyfive.util.ControllerUtils;





@Service
public class EnvironmentalMetricServiceImpl extends GenericServiceImpl<EnvironmentalMetric, Integer> implements EnvironmentalMetricService {

    private final static Logger logger = LoggerFactory.getLogger(EnvironmentalMetricServiceImpl.class);

	@Autowired
	EnvironmentalMetricDAO environmentalMetricDao;

	


	@Override
	public GenericDAO<EnvironmentalMetric, Integer> getDAO() {
		return (GenericDAO<EnvironmentalMetric, Integer>) environmentalMetricDao;
	}
	
	public List<EnvironmentalMetric> findAll () {
		List<EnvironmentalMetric> environmentalMetrics = environmentalMetricDao.findAll();
		
		return environmentalMetrics;	
		
	}

	public ResultDTO addEnvironmentalMetric(EnvironmentalMetricDTO environmentalMetricDTO, RequestDTO requestDTO) {

		EnvironmentalMetric environmentalMetric = new EnvironmentalMetric();

		environmentalMetric.setEnvironmentalMetricId(environmentalMetricDTO.getEnvironmentalMetricId());


		environmentalMetric.setCarbonFootprint(environmentalMetricDTO.getCarbonFootprint());


		environmentalMetric.setWaterUsage(environmentalMetricDTO.getWaterUsage());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		environmentalMetric = environmentalMetricDao.save(environmentalMetric);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<EnvironmentalMetric> getAllEnvironmentalMetrics(Pageable pageable) {
		return environmentalMetricDao.findAll(pageable);
	}

	public Page<EnvironmentalMetric> getAllEnvironmentalMetrics(Specification<EnvironmentalMetric> spec, Pageable pageable) {
		return environmentalMetricDao.findAll(spec, pageable);
	}

	public ResponseEntity<EnvironmentalMetricPageDTO> getEnvironmentalMetrics(EnvironmentalMetricSearchDTO environmentalMetricSearchDTO) {
	
			Integer environmentalMetricId = environmentalMetricSearchDTO.getEnvironmentalMetricId(); 
   			String sortBy = environmentalMetricSearchDTO.getSortBy();
			String sortOrder = environmentalMetricSearchDTO.getSortOrder();
			String searchQuery = environmentalMetricSearchDTO.getSearchQuery();
			Integer page = environmentalMetricSearchDTO.getPage();
			Integer size = environmentalMetricSearchDTO.getSize();

	        Specification<EnvironmentalMetric> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, environmentalMetricId, "environmentalMetricId"); 
			
			
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<EnvironmentalMetric> environmentalMetrics = this.getAllEnvironmentalMetrics(spec, pageable);
		
		//System.out.println(String.valueOf(environmentalMetrics.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(environmentalMetrics.getTotalPages()));
		
		List<EnvironmentalMetric> environmentalMetricsList = environmentalMetrics.getContent();
		
		EnvironmentalMetricConvertCriteriaDTO convertCriteria = new EnvironmentalMetricConvertCriteriaDTO();
		List<EnvironmentalMetricDTO> environmentalMetricDTOs = this.convertEnvironmentalMetricsToEnvironmentalMetricDTOs(environmentalMetricsList,convertCriteria);
		
		EnvironmentalMetricPageDTO environmentalMetricPageDTO = new EnvironmentalMetricPageDTO();
		environmentalMetricPageDTO.setEnvironmentalMetrics(environmentalMetricDTOs);
		environmentalMetricPageDTO.setTotalElements(environmentalMetrics.getTotalElements());
		return ResponseEntity.ok(environmentalMetricPageDTO);
	}

	public List<EnvironmentalMetricDTO> convertEnvironmentalMetricsToEnvironmentalMetricDTOs(List<EnvironmentalMetric> environmentalMetrics, EnvironmentalMetricConvertCriteriaDTO convertCriteria) {
		
		List<EnvironmentalMetricDTO> environmentalMetricDTOs = new ArrayList<EnvironmentalMetricDTO>();
		
		for (EnvironmentalMetric environmentalMetric : environmentalMetrics) {
			environmentalMetricDTOs.add(convertEnvironmentalMetricToEnvironmentalMetricDTO(environmentalMetric,convertCriteria));
		}
		
		return environmentalMetricDTOs;

	}
	
	public EnvironmentalMetricDTO convertEnvironmentalMetricToEnvironmentalMetricDTO(EnvironmentalMetric environmentalMetric, EnvironmentalMetricConvertCriteriaDTO convertCriteria) {
		
		EnvironmentalMetricDTO environmentalMetricDTO = new EnvironmentalMetricDTO();
		
		environmentalMetricDTO.setEnvironmentalMetricId(environmentalMetric.getEnvironmentalMetricId());

	
		environmentalMetricDTO.setCarbonFootprint(environmentalMetric.getCarbonFootprint());

	
		environmentalMetricDTO.setWaterUsage(environmentalMetric.getWaterUsage());

	

		
		return environmentalMetricDTO;
	}

	public ResultDTO updateEnvironmentalMetric(EnvironmentalMetricDTO environmentalMetricDTO, RequestDTO requestDTO) {
		
		EnvironmentalMetric environmentalMetric = environmentalMetricDao.getById(environmentalMetricDTO.getEnvironmentalMetricId());

		environmentalMetric.setEnvironmentalMetricId(ControllerUtils.setValue(environmentalMetric.getEnvironmentalMetricId(), environmentalMetricDTO.getEnvironmentalMetricId()));

		environmentalMetric.setCarbonFootprint(ControllerUtils.setValue(environmentalMetric.getCarbonFootprint(), environmentalMetricDTO.getCarbonFootprint()));

		environmentalMetric.setWaterUsage(ControllerUtils.setValue(environmentalMetric.getWaterUsage(), environmentalMetricDTO.getWaterUsage()));



        environmentalMetric = environmentalMetricDao.save(environmentalMetric);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public EnvironmentalMetricDTO getEnvironmentalMetricDTOById(Integer environmentalMetricId) {
	
		EnvironmentalMetric environmentalMetric = environmentalMetricDao.getById(environmentalMetricId);
			
		
		EnvironmentalMetricConvertCriteriaDTO convertCriteria = new EnvironmentalMetricConvertCriteriaDTO();
		return(this.convertEnvironmentalMetricToEnvironmentalMetricDTO(environmentalMetric,convertCriteria));
	}







}
