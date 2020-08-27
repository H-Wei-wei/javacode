package dao;

import assist.OrderSystemException;
import modal.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void addUser() throws OrderSystemException {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("xiaoming");
        user.setPassword("1212");
        user.setIsAdmin(0);
        userDao.addUser(user);
    }

    @Test
    public void selectByName() throws OrderSystemException {
        UserDao userDao = new UserDao();
        User user = userDao.selectByName("xiaoming");
        System.out.println(user);
    }

    @Test
    public void selectById() throws OrderSystemException {
        UserDao userDao = new UserDao();
        User user = userDao.selectById(2);
        System.out.println(user);

    }
}