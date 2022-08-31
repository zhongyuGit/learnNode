package SfTest;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author : sean
 * @version V1.0
 * @Project: formdata
 * @Package com.sean.formdata.controller
 * @date Date : 2021年09月28日 21:29
 * @Description:
 */

@Slf4j
public class UploadFileToSFDC {

  public static void main(String[] args)
  {
    try {
      String token = "00D0w0000000Mj8!AREAQJ3.V78QdeQlhhyWlwfcSEF9g6PxWvPqBf._ZwDZfkz42.qO9t9zfwc.xxTj4sE._PMS57Ut2IaWGK7sSduqTfmJji6D";
      MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      //设置编码格式
      builder.setCharset(Charset.forName("UTF8"));
      //设置请求体的参数
      builder.addTextBody("entity_content","{\n" +
          "    \"ReasonForChange\" : \"Marketing materials updated\",\n" +
          "    \"PathOnClient\" : \"Snipaste_2022-08-02_11-06-41.png\"\n" +
          "}", ContentType.parse("application/json"));
      File file = new File("C:\\Users\\Derrick\\Desktop\\Snipaste_2022-08-02_11-06-41.png");
      FileInputStream inputStream = new FileInputStream(file);
      //把文件放到请求体中
      builder.addBinaryBody("VersionData",inputStream, ContentType.APPLICATION_OCTET_STREAM,file.getName());
      //构建请求实体
      HttpEntity entity = builder.build();

      //  创建Post方式请求
      HttpPost httpPost = new HttpPost("https://hairobotics--hairobot1.my.salesforce.com/services/data/v55.0/sobjects/ContentVersion");
      httpPost.setEntity(entity);
      httpPost.setHeader("Authorization","Bearer "+token);
      CloseableHttpClient httpClient = HttpClients.createDefault();
      //发送请求
      CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

      //状态码
      int statusCode = httpResponse.getStatusLine().getStatusCode();
      //msg
      String reasonPhrase = httpResponse.getStatusLine().getReasonPhrase();
      //data
      String responseBody = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
      System.out.println(responseBody);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

