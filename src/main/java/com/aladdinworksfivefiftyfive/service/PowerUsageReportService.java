package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.PowerUsageReport;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportDTO;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportSearchDTO;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportPageDTO;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface PowerUsageReportService extends GenericService<PowerUsageReport, Integer> {

	List<PowerUsageReport> findAll();

	ResultDTO addPowerUsageReport(PowerUsageReportDTO powerUsageReportDTO, RequestDTO requestDTO);

	ResultDTO updatePowerUsageReport(PowerUsageReportDTO powerUsageReportDTO, RequestDTO requestDTO);

    Page<PowerUsageReport> getAllPowerUsageReports(Pageable pageable);

    Page<PowerUsageReport> getAllPowerUsageReports(Specification<PowerUsageReport> spec, Pageable pageable);

	ResponseEntity<PowerUsageReportPageDTO> getPowerUsageReports(PowerUsageReportSearchDTO powerUsageReportSearchDTO);
	
	List<PowerUsageReportDTO> convertPowerUsageReportsToPowerUsageReportDTOs(List<PowerUsageReport> powerUsageReports, PowerUsageReportConvertCriteriaDTO convertCriteria);

	PowerUsageReportDTO getPowerUsageReportDTOById(Integer powerUsageReportId);







}





