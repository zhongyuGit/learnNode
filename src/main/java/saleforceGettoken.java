import cn.hutool.http.HttpUtil;

public class saleforceGettoken {
  public static void main(String[] args) {
    String getToken = HttpUtil.createPost("https://hairobotics--hairobot1.my.salesforce.com/services/oauth2/token?grant_type=password&client_id=3MVG9rnryk9FxFMX.Ol9n.__jZ4kYzp2RmWh2kKT6KSu1UxLgEXGMvfqrV6BsgP4_hI2AZTdGJum._cIh25I2&client_secret=0CC5932BE4CF579F1783B054C3A31E738900EAD59E1DD36D212C2340E3AEF728&username=ana.li@hairobotics.com.hairobot1&password=hairobotics2022")
        //    .header("Cookie", cookie)
        .execute()
        .body();
    System.out.println(getToken);
  }
}
