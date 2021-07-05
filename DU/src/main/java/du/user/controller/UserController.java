package du.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import du.user.domain.UserVO;
import du.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/userInfo.do")
	public String userInfoPage() {
		return "user/userInfo.jsp";
	}
	
	@RequestMapping("/userModify.do")
	public String userModify(@ModelAttribute UserVO user) {
		userService.updateUser(user);
		
		return "redirect:/logout.do";
	}

	@RequestMapping("/signUpPage.do")
	public String signUpPage() {
		return "user/signUp.jsp";
	}
	
	@RequestMapping("/signUp.do")
	public String signUp(@ModelAttribute UserVO user) {
		userService.insertUser(user);
		
		return "redirect:/login.do";
	}

	@RequestMapping("/userDelete.do")
	public String userDelete(HttpSession session) {
		userService.deleteUser(session);
		
		return "redirect:/login.do";
	}
	
}
