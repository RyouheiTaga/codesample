package jp.yoshida.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.yoshida.shop.entity.Buyhistory;

public interface BuyhistoryRepository extends JpaRepository<Buyhistory,Integer>{
	List<Buyhistory> findByUid(Integer uid);
}
