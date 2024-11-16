package com.aladdinworksfivefiftyfive.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.aladdinworksfivefiftyfive.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.aladdinworksfivefiftyfive.domain.Incident;
import com.aladdinworksfivefiftyfive.dto.IncidentDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentSearchDTO;
import com.aladdinworksfivefiftyfive.dto.IncidentPageDTO;
import com.aladdinworksfivefiftyfive.service.IncidentService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/incident")
@RestController
public class IncidentController {

	private final static Logger logger = LoggerFactory.getLogger(IncidentController.class);

	@Autowired
	IncidentService incidentService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Incident> getAll() {

		List<Incident> incidents = incidentService.findAll();
		
		return incidents;	
	}

	@GetMapping(value = "/{incidentId}")
	@ResponseBody
	public IncidentDTO getIncident(@PathVariable Integer incidentId) {
		
		return (incidentService.getIncidentDTOById(incidentId));
	}

 	@RequestMapping(value = "/addIncident", method = RequestMethod.POST)
	public ResponseEntity<?> addIncident(@RequestBody IncidentDTO incidentDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = incidentService.addIncident(incidentDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/incidents")
	public ResponseEntity<IncidentPageDTO> getIncidents(IncidentSearchDTO incidentSearchDTO) {
 
		return incidentService.getIncidents(incidentSearchDTO);
	}	

	@RequestMapping(value = "/updateIncident", method = RequestMethod.POST)
	public ResponseEntity<?> updateIncident(@RequestBody IncidentDTO incidentDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = incidentService.updateIncident(incidentDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
