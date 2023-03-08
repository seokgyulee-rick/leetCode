import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(List.of()));

        for (int i = 0 ; i < nums.length ; i++){
            for (int j = 0 ; j < nums.length ; j++){
                List<Integer> smallList = new ArrayList<>();
                int cur = j;
//                while(cur<nums.length){
//                    smallList.add(nums[cur]);
//                    if(smallList.size() > i){
//                        list.add(smallList);
////                        break;
//                    }
//                    smallList.remove(nums[cur]);
//                    cur++;
//                }
                recur(list, smallList, i, j, nums);
            }
        }
        return list;
    }

    void recur(List<List<Integer>> list, List<Integer> smallList, int i, int j, int[] nums){
        // System.out.println(nums.toString());
        if(smallList.size() > i && !list.contains(smallList)){
            list.add(new ArrayList<>(smallList));
            return;
        }
        if( j >= nums.length) return;
        for(int k = j ; k < nums.length ; k++){
            smallList.add(nums[k]);
            recur(list,smallList,i,k+1,nums);
            smallList.remove(smallList.indexOf(nums[k]));
        }
    }
}

class SubsetsMain {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(new int[] {1,2,3});
    }
}


/**
 * bruteforce
 */