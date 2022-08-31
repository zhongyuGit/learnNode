package zhijielina;

public class MainTest {
  public static void main(String[] args) {
    LeadApproval lead = new LeadApproval(3.0f, "组长");
    DeptApproval dept = new DeptApproval(5.0f, "部门领导");
    lead.next = dept;
    lead.Request(9f);

  }
}
