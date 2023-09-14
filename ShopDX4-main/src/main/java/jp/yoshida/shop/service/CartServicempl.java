package jp.yoshida.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.yoshida.shop.entity.Cart;
import jp.yoshida.shop.entity.Merch;
import jp.yoshida.shop.repository.CartRepository;
import jp.yoshida.shop.repository.MerchRepository;

@Service
public class CartServicempl implements CartService {

	@Autowired
	CartRepository repository;
	
	@Autowired
	MerchRepository merchRepository;
	
	@Override
	public void deleteByUid(Integer uid) {
//		repository.deleteByUid(uid);
	}
    public void processPaymentAndReduceStock(List<Cart> cartItems) {
        for (Cart cartItem : cartItems) {
            Merch merch = new Merch();
            int purchasedQuantity = cartItem.getBuynum();
            
            
            int currentStock = merch.getStock();
            int updatedStock = currentStock - purchasedQuantity;
            merch.setStock(updatedStock);
            merchRepository.save(merch);
            
            repository.delete(cartItem);
        }
    }
}
