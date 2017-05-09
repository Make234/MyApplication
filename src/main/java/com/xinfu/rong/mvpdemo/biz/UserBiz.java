package com.xinfu.rong.mvpdemo.biz;

import com.xinfu.rong.mvpdemo.bean.User;

/**
 * Created by 22920 on 2017/5/8.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String name, final String passWord, final OnLoginListener loginListener) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               if (name.equals("doubi")&&passWord.equals("123456")){
                   User user = new User();
                   user.setName(name);
                   user.setPassWord(passWord);
                   loginListener.loginSuccess(user);
               }else {
                   loginListener.failed();
               }
           }
       }).start();
    }
}
