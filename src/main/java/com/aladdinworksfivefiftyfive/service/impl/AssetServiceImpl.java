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
import com.aladdinworksfivefiftyfive.dao.AssetDAO;
import com.aladdinworksfivefiftyfive.domain.Asset;
import com.aladdinworksfivefiftyfive.dto.AssetDTO;
import com.aladdinworksfivefiftyfive.dto.AssetSearchDTO;
import com.aladdinworksfivefiftyfive.dto.AssetPageDTO;
import com.aladdinworksfivefiftyfive.dto.AssetConvertCriteriaDTO;
import com.aladdinworksfivefiftyfive.dto.common.RequestDTO;
import com.aladdinworksfivefiftyfive.dto.common.ResultDTO;
import com.aladdinworksfivefiftyfive.service.AssetService;
import com.aladdinworksfivefiftyfive.util.ControllerUtils;





@Service
public class AssetServiceImpl extends GenericServiceImpl<Asset, Integer> implements AssetService {

    private final static Logger logger = LoggerFactory.getLogger(AssetServiceImpl.class);

	@Autowired
	AssetDAO assetDao;

	


	@Override
	public GenericDAO<Asset, Integer> getDAO() {
		return (GenericDAO<Asset, Integer>) assetDao;
	}
	
	public List<Asset> findAll () {
		List<Asset> assets = assetDao.findAll();
		
		return assets;	
		
	}

	public ResultDTO addAsset(AssetDTO assetDTO, RequestDTO requestDTO) {

		Asset asset = new Asset();

		asset.setAssetId(assetDTO.getAssetId());


		asset.setAssetTag(assetDTO.getAssetTag());


		asset.setAcquisitionDate(assetDTO.getAcquisitionDate());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		asset = assetDao.save(asset);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Asset> getAllAssets(Pageable pageable) {
		return assetDao.findAll(pageable);
	}

	public Page<Asset> getAllAssets(Specification<Asset> spec, Pageable pageable) {
		return assetDao.findAll(spec, pageable);
	}

	public ResponseEntity<AssetPageDTO> getAssets(AssetSearchDTO assetSearchDTO) {
	
			Integer assetId = assetSearchDTO.getAssetId(); 
 			String assetTag = assetSearchDTO.getAssetTag(); 
   			String sortBy = assetSearchDTO.getSortBy();
			String sortOrder = assetSearchDTO.getSortOrder();
			String searchQuery = assetSearchDTO.getSearchQuery();
			Integer page = assetSearchDTO.getPage();
			Integer size = assetSearchDTO.getSize();

	        Specification<Asset> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, assetId, "assetId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, assetTag, "assetTag"); 
			
 			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("assetTag")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<Asset> assets = this.getAllAssets(spec, pageable);
		
		//System.out.println(String.valueOf(assets.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(assets.getTotalPages()));
		
		List<Asset> assetsList = assets.getContent();
		
		AssetConvertCriteriaDTO convertCriteria = new AssetConvertCriteriaDTO();
		List<AssetDTO> assetDTOs = this.convertAssetsToAssetDTOs(assetsList,convertCriteria);
		
		AssetPageDTO assetPageDTO = new AssetPageDTO();
		assetPageDTO.setAssets(assetDTOs);
		assetPageDTO.setTotalElements(assets.getTotalElements());
		return ResponseEntity.ok(assetPageDTO);
	}

	public List<AssetDTO> convertAssetsToAssetDTOs(List<Asset> assets, AssetConvertCriteriaDTO convertCriteria) {
		
		List<AssetDTO> assetDTOs = new ArrayList<AssetDTO>();
		
		for (Asset asset : assets) {
			assetDTOs.add(convertAssetToAssetDTO(asset,convertCriteria));
		}
		
		return assetDTOs;

	}
	
	public AssetDTO convertAssetToAssetDTO(Asset asset, AssetConvertCriteriaDTO convertCriteria) {
		
		AssetDTO assetDTO = new AssetDTO();
		
		assetDTO.setAssetId(asset.getAssetId());

	
		assetDTO.setAssetTag(asset.getAssetTag());

	
		assetDTO.setAcquisitionDate(asset.getAcquisitionDate());

	

		
		return assetDTO;
	}

	public ResultDTO updateAsset(AssetDTO assetDTO, RequestDTO requestDTO) {
		
		Asset asset = assetDao.getById(assetDTO.getAssetId());

		asset.setAssetId(ControllerUtils.setValue(asset.getAssetId(), assetDTO.getAssetId()));

		asset.setAssetTag(ControllerUtils.setValue(asset.getAssetTag(), assetDTO.getAssetTag()));

		asset.setAcquisitionDate(ControllerUtils.setValue(asset.getAcquisitionDate(), assetDTO.getAcquisitionDate()));



        asset = assetDao.save(asset);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public AssetDTO getAssetDTOById(Integer assetId) {
	
		Asset asset = assetDao.getById(assetId);
			
		
		AssetConvertCriteriaDTO convertCriteria = new AssetConvertCriteriaDTO();
		return(this.convertAssetToAssetDTO(asset,convertCriteria));
	}







}
