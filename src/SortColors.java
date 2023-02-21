public class SortColors {
    public static void main(String[] args) {
        sortColors(new int[]{2,0,2,1,1,0});
    }
    static void sortColors(int[] nums) {

        boolean flag = true;
        while(flag){
            flag = false;
            for (int i = 0 ; i < nums.length-1 ; i++){
                for (int j = i+1; j< nums.length ; j++){
                    if(nums[i]>nums[j]){
                        flag = true;
                        //swap
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

//        System.out.println("1");
    }
}

/**
 * 나는 버블 소트로 풀었지만
 *
 * class Solution {
 *     public void sortColors(int[] nums) {
 *         int low=0;
 *         int mid=0;
 *         int high=nums.length-1;
 *         int temp=0;
 *         while(mid<=high){
 *             switch(nums[mid]){
 *                 case 0:{
 *                     temp=nums[low];
 *                     nums[low]=nums[mid];
 *                     nums[mid]=temp;
 *                     low++;
 *                     mid++;
 *                     break;
 *                 }
 *                 case 1:{
 *                     mid++;
 *                     break;
 *                 }
 *                 case 2:{
 *                     temp=nums[mid];
 *                     nums[mid]=nums[high];
 *                     nums[high]=temp;
 *                     high--;
 *                     break;
 *                 }
 *
 *             }
 *         }
 *     }
 * }
 * 이 방법도 신박한듯
 * 로우 미드 하이 
 */