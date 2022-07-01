package TreadTest;
import java.util.List;
import java.util.concurrent.Callable;

public class SunCallable implements Callable<Boolean>{

    /**当前是属于第几段线程**/
    private int pageIndex;

    private List<String> list;

    public SunCallable(int pageIndex,List<String> list){
        this.pageIndex = pageIndex;
        this.list = list;
    }

    @Override
    public Boolean call() throws Exception {
        System.err.println(String.format("pageIndex:%s size:%s",pageIndex,list.size()));
        Boolean result = Boolean.TRUE;
        if(null != list && list.size() >0){
            for(String str: list){
                try {
                    System.out.println(pageIndex+"::::"+str);
                    handleStr(str);
                } catch (Exception e) {
                    result = Boolean.FALSE;;
                }
            }
        }
        return result;
    }
    /**
     * 业务处理
     * @param str
     * @throws InterruptedException
     */
    public void handleStr(String str) throws InterruptedException {
        Thread.sleep(100);
    }

}
