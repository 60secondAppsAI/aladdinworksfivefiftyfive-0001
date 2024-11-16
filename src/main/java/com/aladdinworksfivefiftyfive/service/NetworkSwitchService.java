package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.NetworkSwitch;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchDTO;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchSearchDTO;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchPageDTO;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface NetworkSwitchService extends GenericService<NetworkSwitch, Integer> {

	List<NetworkSwitch> findAll();

	ResultDTO addNetworkSwitch(NetworkSwitchDTO networkSwitchDTO, RequestDTO requestDTO);

	ResultDTO updateNetworkSwitch(NetworkSwitchDTO networkSwitchDTO, RequestDTO requestDTO);

    Page<NetworkSwitch> getAllNetworkSwitchs(Pageable pageable);

    Page<NetworkSwitch> getAllNetworkSwitchs(Specification<NetworkSwitch> spec, Pageable pageable);

	ResponseEntity<NetworkSwitchPageDTO> getNetworkSwitchs(NetworkSwitchSearchDTO networkSwitchSearchDTO);
	
	List<NetworkSwitchDTO> convertNetworkSwitchsToNetworkSwitchDTOs(List<NetworkSwitch> networkSwitchs, NetworkSwitchConvertCriteriaDTO convertCriteria);

	NetworkSwitchDTO getNetworkSwitchDTOById(Integer networkSwitchId);







}





