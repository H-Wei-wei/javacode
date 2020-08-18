package api;

import assist.OrderSystemException;
import assist.OrderSystemUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.OrderDao;
import modal.Dish;
import modal.Order;
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

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    Gson gson = new GsonBuilder().create();

    static class Response {
        public int ok;
        public String reason;
    }

    // 接口 8 ———— 新增订单 （菜品id数组，如[2,4,5]）
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        try {
            // 1.查看登录状态
            HttpSession httpSession = req.getSession(false);
            if (httpSession == null) {
                throw new OrderSystemException("用户未登录");
            }
            User user = (User) httpSession.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("用户未登录");
            }
            // 2.判断当前用户是否是普通用户
            if (user.getIsAdmin() == 1) {
                throw new OrderSystemException("您是管理员，不能下单");
            }
            // 3.读取请求中的数据
            String body = OrderSystemUtil.readBody(req);
            // 4.将 body 中数据解析成 response 对象
            Integer[] dishIds = gson.fromJson(body,Integer[].class);
            // 5.构造 order 对象
            Order order = new Order();
            order.setUserId(user.getUserId());
            List<Dish> dishes = new ArrayList<>();
            for (Integer dishId: dishIds) {
                Dish dish = new Dish();
                dish.setDishId(dishId);
                dishes.add(dish);
            }
            order.setDishes(dishes);
            // 6.将 order 对象插入到数据库中
            OrderDao orderDao = new OrderDao();
            orderDao.add(order);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    // 接口 9 ———— 查看订单 (管理查看所有订单，普通用户查看自己的订单)
    // 接口 10 ———— 查看指定订单
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        List<Order> orders = new ArrayList<>();
        try {
            // 1.查看用户登陆状态
            HttpSession httpSession = req.getSession(false);
            if (httpSession == null) {
                throw new OrderSystemException("用户未登录");
            }
            User user = (User) httpSession.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("用户未登录");
            }
            // 请求中读取 orderId 字段， 看此字段是否存在
            OrderDao orderDao = new OrderDao();
            String orderIdStr = req.getParameter("orderId");
            if (orderIdStr == null) {
                // 2.判断用户身份
                if (user.getIsAdmin() == 1) {
                    // 3.如果是管理员，查看所有订单
                    orders = orderDao.selectAll();
                }else {
                    // 4.如果是普通用户，只能查看自己的订单
                    orders = orderDao.selectByUserId(user.getUserId());
                }
                // 5.构造响应结果
                String jsonString = gson.toJson(orders);
                resp.getWriter().write(jsonString);
            }else {
                // 查看指定订单详情
                // 1.查看数据库，查找指定订单
                int dishId = Integer.parseInt(orderIdStr);
                Order order = orderDao.selectById(dishId);
                if (user.getIsAdmin() == 0 && order.getUserId() != user.getUserId()) {
                    throw new OrderSystemException("您无法查看其他人订单");
                }
                // 2.构造响应结果
                String jsonString = gson.toJson(order);
                resp.getWriter().write(jsonString);
            }
        } catch (OrderSystemException e) {
            String jsonString = gson.toJson(orders);
            resp.getWriter().write(jsonString);
        }
    }

    // 接口 11 ———— 修改订单状态
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        try {
            // 1.查看用户登录状态
            HttpSession httpSession = req.getSession(false);
            if (httpSession == null) {
                throw new OrderSystemException("用户未登录");
            }
            User user = (User) httpSession.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("用户未登录");
            }
            // 2.判断当前用户是否是管理员
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("您不是管理员");
            }
            // 3.读取请求中的 orderId 和 isDone 字段
            String orderIdStr = req.getParameter("orderId");
            String isDoneStr = req.getParameter("isDone");
            if (orderIdStr == null || isDoneStr == null) {
                throw new OrderSystemException("参数有误");
            }
            int orderId = Integer.parseInt(orderIdStr);
            int isDone = Integer.parseInt(isDoneStr);
            // 4.修改订单状态
            OrderDao orderDao = new OrderDao();
            orderDao.changeState(orderId, isDone);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
}
