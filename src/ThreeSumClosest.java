import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {

        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
        // -4 -1 1 2
    }
    static int threeSumClosest(int[] nums, int target) {
        int answer = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++){
            answer = countAndSum(1, 0, i, nums, target, answer);
        }
        return answer;
    }
    static int countAndSum(int count, int currentSum, int currentIndex, int[] nums, int target, int answer) {
        System.out.println(count+" "+ currentIndex+" "+currentSum);
//        if (count == 4) return answer; //종료조건

        currentSum += nums[currentIndex];
        if (count == 2) {
            int currentAnswer = 0;
            int currentSum2 = currentSum + nums[currentIndex+1];
            currentAnswer  = Math.abs(currentSum2- target);
             System.out.println("current Answer : "+ currentAnswer+" currentSum : "+ currentSum2);
             boolean flag = false;
            if(currentIndex+2<nums.length) {
                for (int i = currentIndex + 2; i < nums.length; i++) {
                    currentSum += nums[i];
                    // -2, -1, 0, 1, 2, 3
                    if (Math.abs(currentSum - target) < currentAnswer) {
                        System.out.println(Math.abs(currentSum - target));
                        currentAnswer = Math.abs(currentSum - target);
                        flag = true;
                        break;
                    }currentSum -= nums[i];}
            }
            if(currentAnswer < Math.abs(answer - target)){
                if(flag == true){
                    System.out.println("\n*****   111 "+currentAnswer+"  "+ currentSum);
                    answer =  currentSum;
                }else{
                    System.out.println("\n*****   222 "+currentAnswer+"  "+ currentSum2);
                    answer = currentSum2;
                }
            }
            System.out.println("answer " + currentSum);
            return answer;
        }else {
            if (currentIndex + 1 < nums.length) {
                count++;
                for (int i = currentIndex + 1; i < nums.length - 1; i++) {
                    answer = countAndSum(count, currentSum, i, nums, target, answer);
                }
            }
            return answer;
        }}
}
/**
 * 1. bruteforce 방식으로 접근 - 재귀로 해보자
 * 2. 정렬..큰도움은 안될 것 같다.
 *
 */