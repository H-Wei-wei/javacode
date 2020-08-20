package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Music;
import service.MusicService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Map<String, Object> return_map = new HashMap<>();

        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        MusicService musicService = new MusicService();
        // 需判断当前音乐是否存在
        Music music = musicService.findMusicById(id);
        if (music == null) {
            System.out.println("音乐不存在");
            return;
        }
        // 若存在，删除该数据库音乐
        int ret = musicService.deleteMusicById(id);
        if (ret == 1) {
            System.out.println("删除成功");
            // 仅表示数据库中的音乐删除了，服务器上的音乐还存在的
            // 删除服务器中的文件
            File file = new File("F:\\javacode_maven\\20_07_23_music\\web\\" + music.getUrl() + ".mp3");
            if (file.delete()) {
                // 删除成功，提示删除成功
                return_map.put("msg", true);
                System.out.println("服务器删除成功");
            }else {
                return_map.put("msg", false);
                System.out.println("服务器删除失败");
            }
        }else {
            return_map.put("msg", false);
            System.out.println("数据库删除失败");
        }
        // 构造响应数据
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), return_map);
    }
}
