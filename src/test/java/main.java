public class main {
    public static void main(String[] args) {
//        System.out.println(testA());
        System.out.println("1、以上报价含税。\\n2、以上不包含地面整改， 库宝系统对地面的要求：平整度不大于±3mm、2.25㎡，地面缝隙不大于7mm。\\n3、以上不包含强电安装施工，含吊装费用。\\n4、以上报价有效期30天。\\n5、付款方式：本合同签署后10个工作日支付合同价款的【40】％；货到现场7日内支付合同金额的【30】％，产品验收后的【30】个工作日内，买方向卖方支付合同价款【25】％，剩余【5】%质保一年。卖方应开具合法有效发票。");
    }


    public static String testA(){
        String str = "666";
        try{
            return testC();
        }catch (Exception e){
            throw new IndexOutOfBoundsException();
        }finally {
            return testB();
        }
    }

    public static String testB(){
        return "B";
    }

    public static String testC(){
        int i = 7/0;
        return "c";
    }
}
