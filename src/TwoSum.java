import java.util.LinkedList;

public class TwoSum {
    public static void main(String[] args) {
        int[] ary = {3,2,4};
        int[] res;
        res =  twoSum(ary,6);
        System.out.println("aaa"+res[0]+res[1]);
         }

    static int[] twoSum(int[] nums, int target) {
        boolean flag = false;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1 ; j< nums.length; j++){
                if((nums[i]+nums[j])==target){
                    ans[0] =i;
                    ans[1] = j;
                    flag = true;
                    System.out.println(nums[i]);
                    System.out.println(nums[j]);
                    break;
                }
            }
            if(flag) break;
        }

        return ans;
    }
}
