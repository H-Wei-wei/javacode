package api;

import assist.OrderSystemException;
import assist.OrderSystemUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DishDao;
import modal.Dish;
import modal.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dish")
public class DishServlet extends HttpServlet {
    Gson gson = new GsonBuilder().create();

    // 请求的 JSON 数据
    static class Request {
        public String name;
        public int price;
    }

    // 响应的 Json 数据
    static class Response {
        public int ok;
        public String reason;
    }

    // 接口5 ———— 新增菜品
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Request request = new Request();
        Response response = new Response();
        try {
            // 1.根据 session 来判断用户登录状态
            HttpSession httpSession = req.getSession(false);
            if (httpSession == null) {
                throw new OrderSystemException("用户未登录");
            }
            User user = (User)httpSession.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("用户未登录");
            }
            // 2.判断当前用户是否是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("您不是管理员");
            }
            // 3.读取请求中的数据
            String body = OrderSystemUtil.readBody(req);
            // 4.将 body 中的数据转换成 request 对象
            request = gson.fromJson(body, Request.class);
            // 5.新增菜品到数据库中
            DishDao dishDao = new DishDao();
            Dish dish = new Dish();
            dish.setName(request.name);
            dish.setPrice(request.price);
            dishDao.addDish(dish);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            // 6.构造响应数据
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    // 接口6 ———— 删除菜品
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        try {
            // 1.根据 session 判断用户登录状态
            HttpSession httpSession = req.getSession(false);
            if (httpSession == null) {
                throw new OrderSystemException("用户未登陆");
            }
            User user = (User) httpSession.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("用户未登录");
            }
            // 2.判断用户是否是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("您不是管理员");
            }
            // 3.读取到 dishId
            String dishStr = req.getParameter("dishId");
            if (dishStr == null) {
                throw new OrderSystemException("dishId参数不正确");
            }
            int dishId = Integer.parseInt(dishStr);
            // 4.从数据库中删除菜品
            DishDao dishDao = new DishDao();
            dishDao.deleteById(dishId);
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

    // 接口7 ——— 查看所有菜品列表
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        List<Dish> dishes = new ArrayList<>();
        try {
            // 1.查看用户登录状态
            HttpSession httpSession = req.getSession(false);
            if (httpSession == null) {
                throw new OrderSystemException("用户未登陆");
            }
            // 2.根据 session 获取 user 对象
            User user = (User) httpSession.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("用户未登录");
            }
            // 3.从数据库中查找
            DishDao dishDao = new DishDao();
            dishes = dishDao.selectAll();
            // 4.构造响应数据
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        } catch (OrderSystemException e) {
            // 失败的时候返回一个空的数组.
            String jsonString = gson.toJson(dishes);
            resp.getWriter().write(jsonString);
        }
    }
}
