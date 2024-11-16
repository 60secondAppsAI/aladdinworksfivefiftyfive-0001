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

import com.aladdinworksfivefiftyfive.domain.PowerUsageReport;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportDTO;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportSearchDTO;
import com.aladdinworksfivefiftyfive.dto.PowerUsageReportPageDTO;
import com.aladdinworksfivefiftyfive.service.PowerUsageReportService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/powerUsageReport")
@RestController
public class PowerUsageReportController {

	private final static Logger logger = LoggerFactory.getLogger(PowerUsageReportController.class);

	@Autowired
	PowerUsageReportService powerUsageReportService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<PowerUsageReport> getAll() {

		List<PowerUsageReport> powerUsageReports = powerUsageReportService.findAll();
		
		return powerUsageReports;	
	}

	@GetMapping(value = "/{powerUsageReportId}")
	@ResponseBody
	public PowerUsageReportDTO getPowerUsageReport(@PathVariable Integer powerUsageReportId) {
		
		return (powerUsageReportService.getPowerUsageReportDTOById(powerUsageReportId));
	}

 	@RequestMapping(value = "/addPowerUsageReport", method = RequestMethod.POST)
	public ResponseEntity<?> addPowerUsageReport(@RequestBody PowerUsageReportDTO powerUsageReportDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = powerUsageReportService.addPowerUsageReport(powerUsageReportDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/powerUsageReports")
	public ResponseEntity<PowerUsageReportPageDTO> getPowerUsageReports(PowerUsageReportSearchDTO powerUsageReportSearchDTO) {
 
		return powerUsageReportService.getPowerUsageReports(powerUsageReportSearchDTO);
	}	

	@RequestMapping(value = "/updatePowerUsageReport", method = RequestMethod.POST)
	public ResponseEntity<?> updatePowerUsageReport(@RequestBody PowerUsageReportDTO powerUsageReportDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = powerUsageReportService.updatePowerUsageReport(powerUsageReportDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
