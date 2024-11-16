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
import com.aladdinworksfivefiftyfive.dao.LightSwitchDAO;
import com.aladdinworksfivefiftyfive.domain.LightSwitch;
import com.aladdinworksfivefiftyfive.dto.LightSwitchDTO;
import com.aladdinworksfivefiftyfive.dto.LightSwitchSearchDTO;
import com.aladdinworksfivefiftyfive.dto.LightSwitchPageDTO;
import com.aladdinworksfivefiftyfive.dto.LightSwitchConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import com.aladdinworksfivefiftyfive.service.LightSwitchService;
import com.aladdinworksfivefiftyfive.util.ControllerUtils;





@Service
public class LightSwitchServiceImpl extends GenericServiceImpl<LightSwitch, Integer> implements LightSwitchService {

    private final static Logger logger = LoggerFactory.getLogger(LightSwitchServiceImpl.class);

	@Autowired
	LightSwitchDAO lightSwitchDao;

	


	@Override
	public GenericDAO<LightSwitch, Integer> getDAO() {
		return (GenericDAO<LightSwitch, Integer>) lightSwitchDao;
	}
	
	public List<LightSwitch> findAll () {
		List<LightSwitch> lightSwitchs = lightSwitchDao.findAll();
		
		return lightSwitchs;	
		
	}

	public ResultDTO addLightSwitch(LightSwitchDTO lightSwitchDTO, RequestDTO requestDTO) {

		LightSwitch lightSwitch = new LightSwitch();

		lightSwitch.setLightSwitchId(lightSwitchDTO.getLightSwitchId());


		lightSwitch.setStatus(lightSwitchDTO.getStatus());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		lightSwitch = lightSwitchDao.save(lightSwitch);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<LightSwitch> getAllLightSwitchs(Pageable pageable) {
		return lightSwitchDao.findAll(pageable);
	}

	public Page<LightSwitch> getAllLightSwitchs(Specification<LightSwitch> spec, Pageable pageable) {
		return lightSwitchDao.findAll(spec, pageable);
	}

	public ResponseEntity<LightSwitchPageDTO> getLightSwitchs(LightSwitchSearchDTO lightSwitchSearchDTO) {
	
			Integer lightSwitchId = lightSwitchSearchDTO.getLightSwitchId(); 
 			String status = lightSwitchSearchDTO.getStatus(); 
 			String sortBy = lightSwitchSearchDTO.getSortBy();
			String sortOrder = lightSwitchSearchDTO.getSortOrder();
			String searchQuery = lightSwitchSearchDTO.getSearchQuery();
			Integer page = lightSwitchSearchDTO.getPage();
			Integer size = lightSwitchSearchDTO.getSize();

	        Specification<LightSwitch> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, lightSwitchId, "lightSwitchId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, status, "status"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("status")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<LightSwitch> lightSwitchs = this.getAllLightSwitchs(spec, pageable);
		
		//System.out.println(String.valueOf(lightSwitchs.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(lightSwitchs.getTotalPages()));
		
		List<LightSwitch> lightSwitchsList = lightSwitchs.getContent();
		
		LightSwitchConvertCriteriaDTO convertCriteria = new LightSwitchConvertCriteriaDTO();
		List<LightSwitchDTO> lightSwitchDTOs = this.convertLightSwitchsToLightSwitchDTOs(lightSwitchsList,convertCriteria);
		
		LightSwitchPageDTO lightSwitchPageDTO = new LightSwitchPageDTO();
		lightSwitchPageDTO.setLightSwitchs(lightSwitchDTOs);
		lightSwitchPageDTO.setTotalElements(lightSwitchs.getTotalElements());
		return ResponseEntity.ok(lightSwitchPageDTO);
	}

	public List<LightSwitchDTO> convertLightSwitchsToLightSwitchDTOs(List<LightSwitch> lightSwitchs, LightSwitchConvertCriteriaDTO convertCriteria) {
		
		List<LightSwitchDTO> lightSwitchDTOs = new ArrayList<LightSwitchDTO>();
		
		for (LightSwitch lightSwitch : lightSwitchs) {
			lightSwitchDTOs.add(convertLightSwitchToLightSwitchDTO(lightSwitch,convertCriteria));
		}
		
		return lightSwitchDTOs;

	}
	
	public LightSwitchDTO convertLightSwitchToLightSwitchDTO(LightSwitch lightSwitch, LightSwitchConvertCriteriaDTO convertCriteria) {
		
		LightSwitchDTO lightSwitchDTO = new LightSwitchDTO();
		
		lightSwitchDTO.setLightSwitchId(lightSwitch.getLightSwitchId());

	
		lightSwitchDTO.setStatus(lightSwitch.getStatus());

	

		
		return lightSwitchDTO;
	}

	public ResultDTO updateLightSwitch(LightSwitchDTO lightSwitchDTO, RequestDTO requestDTO) {
		
		LightSwitch lightSwitch = lightSwitchDao.getById(lightSwitchDTO.getLightSwitchId());

		lightSwitch.setLightSwitchId(ControllerUtils.setValue(lightSwitch.getLightSwitchId(), lightSwitchDTO.getLightSwitchId()));

		lightSwitch.setStatus(ControllerUtils.setValue(lightSwitch.getStatus(), lightSwitchDTO.getStatus()));



        lightSwitch = lightSwitchDao.save(lightSwitch);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public LightSwitchDTO getLightSwitchDTOById(Integer lightSwitchId) {
	
		LightSwitch lightSwitch = lightSwitchDao.getById(lightSwitchId);
			
		
		LightSwitchConvertCriteriaDTO convertCriteria = new LightSwitchConvertCriteriaDTO();
		return(this.convertLightSwitchToLightSwitchDTO(lightSwitch,convertCriteria));
	}







}
