package com.aladdinworksfivefiftyfive.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.aladdinworksfivefiftyfive.dao.GenericDAO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.service.impl.GenericServiceImpl;
import com.aladdinworksfivefiftyfive.dao.NetworkSwitchDAO;
import com.aladdinworksfivefiftyfive.domain.NetworkSwitch;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchDTO;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchSearchDTO;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchPageDTO;
import com.aladdinworksfivefiftyfive.dto.NetworkSwitchConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import com.aladdinworksfivefiftyfive.service.NetworkSwitchService;
import com.aladdinworksfivefiftyfive.util.ControllerUtils;





@Service
public class NetworkSwitchServiceImpl extends GenericServiceImpl<NetworkSwitch, Integer> implements NetworkSwitchService {

    private final static Logger logger = LoggerFactory.getLogger(NetworkSwitchServiceImpl.class);

	@Autowired
	NetworkSwitchDAO networkSwitchDao;

	


	@Override
	public GenericDAO<NetworkSwitch, Integer> getDAO() {
		return (GenericDAO<NetworkSwitch, Integer>) networkSwitchDao;
	}
	
	public List<NetworkSwitch> findAll () {
		List<NetworkSwitch> networkSwitchs = networkSwitchDao.findAll();
		
		return networkSwitchs;	
		
	}

	public ResultDTO addNetworkSwitch(NetworkSwitchDTO networkSwitchDTO, RequestDTO requestDTO) {

		NetworkSwitch networkSwitch = new NetworkSwitch();

		networkSwitch.setNetworkSwitchId(networkSwitchDTO.getNetworkSwitchId());


		networkSwitch.setPorts(networkSwitchDTO.getPorts());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		networkSwitch = networkSwitchDao.save(networkSwitch);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<NetworkSwitch> getAllNetworkSwitchs(Pageable pageable) {
		return networkSwitchDao.findAll(pageable);
	}

	public Page<NetworkSwitch> getAllNetworkSwitchs(Specification<NetworkSwitch> spec, Pageable pageable) {
		return networkSwitchDao.findAll(spec, pageable);
	}

	public ResponseEntity<NetworkSwitchPageDTO> getNetworkSwitchs(NetworkSwitchSearchDTO networkSwitchSearchDTO) {
	
			Integer networkSwitchId = networkSwitchSearchDTO.getNetworkSwitchId(); 
  			String sortBy = networkSwitchSearchDTO.getSortBy();
			String sortOrder = networkSwitchSearchDTO.getSortOrder();
			String searchQuery = networkSwitchSearchDTO.getSearchQuery();
			Integer page = networkSwitchSearchDTO.getPage();
			Integer size = networkSwitchSearchDTO.getSize();

	        Specification<NetworkSwitch> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, networkSwitchId, "networkSwitchId"); 
			
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<NetworkSwitch> networkSwitchs = this.getAllNetworkSwitchs(spec, pageable);
		
		//System.out.println(String.valueOf(networkSwitchs.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(networkSwitchs.getTotalPages()));
		
		List<NetworkSwitch> networkSwitchsList = networkSwitchs.getContent();
		
		NetworkSwitchConvertCriteriaDTO convertCriteria = new NetworkSwitchConvertCriteriaDTO();
		List<NetworkSwitchDTO> networkSwitchDTOs = this.convertNetworkSwitchsToNetworkSwitchDTOs(networkSwitchsList,convertCriteria);
		
		NetworkSwitchPageDTO networkSwitchPageDTO = new NetworkSwitchPageDTO();
		networkSwitchPageDTO.setNetworkSwitchs(networkSwitchDTOs);
		networkSwitchPageDTO.setTotalElements(networkSwitchs.getTotalElements());
		return ResponseEntity.ok(networkSwitchPageDTO);
	}

	public List<NetworkSwitchDTO> convertNetworkSwitchsToNetworkSwitchDTOs(List<NetworkSwitch> networkSwitchs, NetworkSwitchConvertCriteriaDTO convertCriteria) {
		
		List<NetworkSwitchDTO> networkSwitchDTOs = new ArrayList<NetworkSwitchDTO>();
		
		for (NetworkSwitch networkSwitch : networkSwitchs) {
			networkSwitchDTOs.add(convertNetworkSwitchToNetworkSwitchDTO(networkSwitch,convertCriteria));
		}
		
		return networkSwitchDTOs;

	}
	
	public NetworkSwitchDTO convertNetworkSwitchToNetworkSwitchDTO(NetworkSwitch networkSwitch, NetworkSwitchConvertCriteriaDTO convertCriteria) {
		
		NetworkSwitchDTO networkSwitchDTO = new NetworkSwitchDTO();
		
		networkSwitchDTO.setNetworkSwitchId(networkSwitch.getNetworkSwitchId());

	
		networkSwitchDTO.setPorts(networkSwitch.getPorts());

	

		
		return networkSwitchDTO;
	}

	public ResultDTO updateNetworkSwitch(NetworkSwitchDTO networkSwitchDTO, RequestDTO requestDTO) {
		
		NetworkSwitch networkSwitch = networkSwitchDao.getById(networkSwitchDTO.getNetworkSwitchId());

		networkSwitch.setNetworkSwitchId(ControllerUtils.setValue(networkSwitch.getNetworkSwitchId(), networkSwitchDTO.getNetworkSwitchId()));

		networkSwitch.setPorts(ControllerUtils.setValue(networkSwitch.getPorts(), networkSwitchDTO.getPorts()));



        networkSwitch = networkSwitchDao.save(networkSwitch);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public NetworkSwitchDTO getNetworkSwitchDTOById(Integer networkSwitchId) {
	
		NetworkSwitch networkSwitch = networkSwitchDao.getById(networkSwitchId);
			
		
		NetworkSwitchConvertCriteriaDTO convertCriteria = new NetworkSwitchConvertCriteriaDTO();
		return(this.convertNetworkSwitchToNetworkSwitchDTO(networkSwitch,convertCriteria));
	}







}
