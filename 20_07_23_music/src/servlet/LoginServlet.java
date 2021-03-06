package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Map<String, Object> return_map = new HashMap<>();
        // 1.读取请求中的数据
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        // 2.根据输入构造 User 对象
        User loginUser = new User();
        loginUser.setUsername(userName);
        loginUser.setPassword(password);
//        System.out.println(userName + ":" + password);
        // 3.登录用户
        UserService userService = new UserService();
        User user = userService.login(loginUser);

        if (user != null) {
            System.out.println("登录成功");
            return_map.put("msg", true);
            req.getSession(true).setAttribute("user",user);
        }else {
            System.out.println("登录失败");
            return_map.put("msg", false);
        }
        // 构造响应数据
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), return_map);
    }
}
