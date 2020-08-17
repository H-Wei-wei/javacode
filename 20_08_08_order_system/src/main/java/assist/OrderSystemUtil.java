package assist;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class OrderSystemUtil {
    // 需要实现读取 body 的功能
    // 需要先把整个 body 读取出来，才能去解析 JSON
    public static String readBody(HttpServletRequest request) throws UnsupportedEncodingException {
        // 先去读取到 body 的长度（单位是字节）
        int length = request.getContentLength();
        byte[] buffer = new byte[length];
        try (InputStream inputStream = request.getInputStream()){
            inputStream.read(buffer, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 构造字符数据的时候必须要指定该字符串的编码格式
        // 此处是将字节转换成字符，最好加上编码方式
        return new String(buffer, "utf-8");
    }
}
