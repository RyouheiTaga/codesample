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
@IdClass(BuyhisKey.class)
@Table(name="buyhistory")
@AllArgsConstructor
@NoArgsConstructor
public class Buyhistory {
@Id
private Integer code;
@Id
private Integer uid;
private String name;
}
