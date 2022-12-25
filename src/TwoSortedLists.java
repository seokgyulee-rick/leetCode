import java.util.List;

public class TwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
//        mergeTwoLists();
    }

      public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list2 == null) return list1;
        if(list1 == null) return list2;
          System.out.println(list1.toString());

        ListNode answer;
        boolean listOne = true;
        boolean listTwo = true;
//        //초기값 설정
//          if(  list1.val<=list2.val){
//              answer = new ListNode(list1.val);
//              if(list1.next != null) list1 = list1.next;
//          }else{
//              answer = new ListNode(list2.val);
//              if(list2.next != null) list2 = list2.next;
//          }
          //반복
        while(listOne && listTwo){
            ListNode toCompareA = list1;
            ListNode toCompareB = list2;

            if(toCompareA.val<=toCompareB.val){
                list1 = new ListNode(list1.val, list2);
                if(toCompareA.next != null) toCompareA = list1.next;
                else listOne = false;
            }else{
                list2 = new ListNode(list2.val, list1);
                if(toCompareB.next != null) toCompareB = list2.next;
                else listTwo = false;
            }

        }

          if (list1.val<=list2.val) return list1;
          else return list2;
  }
}
