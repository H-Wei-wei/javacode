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
        stringBuilder.append("</head>");

        stringBuilder.append("<body>");
        stringBuilder.append("<div> 欢迎你" + user.getName());
        // 要有一个文章列表，显示每个文章的标题
        for (Article article: articles) {
            stringBuilder.append(String.format("<div> <a href=\"article?articleId=%d\"> %s </a> </div>",
                    article.getArticleId(), article.getTitle()));
        }
        stringBuilder.append(String.format("<div> 当前共有博客 %d 篇</div>", articles.size()));

        stringBuilder.append("</body>");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }
}
