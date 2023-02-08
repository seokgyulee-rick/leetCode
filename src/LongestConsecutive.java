import java.util.Arrays;

public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));

    }
    static int longestConsecutive(int[] nums) {
        if(nums.length==1) return 1;
        Arrays.sort(nums);
        int L = 0 , R = 0;
        int answer = 0;
           for (int i = 1 ; i < nums.length; i++){
            L = i -1;
            R = i;
            while(true){
                if(R< nums.length && nums[R-1]+1 == nums[R]) {
                    R++;
                } else if(R< nums.length && nums[R-1] == nums[R]){
                    R++;
                    L++;
                }else{
                    break;
                }

            }
            answer = Math.max(answer, R - L) ;
            i = R;
        }
        return answer;
    }
}

/**
 * Hashset 풀이
 *
 * class Solution {
 *     public int longestConsecutive(int[] nums) {
 *         Set<Integer> num_set = new HashSet<Integer>();
 *         for (int num : nums) {
 *             num_set.add(num);
 *         }
 *
 *         int longestStreak = 0;
 *
 *         for (int num : num_set) {
 *             if (!num_set.contains(num-1)) {
 *                 int currentNum = num;
 *                 int currentStreak = 1;
 *
 *                 while (num_set.contains(currentNum+1)) {
 *                     currentNum += 1;
 *                     currentStreak += 1;
 *                 }
 *
 *                 longestStreak = Math.max(longestStreak, currentStreak);
 *             }
 *         }
 *
 *         return longestStreak;
 *     }
 * }
 */