package com.kh.spring.shop.vo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name="orders")
@Getter
@Setter

public class Payment {

		@Id
		@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paymentId_seq")
		@SequenceGenerator(name="orderId_seq",sequenceName="payment_seq", allocationSize=1)
		private Long id;
		//누가 주문했는지
		//결제를 얼마나 했는지 
		@ManyToOne
		@JoinColumn(name = "order_id")
		private Order order;
		private String paymentStatus;//제품의 주문 수량

	}
}
