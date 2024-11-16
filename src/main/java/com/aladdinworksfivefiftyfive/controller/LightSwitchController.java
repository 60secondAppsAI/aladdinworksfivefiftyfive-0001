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

import com.aladdinworksfivefiftyfive.domain.LightSwitch;
import com.aladdinworksfivefiftyfive.dto.LightSwitchDTO;
import com.aladdinworksfivefiftyfive.dto.LightSwitchSearchDTO;
import com.aladdinworksfivefiftyfive.dto.LightSwitchPageDTO;
import com.aladdinworksfivefiftyfive.service.LightSwitchService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/lightSwitch")
@RestController
public class LightSwitchController {

	private final static Logger logger = LoggerFactory.getLogger(LightSwitchController.class);

	@Autowired
	LightSwitchService lightSwitchService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<LightSwitch> getAll() {

		List<LightSwitch> lightSwitchs = lightSwitchService.findAll();
		
		return lightSwitchs;	
	}

	@GetMapping(value = "/{lightSwitchId}")
	@ResponseBody
	public LightSwitchDTO getLightSwitch(@PathVariable Integer lightSwitchId) {
		
		return (lightSwitchService.getLightSwitchDTOById(lightSwitchId));
	}

 	@RequestMapping(value = "/addLightSwitch", method = RequestMethod.POST)
	public ResponseEntity<?> addLightSwitch(@RequestBody LightSwitchDTO lightSwitchDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = lightSwitchService.addLightSwitch(lightSwitchDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/lightSwitchs")
	public ResponseEntity<LightSwitchPageDTO> getLightSwitchs(LightSwitchSearchDTO lightSwitchSearchDTO) {
 
		return lightSwitchService.getLightSwitchs(lightSwitchSearchDTO);
	}	

	@RequestMapping(value = "/updateLightSwitch", method = RequestMethod.POST)
	public ResponseEntity<?> updateLightSwitch(@RequestBody LightSwitchDTO lightSwitchDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = lightSwitchService.updateLightSwitch(lightSwitchDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
