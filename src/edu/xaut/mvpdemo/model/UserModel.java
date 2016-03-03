package edu.xaut.mvpdemo.model;

import edu.xaut.mvpdemo.bean.UserBean;

public class UserModel implements IUserModel {

	@Override
	public void login(final String username, final String password,
			final IOnLoginListener loginListener) {
		//模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("zhy".equals(username) && "123".equals(password))
                {
                    UserBean user = new UserBean();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
		
	}

}
