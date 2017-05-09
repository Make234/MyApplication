package com.xinfu.rong.mvpdemo.biz;

/**
 * Created by 22920 on 2017/5/8.
 */

public interface IUserBiz {
    public void login(String name,String passWord,OnLoginListener loginListener);
}
