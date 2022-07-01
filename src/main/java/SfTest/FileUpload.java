package SfTest;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class FileUpload {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String result2 = HttpRequest.get("https://gzcelnet-dev-ed.my.salesforce.com/services/data/v47.0/sobjects/ContentVersion/0685j00000AbByVAAV/VersionData")
                .header(Header.AUTHORIZATION, "Bearer 00D5j000009kjHX!ARwAQCkenCG0NOXbfYfhuucWJShdvNB.0.xL1.sOiqeqp_D3POt4nvqE1KLKRECpKI1ms8ar5eAUUqgDwnNrZhw1oTol96rH")//头信息，多个头信息多次调用此方法即可
                .timeout(20000)//超时，毫秒
                .execute().body();
       base64ToFile(Base64.getEncoder().encodeToString(result2.getBytes("utf-8")),"a.png","C:\\Users\\Derrick\\Desktop\\");
    }
    public static void base64ToFile(String base64, String fileName, String savePath) {
        File file = null;
        //创建文件目录
        //创建文件目录
        String filePath = savePath;
        File dir = new File(filePath);
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdirs();
        }
        BufferedOutputStream bos = null;
        java.io.FileOutputStream fos = null;
        try {
            byte[] bytes = Base64.getDecoder().decode(base64);
            file=new File(filePath + fileName);
            System.out.println(file.getAbsolutePath());
            fos = new java.io.FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    System.out.println("fffffff");
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
