package com.kh.board.vo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name="board")
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="board_id_sequence")
	@SequenceGenerator(name="board_id_sequence", sequenceName="board_id_sequence",allocationSize=1)
	@Column(name="board_id")
	private Long boardId;
	@Column(nullable=false,length=50)
	private String title;
	@Column(nullable=false,length=50)
	private String content;
	@Column(nullable=false,length=50)
	private String author;

}
