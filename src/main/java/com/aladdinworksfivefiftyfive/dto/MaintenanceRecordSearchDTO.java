package com.aladdinworksfivefiftyfive.dto;

import java.sql.Timestamp;
import java.time.Year;
import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MaintenanceRecordSearchDTO {

	private Integer page = 0;
	private Integer size;
	private String sortBy;
	private String sortOrder;
	private String searchQuery;

	private Integer maintenanceRecordId;
	
	private String equipmentId;
	
	private Date maintenanceDate;
	
	private String details;
	
}
