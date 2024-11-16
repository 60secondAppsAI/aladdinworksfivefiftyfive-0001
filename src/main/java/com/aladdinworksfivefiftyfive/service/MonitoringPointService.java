package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.MonitoringPoint;
import com.aladdinworksfivefiftyfive.dto.MonitoringPointDTO;
import com.aladdinworksfivefiftyfive.dto.MonitoringPointSearchDTO;
import com.aladdinworksfivefiftyfive.dto.MonitoringPointPageDTO;
import com.aladdinworksfivefiftyfive.dto.MonitoringPointConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface MonitoringPointService extends GenericService<MonitoringPoint, Integer> {

	List<MonitoringPoint> findAll();

	ResultDTO addMonitoringPoint(MonitoringPointDTO monitoringPointDTO, RequestDTO requestDTO);

	ResultDTO updateMonitoringPoint(MonitoringPointDTO monitoringPointDTO, RequestDTO requestDTO);

    Page<MonitoringPoint> getAllMonitoringPoints(Pageable pageable);

    Page<MonitoringPoint> getAllMonitoringPoints(Specification<MonitoringPoint> spec, Pageable pageable);

	ResponseEntity<MonitoringPointPageDTO> getMonitoringPoints(MonitoringPointSearchDTO monitoringPointSearchDTO);
	
	List<MonitoringPointDTO> convertMonitoringPointsToMonitoringPointDTOs(List<MonitoringPoint> monitoringPoints, MonitoringPointConvertCriteriaDTO convertCriteria);

	MonitoringPointDTO getMonitoringPointDTOById(Integer monitoringPointId);







}





