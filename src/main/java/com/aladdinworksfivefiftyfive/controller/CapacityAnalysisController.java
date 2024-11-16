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

import com.aladdinworksfivefiftyfive.domain.CapacityAnalysis;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisDTO;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisSearchDTO;
import com.aladdinworksfivefiftyfive.dto.CapacityAnalysisPageDTO;
import com.aladdinworksfivefiftyfive.service.CapacityAnalysisService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/capacityAnalysis")
@RestController
public class CapacityAnalysisController {

	private final static Logger logger = LoggerFactory.getLogger(CapacityAnalysisController.class);

	@Autowired
	CapacityAnalysisService capacityAnalysisService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<CapacityAnalysis> getAll() {

		List<CapacityAnalysis> capacityAnalysiss = capacityAnalysisService.findAll();
		
		return capacityAnalysiss;	
	}

	@GetMapping(value = "/{capacityAnalysisId}")
	@ResponseBody
	public CapacityAnalysisDTO getCapacityAnalysis(@PathVariable Integer capacityAnalysisId) {
		
		return (capacityAnalysisService.getCapacityAnalysisDTOById(capacityAnalysisId));
	}

 	@RequestMapping(value = "/addCapacityAnalysis", method = RequestMethod.POST)
	public ResponseEntity<?> addCapacityAnalysis(@RequestBody CapacityAnalysisDTO capacityAnalysisDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = capacityAnalysisService.addCapacityAnalysis(capacityAnalysisDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/capacityAnalysiss")
	public ResponseEntity<CapacityAnalysisPageDTO> getCapacityAnalysiss(CapacityAnalysisSearchDTO capacityAnalysisSearchDTO) {
 
		return capacityAnalysisService.getCapacityAnalysiss(capacityAnalysisSearchDTO);
	}	

	@RequestMapping(value = "/updateCapacityAnalysis", method = RequestMethod.POST)
	public ResponseEntity<?> updateCapacityAnalysis(@RequestBody CapacityAnalysisDTO capacityAnalysisDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = capacityAnalysisService.updateCapacityAnalysis(capacityAnalysisDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
