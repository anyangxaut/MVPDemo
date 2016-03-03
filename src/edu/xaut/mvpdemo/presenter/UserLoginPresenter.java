package edu.xaut.mvpdemo.presenter;

import android.os.Handler;
import edu.xaut.mvpdemo.bean.UserBean;
import edu.xaut.mvpdemo.model.IOnLoginListener;
import edu.xaut.mvpdemo.model.IUserModel;
import edu.xaut.mvpdemo.model.UserModel;
import edu.xaut.mvpdemo.view.IUserLoginView;

/**
 * Presenter是用作Model和View之间交互的桥梁
 */
public class UserLoginPresenter {

	private IUserModel userModel;
    private IUserLoginView userLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView)
    {
        this.userLoginView = userLoginView;
        this.userModel = new UserModel();
    }

    public void login()
    {
        userLoginView.showLoading();
        userModel.login(userLoginView.getUserName(), userLoginView.getPassword(), new IOnLoginListener()
        {
            @Override
            public void loginSuccess(final UserBean user)
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });

            }

            @Override
            public void loginFailed()
            {
                //需要在UI线程执行
                mHandler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });

            }
        });
    }

    public void clear()
    {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }


}
