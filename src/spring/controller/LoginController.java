package spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.domain.UserInfo;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {
		UserInfo user = (UserInfo) session.getAttribute("USER_SESSION");
		String msg = "未登录";
		if (null != user)
			msg = "欢迎：" + user.getUserName();
		modelMap.put("msg", msg);
		return "index";
	}

	/**
	 * 向用户登录页面跳转
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String toLogin(ModelMap modelMap) {
		modelMap.put("user", new UserInfo());
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
	public String login(UserInfo user, ModelMap modelMap, HttpSession session) {
		// 获取用户名和密码
		String loginId = user.getLoginId();
		String password = user.getPassword();
		// 些处横板从数据库中获取对用户名和密码后进行判断
		if (loginId != null && loginId.equals("admin") && password != null && password.equals("admin")) {
			// 将用户对象添加到Session中
			session.setAttribute("USER_SESSION", user);
			// 重定向到主页面的跳转方法
			return "redirect:index";
		}
		modelMap.addAttribute("msg", "用户名或密码错误，请重新登录！");
		user.setPassword(null);
		modelMap.addAttribute("user", user);
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
