import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums).toString());
    }
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> currentValue = new ArrayList<Integer>();
        int[] used = new int[nums.length];
        recurse(list,nums,currentValue,0);
        return list;
    }
    static void recurse(List<List<Integer>> list, int[] nums,List<Integer> currentValue, int count){
//        System.out.println("count :"+ count);
        if(count == nums.length){
//            List<Integer> intList = new ArrayList<Integer>();
//            intList.addAll(currentValue);
            list.add(new ArrayList<>(currentValue));
            return;
        }
        for (int j = 0 ; j < nums.length;j++){
//            if(used[j] == 0){
            if(currentValue.contains(nums[j])) continue;
                currentValue.add(nums[j]);
//                used[j]++;
                recurse(list,nums,currentValue,count+1);
                currentValue.remove(currentValue.size()-1);
//                used[j]--;
//            }
        }
    }
}
/**
 * swab solution
 * class Solution {
 *     public List<List<Integer>> permute(int[] nums) {
 *         List<List<Integer>> result = new ArrayList<>();
 *         backtracking(nums, result, 0);
 *         return result;
 *     }
 *
 *     public void backtracking(int[] nums, List<List<Integer>> result, int start) {
 *         if (start == nums.length) {
 *             List<Integer> list = new ArrayList<>();
 *             for (int num : nums) { list.add(num); }
 *             result.add(list);
 *             return;
 *         }
 *
 *         for (int i = start; i < nums.length; i++) {
 *             swap(nums, start, i);
 *             backtracking(nums, result, start + 1);
 *             swap(nums, start, i);
 *         }
 *     }
 *
 *     public void swap(int[] nums, int a, int b) {
 *         int temp = nums[a];
 *         nums[a] = nums[b];
 *         nums[b] = temp;
 *     }
 * }
 */
