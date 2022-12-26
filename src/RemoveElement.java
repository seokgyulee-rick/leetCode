import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int [] nums ={0,1, 2,2, 3,0, 4,2};
        System.out.println(removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    static int removeElement(int[] nums, int val) {
        int answer = nums.length;
        int rearStartPoint = nums.length-1;
        for (int i = 0 ; i < nums.length; i ++){
            if( nums[i] == val ) {
                answer--;}}

        for (int i = 0 ; i < nums.length; i ++){
           if( nums[i] == val ) {
               System.out.println("i : "+ i);
               for (int j = rearStartPoint; j >=answer ; j--){
                   if(nums[j]!= val){
                       System.out.println("J : "+j);
                       nums[i] = nums[j];
                       nums[j] = val;
                       break;
                   }
               }
           }
        }
        return answer;
    }
}

/**
 * https://leetcode.com/problems/remove-element/solutions/127824/remove-element/
 * 이렇게 간단히 투 포인터로도 해결 가능
 * int i = 0;
 *     for (int j = 0; j < nums.length; j++) {
 *         if (nums[j] != val) {
 *             nums[i] = nums[j];
 *             i++;
 *         }
 *     }
 *     return i;
 *
 *     -------------------------
 *
 *     마지막 값을 버리는 식으로 이렇게도 가능
 *     int i = 0;
 *     int n = nums.length;
 *     while (i < n) {
 *         if (nums[i] == val) {
 *             nums[i] = nums[n - 1];
 *             // reduce array size by one
 *             n--;
 *         } else {
 *             i++;
 *         }
 *     }
 *     return n;
 * }
 */
