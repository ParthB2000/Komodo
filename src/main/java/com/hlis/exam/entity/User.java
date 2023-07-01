package com.hlis.exam.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "tbl_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 64)
	private String firstName;
	
	@Column(length = 64)
	private String lastName;
	
	@Column(length = 128)
	private String email;
	
	@Column(length = 256)
	private String token=null;
	
	private Boolean isBlocked=false;
	
	private Boolean isVerified=false;
	
	@Column(length = 256)
	private String password;
	
	private String role="USER";
	
	
	
	private Boolean isDeleted=false;
	
	private Boolean isActive=true;
	
	@Column(columnDefinition = "Timestamp default CURRENT_TIMESTAMP")
	private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
	
	@Column(columnDefinition = "Timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

}
