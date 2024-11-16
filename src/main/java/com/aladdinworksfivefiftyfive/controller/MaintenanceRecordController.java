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

import com.aladdinworksfivefiftyfive.domain.MaintenanceRecord;
import com.aladdinworksfivefiftyfive.dto.MaintenanceRecordDTO;
import com.aladdinworksfivefiftyfive.dto.MaintenanceRecordSearchDTO;
import com.aladdinworksfivefiftyfive.dto.MaintenanceRecordPageDTO;
import com.aladdinworksfivefiftyfive.service.MaintenanceRecordService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/maintenanceRecord")
@RestController
public class MaintenanceRecordController {

	private final static Logger logger = LoggerFactory.getLogger(MaintenanceRecordController.class);

	@Autowired
	MaintenanceRecordService maintenanceRecordService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<MaintenanceRecord> getAll() {

		List<MaintenanceRecord> maintenanceRecords = maintenanceRecordService.findAll();
		
		return maintenanceRecords;	
	}

	@GetMapping(value = "/{maintenanceRecordId}")
	@ResponseBody
	public MaintenanceRecordDTO getMaintenanceRecord(@PathVariable Integer maintenanceRecordId) {
		
		return (maintenanceRecordService.getMaintenanceRecordDTOById(maintenanceRecordId));
	}

 	@RequestMapping(value = "/addMaintenanceRecord", method = RequestMethod.POST)
	public ResponseEntity<?> addMaintenanceRecord(@RequestBody MaintenanceRecordDTO maintenanceRecordDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = maintenanceRecordService.addMaintenanceRecord(maintenanceRecordDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/maintenanceRecords")
	public ResponseEntity<MaintenanceRecordPageDTO> getMaintenanceRecords(MaintenanceRecordSearchDTO maintenanceRecordSearchDTO) {
 
		return maintenanceRecordService.getMaintenanceRecords(maintenanceRecordSearchDTO);
	}	

	@RequestMapping(value = "/updateMaintenanceRecord", method = RequestMethod.POST)
	public ResponseEntity<?> updateMaintenanceRecord(@RequestBody MaintenanceRecordDTO maintenanceRecordDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = maintenanceRecordService.updateMaintenanceRecord(maintenanceRecordDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
