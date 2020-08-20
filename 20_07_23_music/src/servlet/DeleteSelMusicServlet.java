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

@WebServlet("/deleteSelMusicServlet")
public class DeleteSelMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");

        Map<String, Object> return_map = new HashMap<>();
        MusicService musicService = new MusicService();

        String[] values = req.getParameterValues("id[]");
        int sum = 0;
        for (String idStr: values) {
            int id = Integer.parseInt(idStr);
            Music music = musicService.findMusicById(id);
            if (music == null) {
                System.out.println("音乐不存在");
                return;
            }
            // 若存在，删除该数据库音乐
            int ret = musicService.deleteMusicById(id);
            if (ret == 1) {
                // 仅表示数据库中的音乐删除了，服务器上的音乐还存在的
                // 删除服务器中的文件
                File file = new File("F:\\javacode_maven\\20_07_23_music\\web\\" + music.getUrl() + ".mp3");
                if (file.delete()) {
                    sum += ret;
                    //return_map.put("msg", true);
                    //System.out.println("服务器删除成功");
                }else {
                    return_map.put("msg", false);
                    System.out.println("服务器删除失败");
                }
            }else {
                return_map.put("msg", false);
                System.out.println("数据库删除失败");
            }
        }
        // 说明每一个都删除了
        if (sum == values.length) {
            return_map.put("msg", true);
        }else {
            return_map.put("msg", false);
        }
        // 构造响应数据
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), return_map);
    }
}
