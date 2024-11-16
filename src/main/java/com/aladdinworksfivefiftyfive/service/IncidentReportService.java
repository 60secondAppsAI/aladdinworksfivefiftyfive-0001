package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.IncidentReport;
import com.aladdinworksfivefiftyfive.dto.IncidentReportDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentReportSearchDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentReportPageDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentReportConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface IncidentReportService extends GenericService<IncidentReport, Integer> {

	List<IncidentReport> findAll();

	ResultDTO addIncidentReport(IncidentReportDTO incidentReportDTO, RequestDTO requestDTO);

	ResultDTO updateIncidentReport(IncidentReportDTO incidentReportDTO, RequestDTO requestDTO);

    Page<IncidentReport> getAllIncidentReports(Pageable pageable);

    Page<IncidentReport> getAllIncidentReports(Specification<IncidentReport> spec, Pageable pageable);

	ResponseEntity<IncidentReportPageDTO> getIncidentReports(IncidentReportSearchDTO incidentReportSearchDTO);
	
	List<IncidentReportDTO> convertIncidentReportsToIncidentReportDTOs(List<IncidentReport> incidentReports, IncidentReportConvertCriteriaDTO convertCriteria);

	IncidentReportDTO getIncidentReportDTOById(Integer incidentReportId);







}





