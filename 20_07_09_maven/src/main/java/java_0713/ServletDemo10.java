package java_0713;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;


@MultipartConfig        // 表示处理文件上传
public class ServletDemo10 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 收到图片保存到 G:/java/image/
        String basePath = "G:/java/image/";
        Part image = req.getPart("image");
        // getSubmittedFileName() 得到上传图片的文件名
        String path = basePath + image.getSubmittedFileName();
        image.write(path);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("图片上传成功！！！");
    }
}
