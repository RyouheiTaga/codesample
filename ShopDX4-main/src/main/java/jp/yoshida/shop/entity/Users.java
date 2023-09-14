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
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	@Id
	private Integer uid;
	private String sei;
	private String sei2;
	private String addr;
	private String tell;
	private String mail;
	private String password;
	private LocalDate birthdate;
	private Integer post;
	private String mei;
	private String mei2;
}
