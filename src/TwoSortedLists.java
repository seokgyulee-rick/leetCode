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
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(1);
        System.out.println(mergeTwoLists(list1, list2).val);
    }

      public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list2 == null) return list1;
        if(list1 == null) return list2;
        ListNode list1Current = list1;
        ListNode list2Current = list2;
        ListNode answer = new ListNode();
        ListNode answerHelper = answer;

          while(list1Current != null && list2Current != null){
              if( list1Current.val > list2Current.val  ){
                  System.out.println("case 1 : "+ list2Current.val);
                  answerHelper.next = new ListNode(list2Current.val);
                  list2Current = list2Current.next;
              }else{
                  System.out.println("case 2 : "+ list1Current.val);
                  answerHelper.next =  new ListNode(list1Current.val);
                  list1Current = list1Current.next;
              }
              answerHelper = answerHelper.next;
          }
          if(list1Current == null){
              answerHelper.next = list2Current;
          }else if( list2Current == null){
              answerHelper.next = list1Current;
          }

          /**
           * 내 답
           *
           * while(list1Current != null || list2Current != null){
           *             if(list1Current == null){
           *                 answerHelper.next = new ListNode(list2Current.val);
           *                 list2Current = list2Current.next;
           *             }else if( list2Current == null){
           *                 answerHelper.next = new ListNode(list1Current.val);
           *                 list1Current = list1Current.next;
           *             }else if( list1Current.val > list2Current.val  ){
           *                     System.out.println("case 1 : "+ list2Current.val);
           *                     answerHelper.next = new ListNode(list2Current.val);
           *                     list2Current = list2Current.next;
           *                 }else{
           *                     System.out.println("case 2 : "+ list1Current.val);
           *                     answerHelper.next =  new ListNode(list1Current.val);
           *                     list1Current = list1Current.next;
           *                 }
           *             answerHelper = answerHelper.next;
           *         }
           */


        return answer.next;

  }
}
