package servlet;

import entity.Music;
import entity.User;
import service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 上传到数据库
@WebServlet("/uploadsucess")
public class Uploadsucess extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        String singer = req.getParameter("singer");

        String fieName = (String)req.getSession(false).getAttribute("fileName");
        String[] strings = fieName.split("\\.");
        String title = strings[0];
        // 日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(new Date());

        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");
        int userId = user.getId();

        String url = "music/" + title;

        MusicService musicService = new MusicService();
        int ret = musicService.insert(title, singer, time, url, userId);
        if (ret == 1) {
            System.out.println("插入音乐成功");
            resp.sendRedirect("list.html");
        }
    }
}
