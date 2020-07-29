package api;

import model.Article;
import model.ArticleDao;
import model.User;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        // 1.验证用户登录状态，如果未登录，就不能删除，并跳转到登录页面
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            String html = HtmlGenerator.getMessagePage("用户未登录","login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) httpSession.getAttribute("user");
        // 2.读取请求内容，获取到要删除文章的 ID
        String articleStr = req.getParameter("articleId");
        if (articleStr == null || "".equals(articleStr)) {
            String html = HtmlGenerator.getMessagePage("要删除的文章不存在", "article");
            resp.getWriter().write(html);
            return;
        }
        // 3.根据文章 ID 查找该文章的作者，如果该用户是作者的话，才可以删除
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(Integer.parseInt(articleStr));
        if (article.getUserId() != user.getUserId()) {
            String html = HtmlGenerator.getMessagePage("你只能删除自己的文章", "article");
            resp.getWriter().write(html);
            return;
        }
        // 4.删除操作
        articleDao.deleteBy(Integer.parseInt(articleStr));
        // 5.返回一个删除成功页面
        String html = HtmlGenerator.getMessagePage("删除成功", "article");
        resp.getWriter().write(html);
        return;
    }
}
