package service;

import dao.UserDao;
import entity.User;

public class UserService {
    // 登录
    public User login(User loginUser) {
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);
        return user;
    }

    // 注册
    public void register (User user) {
        UserDao userDao = new UserDao();
        int ret = userDao.insertUser(user);
        if (ret == 1) {
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }
}

