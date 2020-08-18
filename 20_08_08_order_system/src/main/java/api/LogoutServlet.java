package api;

import assist.OrderSystemException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    Gson gson = new GsonBuilder().create();

    // 构造 JSON 响应
    static class Response {
        public int ok;
        public String reason;
    }

    // 接口 4 ———— 注销
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        try {
            // 1.根据 sessionId 找出对应的 session 对象
            HttpSession httpSession = req.getSession(false);
            if (httpSession == null) {
                throw new OrderSystemException("未登录");
            }
            // 2. 把 session 对象中存的 user 信息给删掉即可(直接删掉 session 中的对应的键值对也行).
            httpSession.removeAttribute("user");
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            // 构造响应数据
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }

    }
}
