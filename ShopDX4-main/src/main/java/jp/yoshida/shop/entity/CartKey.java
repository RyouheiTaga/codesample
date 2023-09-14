package jp.yoshida.shop.entity;

import java.io.Serializable;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CartKey implements Serializable{
@Id
private Integer code;
@Id
private Integer uid;
}
