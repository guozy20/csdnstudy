package com.guozy.dubbo.example;

public class LoginServiceImpl implements ILoginService {
    @Override
    public String login(String username, String password) {

        if ("admin".equals(username) && "admin".equals(password)) {
            return "登录成功";
        } else {
            return "登录失败";
        }

    }
}
