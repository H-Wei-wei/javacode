package dao;

import entity.Music;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {
    /**
     * 查询全部歌单
     */
    public  List<Music> findMusic(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Music> musicList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from music";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = createMusic(resultSet);
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return musicList;
    }

    /**
     * 根据Id查询音乐
     * @param id
     * @return
     */
    public Music findMusicById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from music where id=?";
            statement = connection.prepareStatement(sql); // 预编译
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Music music = createMusic(resultSet);
                return music;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;
    }

    /**
     * 根据关键字查询歌单(指定歌名或模糊查询)
     */
    public  List<Music> ifMusic(String str){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Music> musicList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from music where title like '%" + str + "%'";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = createMusic(resultSet);
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement, resultSet);
        }
        return musicList;
    }

    /**
     * 上传音乐
     */
    public  int insert(String title, String singer, String time, String url,
                      int userid) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into music values (null, ?, ?, ?, ?, ?) ";
            statement = connection.prepareStatement(sql);
            statement.setString(1, title);
            statement.setString(2, singer);
            statement.setString(3, time);
            statement.setString(4, url);
            statement.setInt(5, userid);
            int ret = statement.executeUpdate();
            // 返回影响的行数
            if (ret == 1) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement,resultSet);
        }
        return 0;
    }

    /**
     * 删除歌曲：
     */
    public  int deleteMusicById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from music where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int ret = statement.executeUpdate();
//            if (ret == 1) {
//                // 成功删除 music 表中音乐
//                // 同时删除 loveMusic 表中的音乐
//                if (findLoveMusicById(id)) {
//                    int ret2 = removeLoveMusicById(id);
//                    if (ret2 == 1) {
//                        return 1;
//                    }
//                }
//                // 如果 LoveMusic 中没有这首歌
//                return 1;
//            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return 0;
    }

    // 移除 LoveMusic 中的音乐
    public  int removeLoveMusicById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from lovemusic where music_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return 0;
    }

    public boolean findLoveMusicByMusicId(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from lovemusic where music_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return false;
    }

    /**
     * 查询用户喜欢的全部歌单
     * @param user_id
     * @return
     */
    public List<Music> findLoveMusic(int user_id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Music> musicList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from music where id in (select music_id from lovemusic where user_id = ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = createMusic(resultSet);
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement, resultSet);
        }
        return musicList;
    }

    /**
     * 添加音乐到“喜欢”列表中
     * 用户-》音乐
     * 多对多
     * 需要中间表
     */
    public boolean insertLoveMusic(int userId,int musicId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into lovemusic values (null, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2,musicId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return false;
    }
    /**
     * 添加喜欢的音乐的时候，需要先判断该音乐是否存在
     * @param musicId
     * @return
     */
    public boolean findLoveMusicById(int userid,int musicId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from lovemusic where user_id = ? and music_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userid);
            statement.setInt(2, musicId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return false;
    }

    /**
     * 移除当前用户喜欢的这首音乐，因为同一首音乐可能多个用户喜欢
     * @return 返回受影响的行数
     */
    public  int removeLoveMusic(int userId,int musicId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from lovemusic where user_id = ? and music_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2,musicId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return 0;
    }

    /**
     * 根据关键字查询喜欢的歌单
     * @param str
     * @return
     */
    public List<Music> ifMusicLove(String str,int user_id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Music> musicList = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from music where id in (select music_id from lovemusic where user_id = ?) and title like '%" +
                    str + "%'";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Music music = createMusic(resultSet);
                musicList.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,statement, resultSet);
        }
        return musicList;

    }


    private Music createMusic(ResultSet resultSet) throws SQLException {
        Music music = new Music();
        music.setId(resultSet.getInt("id"));
        music.setTitle(resultSet.getString("title"));
        music.setSinger(resultSet.getString("singer"));
        music.setTime(resultSet.getDate("time"));
        music.setUrl(resultSet.getString("url"));
        music.setUserid(resultSet.getInt("userid"));
        return music;
    }
//    public static void main(String[] args) {
////        List<Music> musicList = findMusic();
////        System.out.println(musicList);
//
////       System.out.println(findMusicById(1));
//
////       List<Music> musicList = ifMusic("姑娘");
////        System.out.println(musicList);
//
////        insert("少年","梦然","20-07-31","music/少年",1);
////        deleteMusicById(4);
//
////       System.out.println(insertLoveMusic(1, 1));
////        removeLoveMusic(1, 1);
////        System.out.println(findLoveMusic(1));
//
////       System.out.println(ifMusicLove("南", 1));
//    }
}
