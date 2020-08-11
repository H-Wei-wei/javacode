package TestUserDao;

import model.User;
import model.UserDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void addUser() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("123");
        user.setPassword("123");
        userDao.addUser(user);
    }

    @Test
    public void selectByName() {
        UserDao userDao = new UserDao();
        String name = "hw";
        System.out.println(userDao.selectByName(name));
    }

    @Test
    public void selectById() {
        UserDao userDao = new UserDao();
        int id = 3;
        System.out.println(userDao.selectById(id));
    }
}