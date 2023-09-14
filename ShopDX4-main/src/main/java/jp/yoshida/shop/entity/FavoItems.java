package jp.yoshida.shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="favoitems")
@AllArgsConstructor
@NoArgsConstructor
public class FavoItems {
	@Id
	private Integer num;
	private Integer user_id;
	private Integer item_code;
}