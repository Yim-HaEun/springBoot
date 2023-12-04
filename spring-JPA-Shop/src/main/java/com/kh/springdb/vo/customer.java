package com.kh.springdb.vo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name="customer")
public class customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="sequence_name")
	@SequenceGenerator(name="customer_seq",sequenceName="customer_seq",allocationSize=1)
	private Long customer_id;
	private String customer_nickname;
	private String customer_pw;
	private String customer_email;
	

}
