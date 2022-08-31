package SfTest;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

public class SFDCFileDownload {

    //请求地址
    public static String url = "https://celnetcomcn-dev-ed.my.salesforce.com/services/data/v47.0/sobjects/ContentVersion/0685i000005uZSKAA2/VersionData";
    // 存储路径--自定义
    public static final String DIRECTORY_HEAD = "C:\\Users\\Derrick\\Desktop\\";
    // 认证token
    public static final String token = "00D5i0000013DV9!AQ4AQOHh0Eoby2drQo_DgDjeqEUZBauCz.1ugTQ5jnhfKKY6eJMfsYoIuc1KEwQmODGQfnnvv79D7cNE60B7AcEGkbeztYHz";
    //拼接成认证信息
    private static final String AUTHOR = "Bearer " + token;

    public static void main(String[] args) throws IOException {
        InputStream inputStream = existUrl(url);
        // 文件名
        String fileName = "bb23";
        // 文件类型后缀
        String key = "png";
        if (!Objects.isNull(inputStream)) {
            download(inputStream, fileName + "." + key);
        } else {
            System.out.println("资源不存在 " );
        }
    }
    /**
     * inputStream：文件下载的输入流
     * directory：文件的目录
     * fileName：文件名称
     */
    public static void download(InputStream inputStream,String fileName) throws IOException {
        // 根据仓库目录结构创建文件夹
        File path = new File(DIRECTORY_HEAD );
        if (!path.exists()) {
            path.mkdirs();
        }
        File file = new File(DIRECTORY_HEAD+ fileName);
        // 不需要创建文件，文件输出流找不到文件，会自动创建新文件
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        ) {
            byte[] bytes = new byte[1024];
            int count = 0;
            while ((count = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, count);
            }
            System.out.println("资源下载完成: " +  fileName);
        } catch (Exception e) {
            System.out.println("下载过程中出错: " + fileName);
        } finally {
            if (!Objects.isNull(inputStream)) {
                inputStream.close();
            }
        }
    }

    private static InputStream existUrl(String url) {
        try {
            URL u = new URL(url);
            URLConnection urlConnection = u.openConnection();
            urlConnection.setRequestProperty("Authorization", AUTHOR);
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            return inputStream;
        } catch (Exception e) {
            return null;
        }
    }
}

