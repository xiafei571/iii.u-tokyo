package spring.service;

import javax.servlet.http.HttpSession;

import spring.domain.LoginInfo;
import spring.domain.UserInfo;

public interface UserService {

	UserInfo getUserByLoginId(String loginId);

	boolean loginValidate(LoginInfo user, HttpSession session);
}
