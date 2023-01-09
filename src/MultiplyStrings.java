import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("1292903509936727404199686220192411623085","9996190433341303536650999221082973702747291324607482481306424831201698419742124862320482024"));

    }

    static String multiply(String num1, String num2) {
        if(num1.equals("0")|| num2.equals("0")) return "0";
        char[] num1Ary = num1.toCharArray();
        char[] num2Ary = num2.toCharArray();
        int[] answer = new int[num1.length()+num2.length()];
        int kPosition = 0;
            for (int i = num1Ary.length-1 ; i >= 0 ; i--){
                int carryOver = 0;
                for ( int j = num2Ary.length-1, k = num1Ary.length - 1 - i ; j >= 0 ; j--, k++){
                    int currentProduct = (Character.getNumericValue(num1Ary[i])* Character.getNumericValue(num2Ary[j]));
                    System.out.println(Character.getNumericValue(num1Ary[i]));
                    System.out.println(Character.getNumericValue(num2Ary[j]));
                    System.out.println(currentProduct);
                    String stringCurrentProduct = Integer.toString(currentProduct);
                    int currentValue = 0;
                    boolean carryOverFlag = false;

                    if(currentProduct>=10){
                        currentValue = Character.getNumericValue(stringCurrentProduct.charAt(1));
                    }else{
                        currentValue = currentProduct;
                    }
                    System.out.println("carryover : "+ carryOver);
                    System.out.println("currentValue : "+ currentValue);

                    if((answer[k]+ carryOver) < 10){
                        System.out.println("case 1");
                        answer[k] += carryOver;
                        carryOver = 0;
                    }else{
                        System.out.println("case 2");
                        int tempSum = answer[k]+ carryOver;
                        String strTempSum = Integer.toString(tempSum);
                        answer[k] = Character.getNumericValue(strTempSum.charAt(1));
                        carryOver = Character.getNumericValue(strTempSum.charAt(0));
                        carryOverFlag = true;
                    }
                    if((answer[k] +  currentValue) <10){
                        System.out.println("case 3");
                        answer[k] += currentValue;
                    }else{
                        System.out.println("case 4");
                        int tempSum = answer[k]+ currentValue;
                        String strTempSum = Integer.toString(tempSum);
                        answer[k] = Character.getNumericValue(strTempSum.charAt(1));
                        if(carryOverFlag) {
                            carryOver += Character.getNumericValue(strTempSum.charAt(0));
                        carryOverFlag = false;
                        }else{
                            carryOver = Character.getNumericValue(strTempSum.charAt(0));
                        }
                    }
                    if(currentProduct>=10) carryOver += Character.getNumericValue(stringCurrentProduct.charAt(0));

                    System.out.println("k : "+k+" answer[k] : " + answer[k]);

                    kPosition = k;
                    System.out.println(Arrays.toString(answer));
                }
                if(carryOver>0){
                    answer[kPosition+1] += carryOver;
                    System.out.println(Arrays.toString(answer));
                }
            }
//        System.out.println(Arrays.toString(answer));
//        List<int[]> list = Arrays.asList(answer);
//        System.out.println((Arrays.toString(list)));
//        Collections.reverse(list);
//        Object[] reversedArray = list.toArray();
//        System.out.println(Arrays.toString(reversedArray));
            int[] realAnswer = new int[answer.length];
        String strRealAnswer = "";
            for (int i =0; i< answer.length; i++){
                realAnswer[i] = answer[answer.length-1-i];
                strRealAnswer += String.valueOf(answer[answer.length-1-i]);
            }
//        System.out.println("return")

//        System.out.println(strRealAnswer.charAt(0));
//        System.out.println(strRealAnswer);

        if(strRealAnswer.charAt(0) =='0') {
//            System.out.println("true");
            strRealAnswer = strRealAnswer.substring(1);
        }
            return strRealAnswer;

            //        return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
    }
}


/**
 * 서정의 힌트
 * 배열을 사용하여 해결
 * 배열로 만든 후에,
 *
 *
 * 987654321
 * 123456789
 *
 * 12193 26311 12635 269
 *
 * 12193 26311 12635 269
 *
 * 12193 15301 02635 269
 * 12193 25201 12635 269
 * 12193 16201 12735 269
 * 12192 06201 11735 269
 * 12192 06201 11735 269
 * 12193 16201 12735 269
 * 12193 16301 02735 269
 *
 * 670592745
 *
 * 80779853376
 * 80779853376
 *
 * 9449772114007
 * 9449772114007
 *
 * 12345678
 * 87654321
 *
 * 10821 52022374638
 * 10820 52022374638
 *
 * 간단 솔루션
 *
 * public String multiply(String num1, String num2) {
 *     int m = num1.length(), n = num2.length();
 *     int[] pos = new int[m + n];
 *
 *     for(int i = m - 1; i >= 0; i--) {
 *         for(int j = n - 1; j >= 0; j--) {
 *             int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
 *             int p1 = i + j, p2 = i + j + 1;
 *             int sum = mul + pos[p2];
 *
 *             pos[p1] += sum / 10;
 *             pos[p2] = (sum) % 10;
 *         }
 *     }
 *
 *     StringBuilder sb = new StringBuilder();
 *     for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
 *     return sb.length() == 0 ? "0" : sb.toString();
 * }
 *
 *
 */