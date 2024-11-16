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

import com.aladdinworksfivefiftyfive.domain.MonitoringPoint;
import com.aladdinworksfivefiftyfive.dto.MonitoringPointDTO;
import com.aladdinworksfivefiftyfive.dto.MonitoringPointSearchDTO;
import com.aladdinworksfivefiftyfive.dto.MonitoringPointPageDTO;
import com.aladdinworksfivefiftyfive.service.MonitoringPointService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/monitoringPoint")
@RestController
public class MonitoringPointController {

	private final static Logger logger = LoggerFactory.getLogger(MonitoringPointController.class);

	@Autowired
	MonitoringPointService monitoringPointService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<MonitoringPoint> getAll() {

		List<MonitoringPoint> monitoringPoints = monitoringPointService.findAll();
		
		return monitoringPoints;	
	}

	@GetMapping(value = "/{monitoringPointId}")
	@ResponseBody
	public MonitoringPointDTO getMonitoringPoint(@PathVariable Integer monitoringPointId) {
		
		return (monitoringPointService.getMonitoringPointDTOById(monitoringPointId));
	}

 	@RequestMapping(value = "/addMonitoringPoint", method = RequestMethod.POST)
	public ResponseEntity<?> addMonitoringPoint(@RequestBody MonitoringPointDTO monitoringPointDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = monitoringPointService.addMonitoringPoint(monitoringPointDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/monitoringPoints")
	public ResponseEntity<MonitoringPointPageDTO> getMonitoringPoints(MonitoringPointSearchDTO monitoringPointSearchDTO) {
 
		return monitoringPointService.getMonitoringPoints(monitoringPointSearchDTO);
	}	

	@RequestMapping(value = "/updateMonitoringPoint", method = RequestMethod.POST)
	public ResponseEntity<?> updateMonitoringPoint(@RequestBody MonitoringPointDTO monitoringPointDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = monitoringPointService.updateMonitoringPoint(monitoringPointDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
