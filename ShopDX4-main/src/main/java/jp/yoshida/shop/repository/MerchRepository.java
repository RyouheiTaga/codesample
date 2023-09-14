package jp.yoshida.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import jp.yoshida.shop.entity.Merch;

@Transactional

public interface MerchRepository extends JpaRepository<Merch, Integer> {
	@Modifying
	@Query(value = "update merch set stock = stock - ?1 where code = ?2", nativeQuery = true)
	void minus(int buynum, int code);

	@Query(value = "select * from merch where category = ?", nativeQuery = true)
	List<Merch> findByCategory(String categoryName);

	

	Merch findByCode(Integer itemCode);
	

//	List<Merch> findByCode(Integer code);
	@Query(value = "select * from merch order by code asc", nativeQuery = true)
	List<Merch> codeAsc();

	
	@Query(value = "select * from merch where code = ?1" ,nativeQuery = true)
	List<Merch> search(Integer code);

	@Modifying
	@Query(value = "update merch set category = ?1 where code = ?2", nativeQuery = true)
	void category(String category, int code);

	@Modifying
	@Query(value = "delete from merch where code = ?1", nativeQuery = true)
	void delete(Integer code);

	@Modifying
	@Query(value = "update merch set stock = stock + ?1 where code = ?2", nativeQuery = true)

	void plus(int stock, int code);
}
