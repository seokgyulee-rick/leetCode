import java.util.Arrays;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2,2,1};

        System.out.println(singleNumber(nums));

    }

    static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length; i++){
            if(i+1 < nums.length&&nums[i]!= nums[i+1]){
                return nums[i];
            }
            else{
                i++;
            }
        }
        return nums[nums.length-1];
    }
    /**
     * 1. hashmap 이용하는 방법 ( 해시맵에 갯수를 다 넣어놓고 마지막에 확인 )
     * 2. 지금처럼 소팅 후 검증
     * 3. 수학적 접근 ( 유니크한 숫자 sum * 2 - 모든 숫자 sum = 답 )
     */
}
