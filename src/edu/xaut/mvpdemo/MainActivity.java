package edu.xaut.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import edu.xaut.mvpdemo.bean.UserBean;
import edu.xaut.mvpdemo.presenter.UserLoginPresenter;
import edu.xaut.mvpdemo.view.IUserLoginView;

public class MainActivity extends ActionBarActivity implements IUserLoginView {

	private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;
    
    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initViews();
    }

    private void initViews()
    {
        mEtUsername = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);

        mBtnClear = (Button) findViewById(R.id.id_btn_clear);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);

        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.login();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mUserLoginPresenter.clear();
            }
        });
    }
    

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return mEtUsername.getText().toString();
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return mEtPassword.getText().toString();
	}


	@Override
	public void clearUserName() {
		// TODO Auto-generated method stub
		mEtUsername.setText("");
	}


	@Override
	public void clearPassword() {
		// TODO Auto-generated method stub
		mEtPassword.setText("");
	}


	@Override
	public void showLoading() {
		// TODO Auto-generated method stub
		mPbLoading.setVisibility(View.VISIBLE);
	}


	@Override
	public void hideLoading() {
		// TODO Auto-generated method stub
		mPbLoading.setVisibility(View.GONE);
	}


	@Override
	public void toMainActivity(UserBean user) {
		// TODO Auto-generated method stub
		Toast.makeText(this, user.getUsername() +
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
	}


	@Override
	public void showFailedError() {
		// TODO Auto-generated method stub
		 Toast.makeText(this,
	                "login failed", Toast.LENGTH_SHORT).show();
	}

}
