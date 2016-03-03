package edu.xaut.mvpdemo.view;

import edu.xaut.mvpdemo.bean.UserBean;

/**
 * Presenter与View交互接口
 * @author anyang
 *
 */
public interface IUserLoginView {

	 public String getUserName();

	 public String getPassword();

	 public void clearUserName();

	 public void clearPassword();

	 public void showLoading();

	 public void hideLoading();

	 public void toMainActivity(UserBean user);

	 public void showFailedError();
}
