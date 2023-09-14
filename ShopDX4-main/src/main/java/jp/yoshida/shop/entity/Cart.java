package jp.yoshida.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@IdClass(CartKey.class)
@Table(name="cart")
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	@Id
	private Integer code;
	@Id
	private Integer uid;
	private Integer price;
	private String name;
	private Integer buynum;

}
