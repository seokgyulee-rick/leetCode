import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));

    }

    public static String longestCommonPrefix(String[] strs) {
        int countOfStrs = 200;
        for (int num = 0; num < strs.length; num++) {
            if (strs[num].length() < countOfStrs) countOfStrs = strs[num].length();
        }

        String answer = "";

        for (int position = 0; position < countOfStrs; position++) {
            char toCompare = strs[0].charAt(position);
            for (int num = 0; num < strs.length; num++) {
                if (strs[num].charAt(position) != toCompare) return answer;
            }
            answer += toCompare;
        }
        /**
         * 첫글자부터 비교해서 달라지면 스탑
         * 비교 방법
         * 0번 방 꺼내서 쭉 비교, 달라지면 return
         * 같음 -> 다 돈다 -> 그러면 푸쉬
         * 같으면 넣음
         */

        return answer;
    }

    public static String longestCommonPrefix2(String[] strs) {
        /**
         * 스트링 배열 sort
         * 처음과 끝 비교
         */
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        String answer ="";
        int shorterLenth = Math.min(first.length(),last.length());
        for (int i = 0 ; i < shorterLenth; i++){
            if(first.charAt(i) == last.charAt(i)) answer += first.charAt(i);
            else break;
        }
        return answer;
    }
    public static String longestCommonPrefix3(String[] strs) {
        /**
         * prefix를 첫단어로 만들고 비교 while 문으로
         * 처음과 끝 비교
         */
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for ( int i = 1 ; i < strs.length; i ++){
            while(strs[i].indexOf(prefix)!= 0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
