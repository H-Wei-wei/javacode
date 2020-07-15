package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    // 新增文章
    public void add (Article article) {
        // 1.建立连接
        Connection connection = DBUtil.getConnection();
        // 2.拼接 SQL 语句
        String sql = "insert into article values (null, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getContent());
            statement.setInt(3, article.getUserId());
            // 3.执行 SQL 语句
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("新增文章失败");
                return;
            }
            System.out.println("新增文章成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭连接
            DBUtil.close(connection, statement, null);
        }
    }

    // 查看文章列表（所有文章信息（除正文））
    public List<Article> selectALL() {
        List<Article> articles = new ArrayList<>();
        // 1.建立连接
        Connection connection = DBUtil.getConnection();
        // 2.拼装 SQL
        String sql = "select articleId, title, userId from article";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            // 3.执行 SQL
            resultSet = statement.executeQuery();
            // 4.遍历结果集
            while (resultSet.next()) {
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setUserId(resultSet.getInt("userId"));
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5.关闭连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    // 查看指定文章详情（所有内容）
    public Article selectById(int articleId) {
        // 1.建立连接
        Connection connection = DBUtil.getConnection();
        // 2.拼接 SQL
        String sql = "select * from article where articleId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, articleId);
            // 3.执行 SQL
            resultSet = statement.executeQuery();
            // 4.遍历结果集
            if (resultSet.next()) {
                Article article = new Article();
                article.setArticleId(resultSet.getInt("articleId"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(resultSet.getInt("userId"));
                return article;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5.关闭连接
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    // 删除指定文章
    public void delete(int articleId) {
        // 1、建立连接
        Connection connection = DBUtil.getConnection();
        // 2、拼装 SQL
        String sql = "delete from article where articleId = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, articleId);
            // 3、执行 SQL
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("删除文章失败");
                return;
            }
            System.out.println("删除文章成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4、关闭连接
            DBUtil.close(connection, statement, null);
        }
    }
    public static void main(String[] args) {
        ArticleDao articleDao = new ArticleDao();
        // 1.测试插入文章
        Article article = new Article();
        article.setTitle("1");
        article.setContent("我是正文我是正文我是正文我是正文我是正文我是正文我是正文我是正文我是正文我是正文");
        article.setUserId(1);
        articleDao.add(article);
    }
}
