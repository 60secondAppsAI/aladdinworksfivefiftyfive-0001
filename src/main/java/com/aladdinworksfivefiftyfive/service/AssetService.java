package com.aladdinworksfivefiftyfive.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.aladdinworksfivefiftyfive.domain.Asset;
import com.aladdinworksfivefiftyfive.dto.AssetDTO;
import com.aladdinworksfivefiftyfive.dto.AssetSearchDTO;
import com.aladdinworksfivefiftyfive.dto.AssetPageDTO;
import com.aladdinworksfivefiftyfive.dto.AssetConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.service.GenericService;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AssetService extends GenericService<Asset, Integer> {

	List<Asset> findAll();

	ResultDTO addAsset(AssetDTO assetDTO, RequestDTO requestDTO);

	ResultDTO updateAsset(AssetDTO assetDTO, RequestDTO requestDTO);

    Page<Asset> getAllAssets(Pageable pageable);

    Page<Asset> getAllAssets(Specification<Asset> spec, Pageable pageable);

	ResponseEntity<AssetPageDTO> getAssets(AssetSearchDTO assetSearchDTO);
	
	List<AssetDTO> convertAssetsToAssetDTOs(List<Asset> assets, AssetConvertCriteriaDTO convertCriteria);

	AssetDTO getAssetDTOById(Integer assetId);







}





