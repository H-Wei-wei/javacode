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
    }

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
            // 3、在数据库中查找该用户是否存在，（若不存在，提示用户未注册）
            UserDao userDao = new UserDao();
            User exitUser = userDao.selectByName(request.name);
            if (exitUser == null) {
                throw new OrderSystemException("该用户不存在");
            }
            // 4、若存在，将数据库中的数据与该请求数据进行校验
            User user = userDao.selectByName(request.name);
            if (user.getPassword() != request.password) {
                throw new OrderSystemException("用户密码错误");
            }
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = 
        } finally {
        }
        // 5.若正确，构造响应数据
    }
}
