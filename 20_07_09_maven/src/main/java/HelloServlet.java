import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 无论请求是啥，响应都是hello servlet
        //把一个字符串写到 http 响应的 body 中
        resp.getWriter().write("<h1>hello servlet</h1>");
    }
}
