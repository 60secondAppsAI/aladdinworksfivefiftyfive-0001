package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.MaintenanceRecord;
import com.aladdinworksfivefiftyfive.dto.MaintenanceRecordDTO;
import com.aladdinworksfivefiftyfive.dto.MaintenanceRecordSearchDTO;
import com.aladdinworksfivefiftyfive.dto.MaintenanceRecordPageDTO;
import com.aladdinworksfivefiftyfive.dto.MaintenanceRecordConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface MaintenanceRecordService extends GenericService<MaintenanceRecord, Integer> {

	List<MaintenanceRecord> findAll();

	ResultDTO addMaintenanceRecord(MaintenanceRecordDTO maintenanceRecordDTO, RequestDTO requestDTO);

	ResultDTO updateMaintenanceRecord(MaintenanceRecordDTO maintenanceRecordDTO, RequestDTO requestDTO);

    Page<MaintenanceRecord> getAllMaintenanceRecords(Pageable pageable);

    Page<MaintenanceRecord> getAllMaintenanceRecords(Specification<MaintenanceRecord> spec, Pageable pageable);

	ResponseEntity<MaintenanceRecordPageDTO> getMaintenanceRecords(MaintenanceRecordSearchDTO maintenanceRecordSearchDTO);
	
	List<MaintenanceRecordDTO> convertMaintenanceRecordsToMaintenanceRecordDTOs(List<MaintenanceRecord> maintenanceRecords, MaintenanceRecordConvertCriteriaDTO convertCriteria);

	MaintenanceRecordDTO getMaintenanceRecordDTOById(Integer maintenanceRecordId);







}





