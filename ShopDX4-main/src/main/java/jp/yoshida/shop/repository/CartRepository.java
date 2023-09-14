package jp.yoshida.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jp.yoshida.shop.entity.Cart;

@Transactional
public interface CartRepository extends JpaRepository<Cart,Integer>{
	
	List<Cart> findByUid(Integer uid);
	
	@Modifying
	@Query(value = "delete from cart where uid = ?1 and code = ?2", nativeQuery = true)
	void deleteByUid(Integer uid,Integer code);
	
	@Query(value = "select uid from cart where uid = ?1", nativeQuery = true)
	List<Cart> findUid(int uid);
}
