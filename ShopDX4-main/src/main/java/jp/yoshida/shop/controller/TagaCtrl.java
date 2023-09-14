package jp.yoshida.shop.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jp.yoshida.shop.entity.Merch;
import jp.yoshida.shop.repository.FavoItemsRepository;
import jp.yoshida.shop.repository.MerchRepository;

@Controller
public class TagaCtrl {
	@Autowired
	MerchRepository MRepo;
	FavoItemsRepository FavoRepo;
	
	@GetMapping	
	public String showList(Model model) {
		
		Iterable<Merch> list = MRepo.findAll();
		model.addAttribute("items",list);
		
		Iterable<String> categorySet = new HashSet<>();
        model.addAttribute("categorySet", categorySet);
        
        List<Merch> favoriteItems = new ArrayList<>();
        favoriteItems.add(MRepo.findByCode(34));
        favoriteItems.add(MRepo.findByCode(42));
        favoriteItems.add(MRepo.findByCode(198));
        model.addAttribute("favoriteItems", favoriteItems);
        
        List<Merch> ItemRanking = new ArrayList<>();
        ItemRanking.add(MRepo.findByCode(145));
        ItemRanking.add(MRepo.findByCode(75));
        ItemRanking.add(MRepo.findByCode(124));
        ItemRanking.add(MRepo.findByCode(122));
        ItemRanking.add(MRepo.findByCode(127));
        model.addAttribute("ItemRanking", ItemRanking);
        
		return "taga/Toppage";
		
	}
	
	@GetMapping("/category/{categoryName}")
    public String showCategoryItems(@PathVariable String categoryName, Model model) {
       
		Iterable<Merch> list = MRepo.findAll();
		model.addAttribute("items",list);
		
        List<Merch> categoryItems = MRepo.findByCategory(categoryName);
        model.addAttribute("categoryItems", categoryItems);
        
        Iterable<String> categorySet = new HashSet<>();
        model.addAttribute("categorySet", categorySet);
        
        List<Merch> favoriteItems = new ArrayList<>();
        favoriteItems.add(MRepo.findByCode(34));
        favoriteItems.add(MRepo.findByCode(42));
        favoriteItems.add(MRepo.findByCode(198));
        model.addAttribute("favoriteItems", favoriteItems);
        
        
        
        return "taga/categoryitems"; 
        
	}
	
	@GetMapping("/item/{itemCode}")
    public String showItemDetail(@PathVariable Integer itemCode, Model model) {
        
        Merch item = MRepo.findByCode(itemCode);
        model.addAttribute("item", item);
        return "taga/categoryitemdetail"; 
        
	}
	
	@GetMapping("favoriteitems")	
	public String favoitems(Model model) {
		
		Iterable<Merch> list = MRepo.findAll();
		model.addAttribute("items",list);
		
		Iterable<String> categorySet = new HashSet<>();
        model.addAttribute("categorySet", categorySet);
        
        List<Merch> favoriteItems = new ArrayList<>();
        favoriteItems.add(MRepo.findByCode(34));
        favoriteItems.add(MRepo.findByCode(42));
        favoriteItems.add(MRepo.findByCode(198));
        model.addAttribute("favoriteItems", favoriteItems);
        
		return "taga/favoriteitems";
		
	}
	
	@GetMapping("kiyaku")	
	public String kiyaku(Model model) {
		
		Iterable<Merch> list = MRepo.findAll();
		model.addAttribute("items",list);
		
		Iterable<String> categorySet = new HashSet<>();
        model.addAttribute("categorySet", categorySet);
        
        List<Merch> favoriteItems = new ArrayList<>();
        favoriteItems.add(MRepo.findByCode(34));
        favoriteItems.add(MRepo.findByCode(42));
        favoriteItems.add(MRepo.findByCode(198));
        model.addAttribute("favoriteItems", favoriteItems);
        
        List<Merch> ItemRanking = new ArrayList<>();
        ItemRanking.add(MRepo.findByCode(145));
        ItemRanking.add(MRepo.findByCode(75));
        ItemRanking.add(MRepo.findByCode(124));
        ItemRanking.add(MRepo.findByCode(122));
        ItemRanking.add(MRepo.findByCode(127));
        model.addAttribute("ItemRanking", ItemRanking);
        
		return "taga/kiyaku";
		
	}
	@GetMapping("other")	
	public String other(Model model) {
		
		Iterable<Merch> list = MRepo.findAll();
		model.addAttribute("items",list);
		
		Iterable<String> categorySet = new HashSet<>();
        model.addAttribute("categorySet", categorySet);
        
        List<Merch> favoriteItems = new ArrayList<>();
        favoriteItems.add(MRepo.findByCode(34));
        favoriteItems.add(MRepo.findByCode(42));
        favoriteItems.add(MRepo.findByCode(198));
        model.addAttribute("favoriteItems", favoriteItems);
        
        List<Merch> ItemRanking = new ArrayList<>();
        ItemRanking.add(MRepo.findByCode(145));
        ItemRanking.add(MRepo.findByCode(75));
        ItemRanking.add(MRepo.findByCode(124));
        ItemRanking.add(MRepo.findByCode(122));
        ItemRanking.add(MRepo.findByCode(127));
        model.addAttribute("ItemRanking", ItemRanking);
        
		return "taga/other";
		
	}

}
