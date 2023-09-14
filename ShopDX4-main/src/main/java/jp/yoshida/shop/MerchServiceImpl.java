package jp.yoshida.shop;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.yoshida.shop.entity.Merch;
import jp.yoshida.shop.repository.MerchRepository;
@Service
public class MerchServiceImpl implements MerchService{
	
	@Autowired
	MerchRepository repository;
	@Override
	public Iterable<Merch> selectAll() {
		return repository.findAll();
	}
	@Override
	public Optional<Merch> selectOneById(Integer code) {
		return repository.findById(code);
	}
	

	@Override
	public void insertQuiz(Merch merch) {
		repository.save(merch);
	}
	@Override
	public void updateQuiz(Merch merch) {
		repository.save(merch);
	}
	@Override
	public void deleteQuizById(Integer code) {
		repository.deleteById(code);
	}
}

