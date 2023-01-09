public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
    static boolean isHappy(int n){

            while(n != 1){
                String stringOfN = Integer.toString(n);
                n = 0;
                for (int i = 0 ; i < stringOfN.length();i++){
                    n +=  Math.pow(Character.getNumericValue((stringOfN.charAt(i))),2);

                }
                for (int j = 2 ; j <=9 ; j++){
//                    System.out.println(n);
                    if(89==n) return false;
                }
            }
        return true;
    }
}
/**
 * https://coding-factory.tistory.com/531
 * 1
 * 4
 * 9
 * 16
 * 25
 * 36
 * 49
 * 64
 * 81
 *
 * 11
 * 2
 * 4
 * 16
 * 37
 * 58
 * 89
 * 145
 * 42
 * 20
 * 4
 *
 * 9
 * 81
 * 65
 * 61
 * 37
 * 58
 * 89
 *
 * 25
 * 29
 * 85
 * 89
 * 145
 * 42
 * 20
 *
 * 36
 * 73
 * 58
 * 89
 *
 * class Solution {
 *
 *     private int getNext(int n) {
 *         int totalSum = 0;
 *         while (n > 0) {
 *             int d = n % 10;
 *             n = n / 10;
 *             totalSum += d * d;
 *         }
 *         return totalSum;
 *     }
 *
 *     public boolean isHappy(int n) {
 *         Set<Integer> seen = new HashSet<>();
 *         while (n != 1 && !seen.contains(n)) {
 *             seen.add(n);
 *             n = getNext(n);
 *         }
 *         return n == 1;
 *     }
 * }
 * 해시셋 사용
 */