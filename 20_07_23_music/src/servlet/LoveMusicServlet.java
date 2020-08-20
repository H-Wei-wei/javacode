package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.User;
import service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loveMusicServlet")
public class LoveMusicServlet extends HttpServlet {

    // 添加音乐到喜欢列表
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Map<String, Object> return_map = new HashMap<>();

        String idStr = req.getParameter("id");
        Integer musicId = Integer.parseInt(idStr);

        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");

        MusicService musicService = new MusicService();
        boolean flg = musicService.insertLoveMusic(user.getId(), musicId);
        if (flg) {
            // 添加成功
            return_map.put("msg", true);
        }else {
            return_map.put("msg", false);
        }
        // 构造响应数据
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), return_map);
    }
}
