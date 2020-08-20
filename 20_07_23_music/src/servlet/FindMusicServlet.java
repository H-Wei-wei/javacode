package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Music;
import service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/findMusic")
public class FindMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");

        String muiscName = req.getParameter("musicName");

        MusicService musicService = new MusicService();
        List<Music> musicList = new ArrayList<>();
        if (muiscName != null) {
            // 模糊查询
            musicList = musicService.ifMusic(muiscName);
        }else {
            // 没找到就默认全部歌单
            musicList = musicService.findMusic();
        }

        // 构造响应数据
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), musicList);
    }
}
