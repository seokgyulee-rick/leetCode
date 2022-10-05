import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }

    static boolean isPalindrome(int x){
        //1. linkedn list
        int value = x;
        String stringValue = String.valueOf(x) ;
        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        Stack<Integer> stack  = new Stack<>();

        boolean result = true;
        int length = stringValue.length();
        for (int j = 0 ; j < length; j ++){
            if(stringValue.charAt(j) != stringValue.charAt(length-1-j)) result = false;
        }
        return (result);
    }

    //2. 다른 방법 고민
    // 공간을 추가적으로 쓰지않고
    // stack 구현체는 ?


}
