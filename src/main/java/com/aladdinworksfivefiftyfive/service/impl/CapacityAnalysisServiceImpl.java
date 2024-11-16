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
import com.aladdinworksfivefiftyfive.dao.CapacityAnalysisDAO;
import com.aladdinworksfivefiftyfive.domain.CapacityAnalysis;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisDTO;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisSearchDTO;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisPageDTO;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import com.aladdinworksfivefiftyfive.service.CapacityAnalysisService;
import com.aladdinworksfivefiftyfive.util.ControllerUtils;





@Service
public class CapacityAnalysisServiceImpl extends GenericServiceImpl<CapacityAnalysis, Integer> implements CapacityAnalysisService {

    private final static Logger logger = LoggerFactory.getLogger(CapacityAnalysisServiceImpl.class);

	@Autowired
	CapacityAnalysisDAO capacityAnalysisDao;

	


	@Override
	public GenericDAO<CapacityAnalysis, Integer> getDAO() {
		return (GenericDAO<CapacityAnalysis, Integer>) capacityAnalysisDao;
	}
	
	public List<CapacityAnalysis> findAll () {
		List<CapacityAnalysis> capacityAnalysiss = capacityAnalysisDao.findAll();
		
		return capacityAnalysiss;	
		
	}

	public ResultDTO addCapacityAnalysis(CapacityAnalysisDTO capacityAnalysisDTO, RequestDTO requestDTO) {

		CapacityAnalysis capacityAnalysis = new CapacityAnalysis();

		capacityAnalysis.setCapacityAnalysisId(capacityAnalysisDTO.getCapacityAnalysisId());


		capacityAnalysis.setTotalCapacity(capacityAnalysisDTO.getTotalCapacity());


		capacityAnalysis.setUsedCapacity(capacityAnalysisDTO.getUsedCapacity());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		capacityAnalysis = capacityAnalysisDao.save(capacityAnalysis);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<CapacityAnalysis> getAllCapacityAnalysiss(Pageable pageable) {
		return capacityAnalysisDao.findAll(pageable);
	}

	public Page<CapacityAnalysis> getAllCapacityAnalysiss(Specification<CapacityAnalysis> spec, Pageable pageable) {
		return capacityAnalysisDao.findAll(spec, pageable);
	}

	public ResponseEntity<CapacityAnalysisPageDTO> getCapacityAnalysiss(CapacityAnalysisSearchDTO capacityAnalysisSearchDTO) {
	
			Integer capacityAnalysisId = capacityAnalysisSearchDTO.getCapacityAnalysisId(); 
   			String sortBy = capacityAnalysisSearchDTO.getSortBy();
			String sortOrder = capacityAnalysisSearchDTO.getSortOrder();
			String searchQuery = capacityAnalysisSearchDTO.getSearchQuery();
			Integer page = capacityAnalysisSearchDTO.getPage();
			Integer size = capacityAnalysisSearchDTO.getSize();

	        Specification<CapacityAnalysis> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, capacityAnalysisId, "capacityAnalysisId"); 
			
			
			

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

		Page<CapacityAnalysis> capacityAnalysiss = this.getAllCapacityAnalysiss(spec, pageable);
		
		//System.out.println(String.valueOf(capacityAnalysiss.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(capacityAnalysiss.getTotalPages()));
		
		List<CapacityAnalysis> capacityAnalysissList = capacityAnalysiss.getContent();
		
		CapacityAnalysisConvertCriteriaDTO convertCriteria = new CapacityAnalysisConvertCriteriaDTO();
		List<CapacityAnalysisDTO> capacityAnalysisDTOs = this.convertCapacityAnalysissToCapacityAnalysisDTOs(capacityAnalysissList,convertCriteria);
		
		CapacityAnalysisPageDTO capacityAnalysisPageDTO = new CapacityAnalysisPageDTO();
		capacityAnalysisPageDTO.setCapacityAnalysiss(capacityAnalysisDTOs);
		capacityAnalysisPageDTO.setTotalElements(capacityAnalysiss.getTotalElements());
		return ResponseEntity.ok(capacityAnalysisPageDTO);
	}

	public List<CapacityAnalysisDTO> convertCapacityAnalysissToCapacityAnalysisDTOs(List<CapacityAnalysis> capacityAnalysiss, CapacityAnalysisConvertCriteriaDTO convertCriteria) {
		
		List<CapacityAnalysisDTO> capacityAnalysisDTOs = new ArrayList<CapacityAnalysisDTO>();
		
		for (CapacityAnalysis capacityAnalysis : capacityAnalysiss) {
			capacityAnalysisDTOs.add(convertCapacityAnalysisToCapacityAnalysisDTO(capacityAnalysis,convertCriteria));
		}
		
		return capacityAnalysisDTOs;

	}
	
	public CapacityAnalysisDTO convertCapacityAnalysisToCapacityAnalysisDTO(CapacityAnalysis capacityAnalysis, CapacityAnalysisConvertCriteriaDTO convertCriteria) {
		
		CapacityAnalysisDTO capacityAnalysisDTO = new CapacityAnalysisDTO();
		
		capacityAnalysisDTO.setCapacityAnalysisId(capacityAnalysis.getCapacityAnalysisId());

	
		capacityAnalysisDTO.setTotalCapacity(capacityAnalysis.getTotalCapacity());

	
		capacityAnalysisDTO.setUsedCapacity(capacityAnalysis.getUsedCapacity());

	

		
		return capacityAnalysisDTO;
	}

	public ResultDTO updateCapacityAnalysis(CapacityAnalysisDTO capacityAnalysisDTO, RequestDTO requestDTO) {
		
		CapacityAnalysis capacityAnalysis = capacityAnalysisDao.getById(capacityAnalysisDTO.getCapacityAnalysisId());

		capacityAnalysis.setCapacityAnalysisId(ControllerUtils.setValue(capacityAnalysis.getCapacityAnalysisId(), capacityAnalysisDTO.getCapacityAnalysisId()));

		capacityAnalysis.setTotalCapacity(ControllerUtils.setValue(capacityAnalysis.getTotalCapacity(), capacityAnalysisDTO.getTotalCapacity()));

		capacityAnalysis.setUsedCapacity(ControllerUtils.setValue(capacityAnalysis.getUsedCapacity(), capacityAnalysisDTO.getUsedCapacity()));



        capacityAnalysis = capacityAnalysisDao.save(capacityAnalysis);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public CapacityAnalysisDTO getCapacityAnalysisDTOById(Integer capacityAnalysisId) {
	
		CapacityAnalysis capacityAnalysis = capacityAnalysisDao.getById(capacityAnalysisId);
			
		
		CapacityAnalysisConvertCriteriaDTO convertCriteria = new CapacityAnalysisConvertCriteriaDTO();
		return(this.convertCapacityAnalysisToCapacityAnalysisDTO(capacityAnalysis,convertCriteria));
	}







}
