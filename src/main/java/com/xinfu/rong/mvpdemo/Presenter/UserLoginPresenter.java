package com.xinfu.rong.mvpdemo.Presenter;

import android.os.Handler;

import com.xinfu.rong.mvpdemo.bean.User;
import com.xinfu.rong.mvpdemo.biz.IUserBiz;
import com.xinfu.rong.mvpdemo.biz.OnLoginListener;
import com.xinfu.rong.mvpdemo.biz.UserBiz;
import com.xinfu.rong.mvpdemo.view.IUserLoginView;


/**
 * Created by 22920 on 2017/5/8.
 */

public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler handler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassWord(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toSuccessActivity();
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void failed() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toFaildActivity();
                        userLoginView.hideLoading();
                    }
                });
            }
        });
    }

    public void clear(){
        userLoginView.clearPassWord();
        userLoginView.clearUserName();
    }
}
