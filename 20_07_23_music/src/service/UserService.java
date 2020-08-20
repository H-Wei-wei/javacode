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
    public int register (User user) {
        UserDao userDao = new UserDao();
        int ret = userDao.insertUser(user);
        if (ret == 1) {
            return 1;
        }else {
            return 0;
        }
    }

//    public static void main(String[] args) {
//        UserService userService = new UserService();
//        User user = new User();
//        user.setAge(10);
//        user.setGender("女");
//        user.setEmail("2345678901@qq.com");
//        userService.register(user);
//    }
}

