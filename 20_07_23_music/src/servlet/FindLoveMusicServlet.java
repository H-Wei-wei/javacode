package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/findLoveMusicServlet")
public class FindLoveMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        List<Music> musicList = new ArrayList<>();

        String loveMusicName = req.getParameter("loveMusicName");

        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            System.out.println("用户未登录");
            return;
        }

        MusicService musicService = new MusicService();
        if (loveMusicName != null) {
            musicList = musicService.ifMusicLove(loveMusicName, user.getId());
            System.out.println("添加成功");
        }else {
            musicList = musicService.findLoveMusic(user.getId());
        }
        // 构造响应数据
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), musicList);
    }
}
