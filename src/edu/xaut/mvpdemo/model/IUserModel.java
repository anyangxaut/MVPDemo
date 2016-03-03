package edu.xaut.mvpdemo.model;

/**
 * 业务方法
 * @author anyang
 *
 */
public interface IUserModel {

	public void login(String username, String password, IOnLoginListener loginListener);
}
