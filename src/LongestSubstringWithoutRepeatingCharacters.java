public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
    static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int answer = 1;
        for (int i = 0 ; i < s.length()-1; i++){
            int count = 1;
            for (int j = i+1; j <s.length() ; j++){
                if(s.substring(i,j).contains(Character.toString(s.charAt(j))))break;
                count++;
            }
            if( count > answer) answer = count;
        }
        return answer;
    }
}

/**
 * bruteforce 방식으로
 * 반복되는 건지 확인하고
 * 처음부터 카운트해서 answer 로 놓고
 * 더 길면 answer 교체
 *
 * 1. 글자수 비교 방법 -> 실패 -> 앞에것 substring 후 비교 -> 하지만 너무 경쟁력이 떨어짐
 * 2. substring 해서 하나 성공하면 다음 것 시도
 *
 * ####
 * 솔루션
 * 해시 테이블 , 해시 셋 사용
 * public class Solution {
 *     public int lengthOfLongestSubstring(String s) {
 *         int n = s.length();
 *
 *         int res = 0;
 *         for (int i = 0; i < n; i++) {
 *             for (int j = i; j < n; j++) {
 *                 if (checkRepetition(s, i, j)) {
 *                     res = Math.max(res, j - i + 1);
 *                 }
 *             }
 *         }
 *
 *         return res;
 *     }
 *
 *     private boolean checkRepetition(String s, int start, int end) {
 *         Set<Character> chars = new HashSet<>();
 *
 *         for (int i = start; i <= end; i++) {
 *             char c = s.charAt(i);
 *             if(chars.contains(c)){
 *                 return false;
 *             }
 *             chars.add(c);
 *         }
 *
 *         return true;
 *     }
 * }
 *
 * 2번째 솔루션
 * 슬랑이딩 윈도우 전법
 * 해시맵 사용해서 스윽스윽 밀어가면서 다 풀어버림
 *
 * public class Solution {
 *     public int lengthOfLongestSubstring(String s) {
 *         Map<Character, Integer> chars = new HashMap();
 *
 *         int left = 0;
 *         int right = 0;
 *
 *         int res = 0;
 *         while (right < s.length()) {
 *             char r = s.charAt(right);
 *             chars.put(r, chars.getOrDefault(r,0) + 1);
 *
 *             while (chars.get(r) > 1) {
 *                 char l = s.charAt(left);
 *                 chars.put(l, chars.get(l) - 1);
 *                 left++;
 *             }
 *
 *             res = Math.max(res, right - left + 1);
 *
 *             right++;
 *         }
 *         return res;
 *     }
 * }
 *
 * 3번째 솔루션
 * 이건 심지어 n으로 풀어버림.
 * public class Solution {
 *     public int lengthOfLongestSubstring(String s) {
 *         int n = s.length(), ans = 0;
 *         Map<Character, Integer> map = new HashMap<>(); // current index of character
 *         // try to extend the range [i, j]
 *         for (int j = 0, i = 0; j < n; j++) {
 *             if (map.containsKey(s.charAt(j))) {
 *                 i = Math.max(map.get(s.charAt(j)), i);
 *             }
 *             ans = Math.max(ans, j - i + 1);
 *             map.put(s.charAt(j), j + 1);
 *         }
 *         return ans;
 *     }
 * }
 *
 *
 * 마지막 솔루션
 * public class Solution {
 *     public int lengthOfLongestSubstring(String s) {
 *         Integer[] chars = new Integer[128];
 *
 *         int left = 0;
 *         int right = 0;
 *
 *         int res = 0;
 *         while (right < s.length()) {
 *             char r = s.charAt(right);
 *
 *             Integer index = chars[r];
 *             if (index != null && index >= left && index < right) {
 *                 left = index + 1;
 *             }
 *
 *             res = Math.max(res, right - left + 1);
 *
 *             chars[r] = right;
 *             right++;
 *         }
 *
 *         return res;
 *     }
 * }
 * 이건 도저히 모르겠다
 */
