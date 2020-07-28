package api;

import model.Article;
import model.ArticleDao;
import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        // 1.验证用户是否已经登录，如果没有登录，就提示要先登录
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            String html = HtmlGenerator.getMessagePage("请先登录",
                    "login.html");
            resp.getWriter().write(html);
            return;
        }
        User user = (User) httpSession.getAttribute("user");
        // 2.判断请求中是否存在 articleId 参数
        String articleIdStr = req.getParameter("articleId");
        if (articleIdStr == null) {
            // a:没有这个参数就去执行获取文章列表操作
            getAllArticle(user, resp);
        }else {
            // b:有这个参数就去执行获取文章详情操作
            getOneArticle(Integer.parseInt(articleIdStr), user,resp);
        }
    }

    private void getOneArticle(int articleId, User user, HttpServletResponse resp) throws IOException {
        // 1.查找数据库
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(articleId);
        if (article == null) {
            // 文章未找到
            String html = HtmlGenerator.getMessagePage("文章未找到","article");
            resp.getWriter().write(html);
            return;
        }
        // 2.根据文章获得作者 id 找到作者信息，进一步得到作者姓名
        UserDao userDao = new UserDao();
        User author = userDao.selectById(article.getUserId());
        // 3、构造页面
        String html = HtmlGenerator.getArticleDetailPage(article,user, author);
        resp.getWriter().write(html);
    }

    private void getAllArticle(User user, HttpServletResponse resp) throws IOException {
        // 1.查找数据库
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectALL();
        // 2.构造页面
        String html = HtmlGenerator.getArticleListPage(articles, user);
        resp.getWriter().write(html);
    }

    // 实现新增文章
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        // 1.判断用户的登陆情况
        HttpSession httpSession = req.getSession(false);
        if (httpSession == null) {
            // 未登录
            String html = HtmlGenerator.getMessagePage("用户未登录",
                    "login.html");
            resp.getWriter().write(html);
            return;
        }
        //已登录,就根据 session 得到 User 信息
        User user = (User) httpSession.getAttribute("user");
        // 2.从请求中读取到浏览器提交的数据（title ，content），并进行简单的校验
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title == null || "".equals(title)
            || content == null || "".equals(content)) {
            String html = HtmlGenerator.getMessagePage("你提交的标题或内容为空",
                    "article");
            resp.getWriter().write(html);
            return;
        }
        // 3.把数据插入到数据库中
        ArticleDao articleDao = new ArticleDao();
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setUserId(user.getUserId());
        articleDao.add(article);
        // 4.返回一个文章发布成功页面
        String html = HtmlGenerator.getMessagePage("发布成功","article");
        resp.getWriter().write(html);
        return;
    }
}
