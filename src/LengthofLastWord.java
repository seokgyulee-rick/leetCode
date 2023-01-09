public class LengthofLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
    }


    static int lengthOfLastWord(String s) {
        if(!s.contains(" "))return s.length();

        //일단 공백 시작 제거
        while(true){
//            System.out.println("loop");
            if(s.charAt(s.length()-1) == ' '){
                s = s.substring(0,s.length()-1);
//                System.out.println(s);
            }else{
                break;
            }
        }
        /**
         * 이 부분은 사실 trim으로 훨씬 쉽게 구현 가능햇었음
         * https://coding-factory.tistory.com/129
         * s = s.trim()
         */

        int answer = 0;
        int j = s.length()-1;
        while(true){
            System.out.println("loop");
            if(j==-1||s.charAt(j) == ' '){
                System.out.println(s);
break;
            }else{
                answer++;
            }
            j--;
        }
        return answer;
    }
}
/**
 * class Solution {
 *     public int lengthOfLastWord(String s) {
 *         s = s.trim();
 *         return s.length() - s.lastIndexOf(" ") - 1;
 *     }
 * }
 * 와....
 * indexOf는 String의 0번 index부터 특정 문자열을 탐색하였습니다. 만약 반대방향으로 문자열을 찾고 싶다면 lastIndexOf(String)를 사용해야 합니다.
 */