package jp.yoshida.shop;

import java.util.Optional;

import jp.yoshida.shop.entity.Merch;

public interface MerchService {
	Iterable<Merch> selectAll();
	Optional<Merch> selectOneById(Integer code);
	
	void insertQuiz(Merch merch);

	void updateQuiz(Merch merch);
	
	void deleteQuizById(Integer id);

	
	
}
