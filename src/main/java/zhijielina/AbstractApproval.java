package zhijielina;

public abstract class AbstractApproval {

  public Float day;
  public String name;
  public AbstractApproval next;

  public AbstractApproval(Float dat,String name){
    this.day = dat;
    this.name = name;
  }

  public void Request(Float requestDay){
    if(requestDay!=null&&requestDay<=day){
      System.out.println(name+"[审批通过]");
    }else{
      if(next!=null&&requestDay!=null){
        next.Request(requestDay);
      }else{
        System.out.println("没有人能审批");
      }
    }
  }
}
