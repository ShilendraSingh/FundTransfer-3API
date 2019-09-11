package com.bank.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer implements Serializable {
	

	private static final long serialVersionUID = -8774775141489381504L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String name;
	private int age;
	private String mobileNumber;
	private String gender;
	private String password;

}
