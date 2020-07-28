package view;

import model.Article;
import model.User;

import java.util.List;

/**
 * 实际开发过程中还有更科学的方法：
 * 1.服务器渲染页面，把业务代码嵌入到 HTML ，（JSP，PHP）
 * 2.服务器渲染页面，把 HTML 嵌入到业务代码中，不适用字符串拼接的方式
 *      而是使用模板的方式（FreeMarker）
 * 3.前端渲染页面，通过前后端分离的方式，服务器只是返回简单数据，前端代码通过代码 JS
 *      构造页面内容
 */

public class HtmlGenerator {
    // 通过字符串拼装的形式，构造一个 HTML 格式的内容
    // 参数一：提示信息； 参数二：要跳转到的页面
    public static String getMessagePage(String message, String nextUrl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");

        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("</head>");

        stringBuilder.append("<body>");

        stringBuilder.append("<h3>");
        stringBuilder.append(message);
        stringBuilder.append("</h3>");

        stringBuilder.append(String.format("<a href = \"%s\">点击这里进行跳转 </a>", nextUrl));

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    // 字符串拼装
    public static String getArticleListPage(List<Article> articles, User user) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");

        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        // 标签内写 CSS 的逻辑
        stringBuilder.append("a {" +
                "color: #333;"+
                "text-decoration: none;"+
                "}");
        stringBuilder.append("a:hover {" +
                "color: white;" +
                "background-color: orange;" +
                "}");
        stringBuilder.append("body {" +
                "background-image: url(\"https://www.2008php.com/2011_Website_appreciate/2011-09-26/20110926182827.jpg\");" +
                "background-repeat:none;"+
                "background-position:0 center;"+
                "}");
        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<h3> 欢迎你" + user.getName() + "</h3>");
        stringBuilder.append("<hr>");
        // 要有一个文章列表，显示每个文章的标题
        for (Article article: articles) {
            stringBuilder.append(String.format("<div style=\"width:200px; height:50px; line-height:50px\"> <a href=\"article?articleId=%d\"> %s </a> </div>",
                    article.getArticleId(), article.getTitle()));
        }
        stringBuilder.append(String.format("<hr>"));
        stringBuilder.append(String.format("<div> 当前共有博客 %d 篇</div>", articles.size()));
        stringBuilder.append("<br>");

        //新增发布文章的区域
        stringBuilder.append("<div> 发布文章</div>");
        stringBuilder.append("<form method=\"POST\" action= \"article\">");
        stringBuilder.append("<input type=\"text\"  style=\"margin-bottom=5px\" name=\"title\" placeholder=\"请输入标题\">");
        stringBuilder.append("<br>");
        stringBuilder.append("<textarea name=\"content\" style=\"width: 500px; height=300px; margin-bottom=5px\"></textarea>");
        stringBuilder.append("<br>");
        stringBuilder.append("<input type=\"submit\" value=\"发布文章\">");
        stringBuilder.append("</form>");
        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    public static String getArticleDetailPage(Article article, User user, User author) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html>");

        stringBuilder.append("<head>");
        stringBuilder.append("<meta charset=\"utf-8\">");
        stringBuilder.append("<title>提示页面</title>");
        stringBuilder.append("<style>");
        // 标签内写 CSS 的逻辑
        stringBuilder.append("a {" +
                "color: #333;"+
                "text-decoration: none;"+
                "}");
        stringBuilder.append("a:hover {" +
                "color: white;" +
                "background-color: orange;" +
                "}");
        stringBuilder.append("body {" +
                "background-image: url(\"https://www.2008php.com/2011_Website_appreciate/2011-09-26/20110926182827.jpg\");" +
                "background-repeat:none;"+
                "background-position:0 center;"+
                "}");
        stringBuilder.append("</style>");
        stringBuilder.append("</head>");
        stringBuilder.append("<body>");
        stringBuilder.append("<h3> 欢迎你" + user.getName() + "</h3>");
        stringBuilder.append("<hr>");

        stringBuilder.append(String.format("<h1>%s</h1>", article.getTitle()));
        stringBuilder.append(String.format("<h4>作者：%s</h4>", author.getName()));
        stringBuilder.append(String.format("<div>%s</div>", article.getContent().replace("\n", "<br>")));

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
