package spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.domain.LoginInfo;
import spring.service.UserService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {
		LoginInfo loginUser = (LoginInfo) session.getAttribute("USER_SESSION");
		String msg = "未登录";
		if (null != loginUser)
			msg = "欢迎：" + loginUser.getUserName();
		modelMap.put("msg", msg);
		return "index";
	}

	/**
	 * 向用户登录页面跳转
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin(ModelMap modelMap) {
		modelMap.put("user", new LoginInfo());
		return "login";
	}

	/**
	 * 用户登录
	 * 
	 * @param user
	 * @param modelMap
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginInfo loginUser, ModelMap modelMap, HttpSession session) {
		if (userService.loginValidate(loginUser, session)) {
			// 重定向到主页面的跳转方法
			return "redirect:index";
		}
		loginUser.setPassword(null);
		modelMap.addAttribute("msg", "用户名或密码错误，请重新输入！");
		modelMap.addAttribute("user", loginUser);
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		// 清除session
		session.invalidate();
		// 重定向到登录页面的跳转方法
		return "redirect:login";
	}

}
