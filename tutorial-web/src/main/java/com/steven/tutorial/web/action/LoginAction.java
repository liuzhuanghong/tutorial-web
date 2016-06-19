package com.steven.tutorial.web.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.steven.tutorial.web.domain.LoginUser;
import com.steven.tutorial.web.service.LoginUserService;

/**
 * 登录Action
 * 
 * @author liuzhuanghong
 *
 */
@Controller("login")
public class LoginAction {
	
    @Autowired
    private LoginUserService userService;
	/**
	private static Map<String, String> userMap = new HashMap<String, String>();
	static {
		userMap.put("liu", "123");
		userMap.put("yang", "456");
	}
	*/

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String authority() {
        LoginUser user = new LoginUser();
        user.setUsername(username);
        user.setPassword(password);
        
        if(userService.getUserNum(user) > 0 )
        {
            return "success";
        }
        
        return "error";
	}
}
