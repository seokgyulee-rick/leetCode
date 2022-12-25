import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println("answer"+majorityElement(nums));

    }

    static int majorityElement(int[] nums) {
        int standard = nums.length/2;
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        int count = 1 ;
        int answer = nums[0];
        System.out.println("standard :" + standard);
        for (int i = 1 ; i < nums.length; i ++){
            if(i == 0 ){
                count++;
            }else{
                if(nums[i]== nums[i-1]) {
                    count++;
                }
                else {
                    count = 1;
                }

                if(count > standard) {
                    answer = nums[i];
                }

            }
        }
        return answer;

    }
}

/**
 * 1. 지금 처럼 소트로
 * 2. 해시맵으로 생성 후 비교
 * 3.
 *  public int majorityElement(int[] nums) {
 *         Arrays.sort(nums);
 *         return nums[nums.length/2];
 *     }
 *
 *     이렇게 쉽게도 .. 가능
 *     https://leetcode.com/problems/majority-element/solutions/127412/majority-element/
 */
