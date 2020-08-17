package api;

import assist.OrderSystemException;
import assist.OrderSystemUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.UserDao;
import modal.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    // 读取的 JSON 请求对象
    static class Request {
        public String name;
        public String password;
    }

    // 构造的 JSON 的响应对象
    static class Response {
        public int ok;
        public String reason;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Request request = new Request();
        Response response = new Response();
        try {
            // 1.读取请求中的数据
            String body = OrderSystemUtil.readBody(req);
            // 2.把 body 中的数据(json字符串)解析成 request 对象
            request = gson.fromJson(body, Request.class);
            // 3.查询数据库，看当前用户是否存在（若存在，就提示该用户已被注册送）
            UserDao userDao = new UserDao();
            User exitUser = userDao.selectByName(request.name);
            if (exitUser != null) {
                throw new OrderSystemException("当前用户已存在");
            }
            // 4.若不存在就把该数据构造成 USer 对象 ，插入到数据库中
            User user = new User();
            user.setName(request.name);
            user.setPassword(request.password);
            user.setIsAdmin(0);
            userDao.addUser(user);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            // 5.构造响应数据
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
