package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.Incident;
import com.aladdinworksfivefiftyfive.dto.IncidentDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentSearchDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentPageDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface IncidentService extends GenericService<Incident, Integer> {

	List<Incident> findAll();

	ResultDTO addIncident(IncidentDTO incidentDTO, RequestDTO requestDTO);

	ResultDTO updateIncident(IncidentDTO incidentDTO, RequestDTO requestDTO);

    Page<Incident> getAllIncidents(Pageable pageable);

    Page<Incident> getAllIncidents(Specification<Incident> spec, Pageable pageable);

	ResponseEntity<IncidentPageDTO> getIncidents(IncidentSearchDTO incidentSearchDTO);
	
	List<IncidentDTO> convertIncidentsToIncidentDTOs(List<Incident> incidents, IncidentConvertCriteriaDTO convertCriteria);

	IncidentDTO getIncidentDTOById(Integer incidentId);







}





