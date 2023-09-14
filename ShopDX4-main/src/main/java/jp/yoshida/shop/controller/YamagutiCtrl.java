package jp.yoshida.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.yoshida.shop.MerchService;
import jp.yoshida.shop.entity.Cart;
import jp.yoshida.shop.entity.Merch;
import jp.yoshida.shop.repository.CartRepository;
import jp.yoshida.shop.repository.MerchRepository;

@Controller
public class YamagutiCtrl {
	@Autowired
	MerchService service;

	@Autowired
	private MerchRepository yaa;

	@ModelAttribute
	public Merch merch() {
		return new Merch();
	}

	@GetMapping("/yamaguti/itempage")
	public String itempage(Merch m) {
		return "/Yamaguti/itempage";
	}

	@Autowired
	private CartRepository haa;

	@PostMapping("/yamaguti/e")
	public String e(Merch m) {
		Cart cart = new Cart();
		cart.setCode(1);
		cart.setUid(1);
		cart.setBuynum(1);
		cart.setPrice(2480);
		cart.setName("【KANGOL×A.S.M コラボ】 USAコットン ／ オーバーサイズ ロゴ 刺繍 バックプリント Tシャツ KANGOL");
		haa.save(cart);
		return "/Yamaguti/e";
	}

	@GetMapping("/yamaguti/a")
	public String a(Merch m, Model model) {
		Iterable<Merch> list = service.selectAll();
		model.addAttribute("list", list);
		return "Yamaguti/dummy";
	}

	
	@PostMapping("/yamaguti/kousin")
	public String kousin(Model model,Merch m) {
		Iterable<Merch> a = service.selectAll();
		model.addAttribute("list", a);
		return "redirect:/yamaguti/a";
	}

	private Merch makeMerchForm(Merch merch) {
		Merch m = new Merch();
		m.setCode(merch.getCode());
		m.setName(merch.getName());
		m.setPrice(merch.getPrice());
		m.setCategory(merch.getCategory());
		m.setAttribute(merch.getAttribute());
		m.setStock(merch.getStock());
		m.setRegiday(merch.getRegiday());
		m.setUpdate(merch.getUpdate());
		m.setEos(merch.getEos());
		return merch;
	}

	@PostMapping("/a/delete")
	public String del(@RequestParam("code") Integer code, Merch m) {
		yaa.delete(code);
		return "redirect:/yamaguti/a";
	}

	@PostMapping("/yamaguti/b")
	public String b() {
		return "/Yamaguti/good";
	}

	@PostMapping("/yamaguti/henshu")
	public String henshu() {
		return "/Yamaguti/henshu";
	}

	@PostMapping("/yamaguti/update")
	public String update(Merch merch) {
		var m = new Merch();
		m.setCode(merch.getCode());
		m.setName(merch.getName());
		m.setPrice(merch.getPrice());
		m.setCategory(merch.getCategory());
		m.setAttribute(merch.getAttribute());
		m.setStock(merch.getStock());
		m.setRegiday(merch.getRegiday());
		m.setUpdate(merch.getUpdate());
		m.setEos(merch.getEos());
		yaa.save(m);
		return "/Yamaguti/good";
	}

	@PostMapping("/yamaguti/b1")
	public String b1(Merch m) {
		yaa.category(m.getCategory(), m.getCode());
		return "/Yamaguti/good";
	}

	@PostMapping("/yamaguti/b2")
	public String b2(Merch m) {
		Merch merch = new Merch();
		merch.setCode(m.getCode());
		merch.setStock(m.getStock());
		merch.setRegiday(m.getRegiday());
		merch.setCategory(m.getCategory());
		merch.setName(m.getName());
		yaa.save(merch);
		return "/Yamaguti/good";
	}

	@PostMapping("/yamaguti/b3")
	public String b3(Merch m) {
		yaa.plus(m.getStock(), m.getCode());
		return "/Yamaguti/good";
	}

	@GetMapping("/yamaguti/kategori")
	public String kategori(Merch m) {
		return "/Yamaguti/kategori";
	}

	@GetMapping("/yamaguti/date")
	public String date(Merch m) {
		return "/Yamaguti/date";
	}

	@GetMapping("/yamaguti/kensaku")
	public String kensaku(Merch m) {
		return "/Yamaguti/kensaku";
	}

	@PostMapping("/yamaguti/kensaku2")
	public String kensaku2(Merch m, Model model) {
		model.addAttribute("list", yaa.search(m.getCode()));
		return "/Yamaguti/kensaku2";
	}

	@PostMapping("/yamaguti/c")
	public String c(Merch m, Model model) {
		model.addAttribute("list", yaa.search(m.getCode()));
		return "Yamaguti/c";
	}

	@GetMapping("/yamaguti/zaiko")
	public String zaiko(Merch m) {

		return "/Yamaguti/zaiko";

	}


//	@GetMapping
//	public String showList(Merch a, Model model) {
//		Iterable<Merch> list = service.selectAll();
//		model.addAttribute("list", list);
//		return "Yamaguti/dummy";
//	}

	
//	@GetMapping
//	public String showList(Merch a , Model model) {
//		Iterable<Merch> list = service.selectAll();
//		model.addAttribute("list", list);
//		return "Yamaguti/dummy";
//	}


	@PostMapping("/insert")
	public String insert(@Validated Merch merch, BindingResult bindingResult,
			Model model, RedirectAttributes redirectAttributes) {
		var m = new Merch();
		m.setCode(merch.getCode());
		m.setName(merch.getName());
		m.setPrice(merch.getPrice());
		m.setCategory(merch.getCategory());
		m.setAttribute(merch.getAttribute());
		m.setStock(merch.getStock());
		m.setRegiday(merch.getRegiday());
		m.setUpdate(merch.getUpdate());
		m.setEos(merch.getEos());

		yaa.save(m);

		return "/Yamaguti/good";
	}
}