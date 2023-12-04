package com.kh.springdb.vo;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@Table(name="admin")
public class admin {
	@Id
	private Long adminId;
	private String adminPw;
}

