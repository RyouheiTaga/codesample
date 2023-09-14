package jp.yoshida.shop.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="merch")
@AllArgsConstructor
@NoArgsConstructor
public class Merch {
	@Id
	private Integer code;
	private String name;
	private Integer price;
	private String category;
	private String attribute;
	private Integer stock;
	private LocalDate regiday;
	private LocalDate update; 
	private LocalDate eos;
}
