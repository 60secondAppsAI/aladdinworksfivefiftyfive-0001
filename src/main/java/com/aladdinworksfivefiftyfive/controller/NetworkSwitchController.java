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

import com.aladdinworksfivefiftyfive.domain.NetworkSwitch;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchDTO;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchSearchDTO;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchPageDTO;
import com.aladdinworksfivefiftyfive.service.NetworkSwitchService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/networkSwitch")
@RestController
public class NetworkSwitchController {

	private final static Logger logger = LoggerFactory.getLogger(NetworkSwitchController.class);

	@Autowired
	NetworkSwitchService networkSwitchService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<NetworkSwitch> getAll() {

		List<NetworkSwitch> networkSwitchs = networkSwitchService.findAll();
		
		return networkSwitchs;	
	}

	@GetMapping(value = "/{networkSwitchId}")
	@ResponseBody
	public NetworkSwitchDTO getNetworkSwitch(@PathVariable Integer networkSwitchId) {
		
		return (networkSwitchService.getNetworkSwitchDTOById(networkSwitchId));
	}

 	@RequestMapping(value = "/addNetworkSwitch", method = RequestMethod.POST)
	public ResponseEntity<?> addNetworkSwitch(@RequestBody NetworkSwitchDTO networkSwitchDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = networkSwitchService.addNetworkSwitch(networkSwitchDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/networkSwitchs")
	public ResponseEntity<NetworkSwitchPageDTO> getNetworkSwitchs(NetworkSwitchSearchDTO networkSwitchSearchDTO) {
 
		return networkSwitchService.getNetworkSwitchs(networkSwitchSearchDTO);
	}	

	@RequestMapping(value = "/updateNetworkSwitch", method = RequestMethod.POST)
	public ResponseEntity<?> updateNetworkSwitch(@RequestBody NetworkSwitchDTO networkSwitchDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = networkSwitchService.updateNetworkSwitch(networkSwitchDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
