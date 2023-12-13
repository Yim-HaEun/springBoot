package com.kh.springdb.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter 
@Entity
public class SiteUser {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize=1)
	private Long id;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	
	@Column(unique = true)
	private String email;

	//추천인을 넣고싶다면 추천자를 생성해서 넣어도 됨
}
