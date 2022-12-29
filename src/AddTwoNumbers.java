import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1;
        ListNode l2;
        l1 = new ListNode(9);
        l2 = new ListNode(1,new ListNode(9,new ListNode(9)));
        addTwoNumbers(l1,l2);
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode currentl1 = l1;
        ListNode currentl2 = l2;
        int toAddNextValue = 0;

        ListNode cur = answer;
        while (true) {
            int sum = currentl1.val + currentl2.val +toAddNextValue;
            if (sum < 10) {
                cur.val = sum;
                toAddNextValue = 0;
            } else {
                toAddNextValue = 1;
                cur.val = sum - 10;
            }

            if(currentl1.next == null || currentl2.next == null){
                break;
            }else{
                currentl1 = currentl1.next;
                currentl2 = currentl2.next;
                cur.next = new ListNode();
                cur = cur.next;
            }
        };
        ListNode leftover = currentl1.next== null ? currentl2 : currentl1;
        while(leftover.next != null){
            cur.next = new ListNode();
            cur = cur.next;
            int sum = leftover.next.val + toAddNextValue;

            if (sum < 10) {
                cur.val = sum;
                toAddNextValue = 0;
            } else {
                cur.val = 0;
                toAddNextValue = 1;
            }
                leftover = leftover.next;
        }
        if(toAddNextValue==1){
            cur.next = new ListNode();
            cur = cur.next;
            cur.val =1;
        }
        return answer;
    }
}
/**
 * https://leetcode.com/problems/add-two-numbers/solutions/127833/add-two-numbers/
 *  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
 *         ListNode dummyHead = new ListNode(0);
 *         ListNode curr = dummyHead;
 *         int carry = 0;
 *         while (l1 != null || l2 != null || carry != 0) {
 *             int x = (l1 != null) ? l1.val : 0;
 *             int y = (l2 != null) ? l2.val : 0;
 *             int sum = carry + x + y;
 *             carry = sum / 10;
 *             curr.next = new ListNode(sum % 10);
 *             curr = curr.next;
 *             if (l1 != null)
 *                 l1 = l1.next;
 *             if (l2 != null)
 *                 l2 = l2.next;
 *         }
 *         return dummyHead.next;
 *         // 와 이것때문에 고민한건데 이게 레전드네... 리턴값을 변경하는 스킬
 *     }
 */


//    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int numOfL1 = getNumber(l1);
//        int numOfL2 = getNumber(l2);
//        int result = numOfL1 + numOfL2;
//
//        ListNode nodeToBeMade = new ListNode();
//        ListNode cur = nodeToBeMade; //얕은 복사
//        String stringResult = String.valueOf(result);
//
//        for (int i = stringResult.length()-1 ; i >= 0 ;i--){
//            System.out.println("count");
//            cur.val = Character.getNumericValue(stringResult.charAt(i));
//            System.out.println(stringResult.charAt(i));
//            System.out.println(cur.val);
//
//            if(i > 0){
//                System.out.println("inside count");
//                cur.next = new ListNode();
//                cur = cur.next;
//            }
//        }
//
//        return nodeToBeMade;
//    }
//    static int getNumber(ListNode list)
//    {
//        double multiplyTen = 0 ;
//        int power = 0;
//        int resultNumber = 0;
//        boolean exitFlag = true;
//
//        while(exitFlag){
//            multiplyTen =  Math.pow(10, power);
//            resultNumber += list.val*multiplyTen;
//
//
//            if(list.next == null) exitFlag = false;
//            list = list.next;
//            power++;
//
//        }
//        return resultNumber;
//    }

