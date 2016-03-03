package edu.xaut.mvpdemo.model;

import edu.xaut.mvpdemo.bean.UserBean;

/**
 * 回调接口
 * @author anyang
 *
 */
public interface IOnLoginListener {

	void loginSuccess(UserBean user);

    void loginFailed();
}
