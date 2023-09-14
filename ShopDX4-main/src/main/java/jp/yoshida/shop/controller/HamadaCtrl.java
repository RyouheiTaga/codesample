package jp.yoshida.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import jp.yoshida.shop.entity.Buyhistory;
import jp.yoshida.shop.entity.Cart;
import jp.yoshida.shop.entity.Merch;
import jp.yoshida.shop.repository.BuyhistoryRepository;
import jp.yoshida.shop.repository.CartRepository;
import jp.yoshida.shop.repository.MerchRepository;
import jp.yoshida.shop.repository.UsersRepository;
import jp.yoshida.shop.service.CartService;

@Controller
public class HamadaCtrl {
	
	
@Autowired
HttpSession session;

@Autowired
private CartService cs;
	
@Autowired
private MerchRepository merp;

@Autowired
private CartRepository crep;

@Autowired
private UsersRepository urep;

@Autowired
private BuyhistoryRepository buyhis;

//@PostMapping("/hamada/b")
//public String b() {
//	return "compleate";
//}
@ModelAttribute
public Merch m() {
	return new Merch();
}
@ModelAttribute
public Buyhistory b() {
	return new Buyhistory();
}
	
@GetMapping("hamada/cart")
public String cart(Model m) {
var b = crep.findByUid(1);
m.addAttribute("item", b);
return "hamada/cart";	
}
@PostMapping("hamada/buy")
public String buy(Model m) {
var b = crep.findByUid(1);
m.addAttribute("item", b);
	return "hamada/buy";
}
@PostMapping("hamada/pay")
public String pay(Model m) {
	var b = crep.findByUid(1);
	m.addAttribute("item", b);
	return "hamada/pay";
}
@PostMapping("hamada/comp")
public String comp(){
	return "hamada/comp";
}
@PostMapping("/cpay")
public String c(Model m) {
	for(Cart items : crep.findByUid(1)) {
		Buyhistory buy = new Buyhistory();
		merp.minus(items.getBuynum(), items.getCode());
		buy.setCode(items.getCode());
		buy.setName(items.getName());
		buy.setUid(1);
		buyhis.save(buy);
		crep.deleteByUid(items.getUid(),items.getCode());
	}
	return "hamada/comp";
}
@PostMapping("/hamada/delete")
public String delete(
	@RequestParam("id") String id,
	@RequestParam("uid") String code) {
	crep.deleteByUid(Integer.parseInt(code),Integer.parseInt(id));
	return "redirect:/hamada/cart";
	}
@GetMapping("/hamada/buyhis")
public String buyhis(Model m) {
	var b = buyhis.findByUid(1);
	m.addAttribute("item", b);
	return "hamada/buyhistory";
}


//勘だけで作ったログイン機能
@PostMapping("/loging")
public String login(@RequestParam("mail") String mail,
		@RequestParam("password") String password,Model m) {
	var a = urep.login(mail, password);
	if(a.get(5).equals(mail) && a.get(6).equals(password)) {
		session.setAttribute("password", password);
		session.setAttribute("uid", a.get(2));
		session.setAttribute("name", a.get(8));
		return "/";
	}else {
		return "login";
	}
	
}

}

