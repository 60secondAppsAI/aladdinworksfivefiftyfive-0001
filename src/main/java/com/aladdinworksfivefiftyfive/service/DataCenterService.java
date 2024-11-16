package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.DataCenter;
import com.aladdinworksfivefiftyfive.dto.DataCenterDTO;
import com.aladdinworksfivefiftyfive.dto.DataCenterSearchDTO;
import com.aladdinworksfivefiftyfive.dto.DataCenterPageDTO;
import com.aladdinworksfivefiftyfive.dto.DataCenterConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface DataCenterService extends GenericService<DataCenter, Integer> {

	List<DataCenter> findAll();

	ResultDTO addDataCenter(DataCenterDTO dataCenterDTO, RequestDTO requestDTO);

	ResultDTO updateDataCenter(DataCenterDTO dataCenterDTO, RequestDTO requestDTO);

    Page<DataCenter> getAllDataCenters(Pageable pageable);

    Page<DataCenter> getAllDataCenters(Specification<DataCenter> spec, Pageable pageable);

	ResponseEntity<DataCenterPageDTO> getDataCenters(DataCenterSearchDTO dataCenterSearchDTO);
	
	List<DataCenterDTO> convertDataCentersToDataCenterDTOs(List<DataCenter> dataCenters, DataCenterConvertCriteriaDTO convertCriteria);

	DataCenterDTO getDataCenterDTOById(Integer dataCenterId);







}





