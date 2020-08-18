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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    Gson gson = new GsonBuilder().create();

    // 读取的 json 请求对象
    static class Request {
        public String name;
        public String password;
    }

    // 构造的 json 响应对象
    static class Response {
        public int ok;
        public String reason;
        public String name;
        public int isAdmin;
    }

    // 接口 2 ———— 登录
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Request request = new Request();
        Response response = new Response();
        try {
            // 1、读取请求中的数据
            String body = OrderSystemUtil.readBody(req);
            // 2、将读取的 body 数据转换成 response 对象
            request = gson.fromJson(body, Request.class);
            // 3、在数据库中查找该用户是否存在，并校验密码
            UserDao userDao = new UserDao();
            User user = userDao.selectByName(request.name);
            if (user == null || !user.getPassword().equals(request.password)) {
                throw new OrderSystemException("用户或密码错误");
            }
            // 4、如果登陆成功，就创建 session 对象
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("user", user);
            response.ok = 1;
            response.reason = "";
            response.name = user.getName();
            response.isAdmin = user.getIsAdmin();
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            // 5.若正确，构造响应数据
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    // 接口 3 ———— 检测登录状态
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Request request = new Request();
        Response response = new Response();
        try {
            // 1.获取当前用户的 session ，如果不存在，就未登录
            HttpSession httpSession = req.getSession(false);
            if (httpSession == null) {
                throw new OrderSystemException("当前未登录");
            }
            // 2.若存在，就从 session 对象中获取 user 对象
            User user = (User) httpSession.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("当前未登录");
            }
            // 3.将 user 对象中的信息填充到响应中去
            response.ok = 1;
            response.reason = "";
            response.name = user.getName();
            response.isAdmin = user.getIsAdmin();
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            // 4.构造响应数据
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
