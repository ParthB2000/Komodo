package com.hlis.exam.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_boat")
public class Boat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 128)
	private String name;
	
	@Column(length = 16)
	private String size;
	
	private Long capacity;
	
	private Boolean hasSensor=false;
	
	private Boolean isDeleted=false;
	
	private Boolean isActive=true;
	
	@Column(columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
	
	@Column(columnDefinition = "Timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;
	
	@ManyToOne
	@JoinColumn(name = "updated_by")
	private User updatedBy;
}
