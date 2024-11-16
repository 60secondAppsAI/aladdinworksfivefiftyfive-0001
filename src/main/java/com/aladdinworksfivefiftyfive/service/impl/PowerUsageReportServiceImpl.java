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
import com.aladdinworksfivefiftyfive.dao.PowerUsageReportDAO;
import com.aladdinworksfivefiftyfive.domain.PowerUsageReport;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportDTO;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportSearchDTO;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportPageDTO;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import com.aladdinworksfivefiftyfive.service.PowerUsageReportService;
import com.aladdinworksfivefiftyfive.util.ControllerUtils;





@Service
public class PowerUsageReportServiceImpl extends GenericServiceImpl<PowerUsageReport, Integer> implements PowerUsageReportService {

    private final static Logger logger = LoggerFactory.getLogger(PowerUsageReportServiceImpl.class);

	@Autowired
	PowerUsageReportDAO powerUsageReportDao;

	


	@Override
	public GenericDAO<PowerUsageReport, Integer> getDAO() {
		return (GenericDAO<PowerUsageReport, Integer>) powerUsageReportDao;
	}
	
	public List<PowerUsageReport> findAll () {
		List<PowerUsageReport> powerUsageReports = powerUsageReportDao.findAll();
		
		return powerUsageReports;	
		
	}

	public ResultDTO addPowerUsageReport(PowerUsageReportDTO powerUsageReportDTO, RequestDTO requestDTO) {

		PowerUsageReport powerUsageReport = new PowerUsageReport();

		powerUsageReport.setPowerUsageReportId(powerUsageReportDTO.getPowerUsageReportId());


		powerUsageReport.setTotalPowerUsage(powerUsageReportDTO.getTotalPowerUsage());


		powerUsageReport.setReportDate(powerUsageReportDTO.getReportDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		powerUsageReport = powerUsageReportDao.save(powerUsageReport);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<PowerUsageReport> getAllPowerUsageReports(Pageable pageable) {
		return powerUsageReportDao.findAll(pageable);
	}

	public Page<PowerUsageReport> getAllPowerUsageReports(Specification<PowerUsageReport> spec, Pageable pageable) {
		return powerUsageReportDao.findAll(spec, pageable);
	}

	public ResponseEntity<PowerUsageReportPageDTO> getPowerUsageReports(PowerUsageReportSearchDTO powerUsageReportSearchDTO) {
	
			Integer powerUsageReportId = powerUsageReportSearchDTO.getPowerUsageReportId(); 
    			String sortBy = powerUsageReportSearchDTO.getSortBy();
			String sortOrder = powerUsageReportSearchDTO.getSortOrder();
			String searchQuery = powerUsageReportSearchDTO.getSearchQuery();
			Integer page = powerUsageReportSearchDTO.getPage();
			Integer size = powerUsageReportSearchDTO.getSize();

	        Specification<PowerUsageReport> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, powerUsageReportId, "powerUsageReportId"); 
			
			
 			

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

		Page<PowerUsageReport> powerUsageReports = this.getAllPowerUsageReports(spec, pageable);
		
		//System.out.println(String.valueOf(powerUsageReports.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(powerUsageReports.getTotalPages()));
		
		List<PowerUsageReport> powerUsageReportsList = powerUsageReports.getContent();
		
		PowerUsageReportConvertCriteriaDTO convertCriteria = new PowerUsageReportConvertCriteriaDTO();
		List<PowerUsageReportDTO> powerUsageReportDTOs = this.convertPowerUsageReportsToPowerUsageReportDTOs(powerUsageReportsList,convertCriteria);
		
		PowerUsageReportPageDTO powerUsageReportPageDTO = new PowerUsageReportPageDTO();
		powerUsageReportPageDTO.setPowerUsageReports(powerUsageReportDTOs);
		powerUsageReportPageDTO.setTotalElements(powerUsageReports.getTotalElements());
		return ResponseEntity.ok(powerUsageReportPageDTO);
	}

	public List<PowerUsageReportDTO> convertPowerUsageReportsToPowerUsageReportDTOs(List<PowerUsageReport> powerUsageReports, PowerUsageReportConvertCriteriaDTO convertCriteria) {
		
		List<PowerUsageReportDTO> powerUsageReportDTOs = new ArrayList<PowerUsageReportDTO>();
		
		for (PowerUsageReport powerUsageReport : powerUsageReports) {
			powerUsageReportDTOs.add(convertPowerUsageReportToPowerUsageReportDTO(powerUsageReport,convertCriteria));
		}
		
		return powerUsageReportDTOs;

	}
	
	public PowerUsageReportDTO convertPowerUsageReportToPowerUsageReportDTO(PowerUsageReport powerUsageReport, PowerUsageReportConvertCriteriaDTO convertCriteria) {
		
		PowerUsageReportDTO powerUsageReportDTO = new PowerUsageReportDTO();
		
		powerUsageReportDTO.setPowerUsageReportId(powerUsageReport.getPowerUsageReportId());

	
		powerUsageReportDTO.setTotalPowerUsage(powerUsageReport.getTotalPowerUsage());

	
		powerUsageReportDTO.setReportDate(powerUsageReport.getReportDate());

	

		
		return powerUsageReportDTO;
	}

	public ResultDTO updatePowerUsageReport(PowerUsageReportDTO powerUsageReportDTO, RequestDTO requestDTO) {
		
		PowerUsageReport powerUsageReport = powerUsageReportDao.getById(powerUsageReportDTO.getPowerUsageReportId());

		powerUsageReport.setPowerUsageReportId(ControllerUtils.setValue(powerUsageReport.getPowerUsageReportId(), powerUsageReportDTO.getPowerUsageReportId()));

		powerUsageReport.setTotalPowerUsage(ControllerUtils.setValue(powerUsageReport.getTotalPowerUsage(), powerUsageReportDTO.getTotalPowerUsage()));

		powerUsageReport.setReportDate(ControllerUtils.setValue(powerUsageReport.getReportDate(), powerUsageReportDTO.getReportDate()));



        powerUsageReport = powerUsageReportDao.save(powerUsageReport);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public PowerUsageReportDTO getPowerUsageReportDTOById(Integer powerUsageReportId) {
	
		PowerUsageReport powerUsageReport = powerUsageReportDao.getById(powerUsageReportId);
			
		
		PowerUsageReportConvertCriteriaDTO convertCriteria = new PowerUsageReportConvertCriteriaDTO();
		return(this.convertPowerUsageReportToPowerUsageReportDTO(powerUsageReport,convertCriteria));
	}







}
