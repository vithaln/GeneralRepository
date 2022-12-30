package com.vithal.code.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

	@Id
	private String dId;
	
	private String dName;
	private String dType;
	private String dLocation;
	
	
	  public String getdId() { return dId; } public void setdId(String dId) {
	  this.dId = dId; } public String getdName() { return dName; } public void
	  setdName(String dName) { this.dName = dName; } public String getdType() {
	  return dType; } public void setdType(String dType) { this.dType = dType; }
	  public String getdLocation() { return dLocation; } public void
	  setdLocation(String dLocation) { this.dLocation = dLocation; }
	 
	
}
