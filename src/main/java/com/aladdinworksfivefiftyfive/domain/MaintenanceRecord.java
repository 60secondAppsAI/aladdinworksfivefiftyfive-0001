package com.aladdinworksfivefiftyfive.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.time.Year;
import jakarta.persistence.Transient;



@Entity
@Table(name="maintenance_records")
@Getter @Setter @NoArgsConstructor
public class MaintenanceRecord {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  	@Column(name="maintenance_record_id")
	private Integer maintenanceRecordId;
    
  	@Column(name="equipment_id")
	private String equipmentId;
    
  	@Column(name="maintenance_date")
	private Date maintenanceDate;
    
  	@Column(name="details")
	private String details;
    
	




}
