package com.test.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

import org.hibernate.type.TrueFalseType;

@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DEPARTMENT_ID", unique = true, nullable = false)
	private int deptId;

	@Column(name = "DNAME", nullable = true)
	private String deptName;

	@Column(name = "LOCATION_ID", nullable = true)
	private String locationId;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

}
