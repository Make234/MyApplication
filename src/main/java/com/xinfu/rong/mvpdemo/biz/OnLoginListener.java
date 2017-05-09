package com.xinfu.rong.mvpdemo.biz;

import com.xinfu.rong.mvpdemo.bean.User;

/**
 * Created by 22920 on 2017/5/8.
 */

public interface OnLoginListener {
    void loginSuccess(User user);
    void failed();
}
