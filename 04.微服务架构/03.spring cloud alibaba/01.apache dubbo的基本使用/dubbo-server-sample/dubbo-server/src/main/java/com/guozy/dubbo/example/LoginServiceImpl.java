package com.guozy.dubbo.example;

public class LoginServiceImpl implements ILoginService {
    @Override
    public String login(String userName, String password) {
        if ("admin".equals(userName) && "admin".equals(password)) {
            return "登陆成功！";
        }
        return "登陆失败！";
    }
}
