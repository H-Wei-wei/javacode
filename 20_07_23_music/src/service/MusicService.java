package service;

import dao.MusicDao;
import entity.Music;

import java.util.List;

public class MusicService {

    // 查询全部歌单
    public List<Music> findMusic(){
        MusicDao musicDao = new MusicDao();
        List<Music> musicList = musicDao.findMusic();
        return musicList;
    }

    // 根据 Id 查询音乐
    public  Music findMusicById(int id){
        MusicDao musicDao = new MusicDao();
        Music music = musicDao.findMusicById(id);
        return music;
    }

    // 上传音乐
    public int insert(String title, String singer, String time, String url,
                       int userid) {
        MusicDao musicDao = new MusicDao();
        int ret = musicDao.insert(title, singer, time, url, userid);
        return ret;
    }

    // 删除音乐
    public int deleteMusicById(int id) {
        MusicDao musicDao = new MusicDao();
        if (musicDao.deleteMusicById(id) == 1) {
            if (musicDao.findLoveMusicByMusicId(id)) {
                int ret = musicDao.removeLoveMusicById(id);
                if (ret == 1) {
                    return 1;
                }
            }
            return 1;
        }
        return 0;
    }

    // 根据关键字查询音乐
    public  List<Music> ifMusic(String str){
        MusicDao musicDao = new MusicDao();
        List<Music> musicList = musicDao.ifMusic(str);
        return musicList;
    }

    // 查询用户喜欢的音乐列表
    public List<Music> findLoveMusic(int user_id){
        MusicDao musicDao = new MusicDao();
        List<Music> musicList = musicDao.findLoveMusic(user_id);
        return musicList;
    }

    // 添加音乐到喜欢列表
    public boolean insertLoveMusic(int userId,int musicId) {
        MusicDao musicDao = new MusicDao();
        // 1.需判断当前音乐是否在喜欢列表
        if (!musicDao.findLoveMusicById(userId, musicId)) {
            // 2.若不存在，就插入音乐
            boolean flag = musicDao.insertLoveMusic(userId, musicId);
            return flag;
        }
        return false;
    }

    // 移除当前用户喜欢的音乐
    public int removeLoveMusic(int userId,int musicId) {
        MusicDao musicDao = new MusicDao();
        int ret = musicDao.removeLoveMusic(userId, musicId);
        return ret;
    }

    // 根据关键字查询喜欢列表
    public List<Music> ifMusicLove(String str,int user_id){
        MusicDao musicDao = new MusicDao();
        List<Music> musicList = musicDao.ifMusicLove(str, user_id);
        return musicList;
    }

//    public static void main(String[] args) {
//        MusicService ms = new MusicService();
////        List<Music> musicList = ms.findMusic();
////        System.out.println(musicList);
////        System.out.println(ms.findMusicById(1));
////        System.out.println(ms.insert("勾指起誓", "罗少爷", "20—08-19", "music/勾指起誓", 1));
//
////        System.out.println(ms.deleteMusicById(1));
//
////        System.out.println(ms.ifMusic("勾"));
//
////        System.out.println(ms.findLoveMusic(1));
////        System.out.println(ms.removeLoveMusic(1, 5));
////        ms.insertLoveMusic(3, 5);
//
////        System.out.println(ms.ifMusicLove("少", 3));
//    }
}
