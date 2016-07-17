/**
 * @author liuzhuanghong
 */
package com.steven.tutorial.web.action.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

/**
 * 回调函数WsAuthHandler校验客户端请求是否合法 ，合法就放行，否则拒绝执行任何操作
 * 
 * @author liuzhuanghong
 *
 */
public class WsAuthHandler implements CallbackHandler {

	private static final Map<String, String> userMap = new HashMap<String, String>();

	/*
	 * 提供了两个用户，分别是 client 与 server，用户名与密码存放在 userMap 中。这里需要将 JDK 提供的
	 * javax.security.auth.callback.Callback 转型为 WSS4J 提供的
	 * org.apache.wss4j.common.ext.WSPasswordCallback，在 handle
	 * 方法中实现对客户端密码的验证，最终需要将密码放入 callback 对象中。
	 */

	static {
		userMap.put("client", "clientpass");
		userMap.put("server", "serverpass");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.security.auth.callback.CallbackHandler#handle(javax.security.auth.
	 * callback.Callback[])
	 */
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];
		String clientUsername = callback.getIdentifier();
		String serverPassword = userMap.get(clientUsername);

		if (serverPassword != null) {
			callback.setPassword(serverPassword);
		}

	}

}
