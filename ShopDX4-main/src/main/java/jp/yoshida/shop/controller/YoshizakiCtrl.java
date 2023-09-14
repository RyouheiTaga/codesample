package jp.yoshida.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.yoshida.shop.entity.Users;
import jp.yoshida.shop.repository.UsersRepository;

@Controller
public class YoshizakiCtrl {
	
	@Autowired
	private UsersRepository usersRepository;

	@GetMapping("/login")
	public String loginView(Model model) {
		return "yoshizaki/login";
	}

	@GetMapping("kanryo")
	public String kanryoView() {
		return "yoshizaki/kanryo";
	}

	@GetMapping("/user")
	public String userView(Model model) {
		Users user = usersRepository.findById(1).orElse(new Users()); // 1はユーザーIDの例

		model.addAttribute("id", user.getUid());
		model.addAttribute("sei", user.getSei());
		model.addAttribute("sei2", user.getSei2());
		model.addAttribute("birthday", user.getBirthdate());
		model.addAttribute("meado", user.getMail());
		model.addAttribute("tel", user.getTell());
		model.addAttribute("post", user.getPost());
		model.addAttribute("addr", user.getAddr());
		model.addAttribute("pass", user.getPassword());
		model.addAttribute("user", user);

		return "yoshizaki/user";
	}

	@GetMapping("shinki")
	public String userjouhouView(Model model) {
		model.addAttribute("user", new Users());
		return "yoshizaki/shinki";
	}

	@PostMapping("/users")
	public String submitFrom(@ModelAttribute Users user) {
		usersRepository.save(user);
		return "redirect:/user";
	}

	@GetMapping("passs")
	public String passsView(Model model) {
		Users user = usersRepository.findById(1).orElse(new Users());

		model.addAttribute("pas", user.getUid());
		model.addAttribute("user", user);

		if (user != null) {
			model.addAttribute("passs", user);
		} else {
			model.addAttribute("errorMessage", "ユーザー情報が見つかりません。");
		}

		return "yoshizaki/passs";
	}

	@PostMapping("/passs")
	public String submitFrom2(@ModelAttribute Users user, Model model) {
	    Users existingUser = usersRepository.findById(1).orElse(null); // 1はユーザーIDの例

	    if (existingUser != null) {
	        existingUser.setPassword(user.getPassword()); // 新しいパスワードを設定
	        usersRepository.save(existingUser); // パスワードをデータベースに保存
	        return "redirect:/user";
	    } else {
	        model.addAttribute("errorMessage", "ユーザー情報が見つかりません。");
	        return "yoshizaki/passs";
	    }
	}

	@GetMapping("/userjouhou")
	public String userView4(Model model) {
		Users user = usersRepository.findById(1).orElse(new Users());

		model.addAttribute("id", user.getUid());
		model.addAttribute("sei", user.getSei());
		model.addAttribute("sei2", user.getSei2());
		model.addAttribute("mei", user.getMei()); // 追加
		model.addAttribute("mei2", user.getMei2()); // 追加
		model.addAttribute("birthday", user.getBirthdate());
		model.addAttribute("meado", user.getMail());
		model.addAttribute("tel", user.getTell());
		model.addAttribute("post", user.getPost());
		model.addAttribute("addr", user.getAddr());
		model.addAttribute("user", user);

		return "yoshizaki/userjouhou";
	}

	@PostMapping("/userjouhou")
	public String submitUserjouhouForm(@ModelAttribute Users user) {
		usersRepository.save(user);
		return "redirect:/userjouhou";
	}

	@GetMapping("/users")
	public String getUsersView(@ModelAttribute Users user) {
		usersRepository.save(user);
		return "userjouhou";
	}
}
