package spring.service.impl;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.MD5Util;
import spring.domain.LoginInfo;
import spring.domain.UserInfo;
import spring.model.mapper.UserMapper;
import spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper UserMapper;

	@Override
	public UserInfo getUserByLoginId(String loginId) {
		return UserMapper.getUser(loginId);
	}

	@Override
	public boolean loginValidate(LoginInfo loginUser, HttpSession session) {
		if (StringUtils.isNotEmpty(loginUser.getLoginId())) {
			UserInfo user = getUserByLoginId(loginUser.getLoginId());
			// 未找到用户
			if (null == user)
				return false;

			if (user.getPassword().equals(MD5Util.textToMD5U16(loginUser.getPassword()))) {
				loginUser.setUserName(user.getUserName());
				// 将用户对象添加到Session中
				session.setAttribute("USER_SESSION", loginUser);
				return true;
			}
		}
		return false;
	}

}
