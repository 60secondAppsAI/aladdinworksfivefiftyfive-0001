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

import com.aladdinworksfivefiftyfive.domain.EnvironmentalMetric;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricDTO;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricSearchDTO;
import com.aladdinworksfivefiftyfive.dto.EnvironmentalMetricPageDTO;
import com.aladdinworksfivefiftyfive.service.EnvironmentalMetricService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/environmentalMetric")
@RestController
public class EnvironmentalMetricController {

	private final static Logger logger = LoggerFactory.getLogger(EnvironmentalMetricController.class);

	@Autowired
	EnvironmentalMetricService environmentalMetricService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<EnvironmentalMetric> getAll() {

		List<EnvironmentalMetric> environmentalMetrics = environmentalMetricService.findAll();
		
		return environmentalMetrics;	
	}

	@GetMapping(value = "/{environmentalMetricId}")
	@ResponseBody
	public EnvironmentalMetricDTO getEnvironmentalMetric(@PathVariable Integer environmentalMetricId) {
		
		return (environmentalMetricService.getEnvironmentalMetricDTOById(environmentalMetricId));
	}

 	@RequestMapping(value = "/addEnvironmentalMetric", method = RequestMethod.POST)
	public ResponseEntity<?> addEnvironmentalMetric(@RequestBody EnvironmentalMetricDTO environmentalMetricDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = environmentalMetricService.addEnvironmentalMetric(environmentalMetricDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/environmentalMetrics")
	public ResponseEntity<EnvironmentalMetricPageDTO> getEnvironmentalMetrics(EnvironmentalMetricSearchDTO environmentalMetricSearchDTO) {
 
		return environmentalMetricService.getEnvironmentalMetrics(environmentalMetricSearchDTO);
	}	

	@RequestMapping(value = "/updateEnvironmentalMetric", method = RequestMethod.POST)
	public ResponseEntity<?> updateEnvironmentalMetric(@RequestBody EnvironmentalMetricDTO environmentalMetricDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = environmentalMetricService.updateEnvironmentalMetric(environmentalMetricDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
