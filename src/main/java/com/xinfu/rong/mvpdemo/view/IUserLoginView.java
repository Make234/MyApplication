package com.xinfu.rong.mvpdemo.view;

/**
 * Created by 22920 on 2017/5/8.
 */

public interface IUserLoginView {
    String getUserName();
    String getPassWord();
    void  clearUserName();
    void clearPassWord();
    void toSuccessActivity();
    void toFaildActivity();
    void showLoading();
    void hideLoading();
}
