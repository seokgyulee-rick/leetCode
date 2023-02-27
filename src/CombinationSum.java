import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        combinationSum(new int[] {2,3,6,7}, 7);
        System.out.println("1");
        // 2,3,4,6,7
    }

    /**
     * 하나 쭉 올리고 다음 꺼 함수로 던지고 계산?
     */
   static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List list = new ArrayList<List<Integer>>();
        int [] memo = new int[candidates.length];

    }
    static List<List<Integer>> combinationCalculation (List<List<Integer>> list, int currentPos, int[] candidates, int [] memo, int currentNum, int target){
         if(currentNum + candidates[currentPos] == target){
             List<Integer> intList = new ArrayList<Integer>();
             for (int i = 0 ; i < memo.length;i++){
                 while(memo[i]>0){
                     intList.add(candidates[i]);
                     memo[i]--;
                 }
             }
             list.add(intList);
             return list;
         }else if(currentNum + candidates[currentPos] < target){
             //그대로 가기

             //다음꺼 가기

         }else{

         }

       combinatiionCalculation();

        return true;
    }
}
/**
 * 모든 조합을 놓고,
 * 나누기..?
 * 2,3,6,7
 *
 * 조합을 먼저 만든다.
 *
 * 하나를 빼고 나머지 조합,
 * 하나 * 2를 하고 나머지 조합
 * ...
 *
 * 조합 함수 필요 (이건 두개 )
 *
 */