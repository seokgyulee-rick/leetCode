import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        int [] digits = {9};

        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {

        /**
         * leetcode 정답
         * int n = digits.length;
         *         for(int i=n-1; i>=0; i--) {
         *             System.out.println("11");
         *             if(digits[i] < 9) {
         *                 digits[i]++;
         *                 return digits;
         *             }
         *
         *             digits[i] = 0;
         *         }
         *
         *         int[] newNumber = new int [n+1];
         *         newNumber[0] = 1;
         *
         *         return newNumber;
         */


        List<Integer> list = new ArrayList<>();

        int length = digits.length;
        int num =0 ;
        int position =1 ;
        for (int i = length-1 ; i >= 0 ; i--){

            if(digits[i]== 9 ){
                System.out.println("11111");
                digits[i]=0 ;
                if(i==0){
                for (int j : digits){
                    list.add(j);
                }
                list.add(0,1);

                }else {
                    System.out.println("22222");
                    digits[i]+=1 ;
                    return digits;
                }
            }
        }

        int[] output = list.stream()
                .mapToInt(i -> i)
                .toArray();

        return output;
    }
}