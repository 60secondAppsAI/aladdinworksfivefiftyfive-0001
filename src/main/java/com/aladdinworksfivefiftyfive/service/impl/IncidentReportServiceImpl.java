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
import com.aladdinworksfivefiftyfive.dao.IncidentReportDAO;
import com.aladdinworksfivefiftyfive.domain.IncidentReport;
import com.aladdinworksfivefiftyfive.dto.IncidentReportDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentReportSearchDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentReportPageDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentReportConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import com.aladdinworksfivefiftyfive.service.IncidentReportService;
import com.aladdinworksfivefiftyfive.util.ControllerUtils;





@Service
public class IncidentReportServiceImpl extends GenericServiceImpl<IncidentReport, Integer> implements IncidentReportService {

    private final static Logger logger = LoggerFactory.getLogger(IncidentReportServiceImpl.class);

	@Autowired
	IncidentReportDAO incidentReportDao;

	


	@Override
	public GenericDAO<IncidentReport, Integer> getDAO() {
		return (GenericDAO<IncidentReport, Integer>) incidentReportDao;
	}
	
	public List<IncidentReport> findAll () {
		List<IncidentReport> incidentReports = incidentReportDao.findAll();
		
		return incidentReports;	
		
	}

	public ResultDTO addIncidentReport(IncidentReportDTO incidentReportDTO, RequestDTO requestDTO) {

		IncidentReport incidentReport = new IncidentReport();

		incidentReport.setIncidentReportId(incidentReportDTO.getIncidentReportId());


		incidentReport.setReportContent(incidentReportDTO.getReportContent());


		incidentReport.setReportDate(incidentReportDTO.getReportDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		incidentReport = incidentReportDao.save(incidentReport);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<IncidentReport> getAllIncidentReports(Pageable pageable) {
		return incidentReportDao.findAll(pageable);
	}

	public Page<IncidentReport> getAllIncidentReports(Specification<IncidentReport> spec, Pageable pageable) {
		return incidentReportDao.findAll(spec, pageable);
	}

	public ResponseEntity<IncidentReportPageDTO> getIncidentReports(IncidentReportSearchDTO incidentReportSearchDTO) {
	
			Integer incidentReportId = incidentReportSearchDTO.getIncidentReportId(); 
 			String reportContent = incidentReportSearchDTO.getReportContent(); 
   			String sortBy = incidentReportSearchDTO.getSortBy();
			String sortOrder = incidentReportSearchDTO.getSortOrder();
			String searchQuery = incidentReportSearchDTO.getSearchQuery();
			Integer page = incidentReportSearchDTO.getPage();
			Integer size = incidentReportSearchDTO.getSize();

	        Specification<IncidentReport> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, incidentReportId, "incidentReportId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, reportContent, "reportContent"); 
			
 			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("reportContent")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<IncidentReport> incidentReports = this.getAllIncidentReports(spec, pageable);
		
		//System.out.println(String.valueOf(incidentReports.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(incidentReports.getTotalPages()));
		
		List<IncidentReport> incidentReportsList = incidentReports.getContent();
		
		IncidentReportConvertCriteriaDTO convertCriteria = new IncidentReportConvertCriteriaDTO();
		List<IncidentReportDTO> incidentReportDTOs = this.convertIncidentReportsToIncidentReportDTOs(incidentReportsList,convertCriteria);
		
		IncidentReportPageDTO incidentReportPageDTO = new IncidentReportPageDTO();
		incidentReportPageDTO.setIncidentReports(incidentReportDTOs);
		incidentReportPageDTO.setTotalElements(incidentReports.getTotalElements());
		return ResponseEntity.ok(incidentReportPageDTO);
	}

	public List<IncidentReportDTO> convertIncidentReportsToIncidentReportDTOs(List<IncidentReport> incidentReports, IncidentReportConvertCriteriaDTO convertCriteria) {
		
		List<IncidentReportDTO> incidentReportDTOs = new ArrayList<IncidentReportDTO>();
		
		for (IncidentReport incidentReport : incidentReports) {
			incidentReportDTOs.add(convertIncidentReportToIncidentReportDTO(incidentReport,convertCriteria));
		}
		
		return incidentReportDTOs;

	}
	
	public IncidentReportDTO convertIncidentReportToIncidentReportDTO(IncidentReport incidentReport, IncidentReportConvertCriteriaDTO convertCriteria) {
		
		IncidentReportDTO incidentReportDTO = new IncidentReportDTO();
		
		incidentReportDTO.setIncidentReportId(incidentReport.getIncidentReportId());

	
		incidentReportDTO.setReportContent(incidentReport.getReportContent());

	
		incidentReportDTO.setReportDate(incidentReport.getReportDate());

	

		
		return incidentReportDTO;
	}

	public ResultDTO updateIncidentReport(IncidentReportDTO incidentReportDTO, RequestDTO requestDTO) {
		
		IncidentReport incidentReport = incidentReportDao.getById(incidentReportDTO.getIncidentReportId());

		incidentReport.setIncidentReportId(ControllerUtils.setValue(incidentReport.getIncidentReportId(), incidentReportDTO.getIncidentReportId()));

		incidentReport.setReportContent(ControllerUtils.setValue(incidentReport.getReportContent(), incidentReportDTO.getReportContent()));

		incidentReport.setReportDate(ControllerUtils.setValue(incidentReport.getReportDate(), incidentReportDTO.getReportDate()));



        incidentReport = incidentReportDao.save(incidentReport);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public IncidentReportDTO getIncidentReportDTOById(Integer incidentReportId) {
	
		IncidentReport incidentReport = incidentReportDao.getById(incidentReportId);
			
		
		IncidentReportConvertCriteriaDTO convertCriteria = new IncidentReportConvertCriteriaDTO();
		return(this.convertIncidentReportToIncidentReportDTO(incidentReport,convertCriteria));
	}







}
