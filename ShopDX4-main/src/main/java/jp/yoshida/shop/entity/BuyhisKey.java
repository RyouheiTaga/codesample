package jp.yoshida.shop.entity;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class BuyhisKey {
	@Id
	private Integer code;
	@Id
	private Integer uid;
}
