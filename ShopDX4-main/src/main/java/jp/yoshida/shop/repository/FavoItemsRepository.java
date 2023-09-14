package jp.yoshida.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.yoshida.shop.entity.FavoItems;

public interface FavoItemsRepository extends JpaRepository<FavoItems,Integer>{

	@Query(value = "SELECT MAX(code) FROM favoitems", nativeQuery = true)
	Iterable<Integer> findMaxCode();
}
