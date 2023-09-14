package jp.yoshida.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.yoshida.shop.entity.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{
	@Query(value = "select * from users where mail = ? and password = ?" ,nativeQuery = true)
	List<Users> login(String mail,String password);
}
