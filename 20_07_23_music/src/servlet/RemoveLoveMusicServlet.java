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

@WebServlet("/removeLoveMusicServlet")
public class RemoveLoveMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Map<String, Object> return_map = new HashMap<>();
        // 只能删除喜欢列表中的音乐，不能删除 music 列表
        String idStr = req.getParameter("id");
        int musicId = Integer.parseInt(idStr);

        HttpSession httpSession = req.getSession(false);
        User user = (User) httpSession.getAttribute("user");

        MusicService musicService = new MusicService();
        int ret = musicService.removeLoveMusic(user.getId(), musicId);
        if (ret == 1) {
            return_map.put("msg", true);
            System.out.println("成功移除音乐");
        }else {
            return_map.put("msg", false);
        }
        // 构造响应数据
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), return_map);
    }
}
