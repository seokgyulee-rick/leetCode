public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        int mid = (left + right) / 2;

        if(target < nums[left]) return left;
        if(target > nums[right-1]) return right;

        while(left<right){
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
            mid = (left + right) / 2;
//            if(left+1 == right) break;
//            System.out.println(mid);
        }
//        if(target > nums[right]) return right+1;
//        else return right ;
        if(mid < nums.length && nums[mid] < target) return mid +1;

        return mid;


    }
}

class MainforSearch{

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(new int[] {1,3}, 2));

    }
}


/**
 *     public int searchInsert(int[] nums, int target) {
 *         int left = 0, right = nums.length-1;
 *         int mid = (left + right) / 2;
 *
 *         while(left <= right){
 *             if(nums[mid] == target){
 *                 return mid;
 *             }
 *             if(nums[mid] > target){
 *                 right = mid-1;
 *             }else{
 *                 left = mid+1;
 *             }
 *             mid = (left + right) / 2;
 *         }
 *         return left;
 *
 *     }
 *
 *     이렇게 간단하게도 가능
 *     left를 넘겨준다는 생각이 필요
 */