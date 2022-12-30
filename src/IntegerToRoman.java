public class IntegerToRoman {
    public static void main(String[] args) {
      String str =   intToRoman(1994);
        System.out.println(str);

    }


    static String intToRoman(int num) {
        String text = String.valueOf(num);
        int length = text.length();
        int standardNumbers [] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String stringArray [] = {"M"  ,"CM", "D", "CD","C","XC","L" ,"XL" ,"X","IX","V","IV","I"};
        int position = 0;
        String answer = "";
        for (int i = 0 ; i< standardNumbers.length; i ++){
                int value = num/standardNumbers[i];
                for (int j = 0 ; j < value; j++) answer = answer.concat(stringArray[i]);
//            System.out.println("log :"+ num+" value : "+value+" stringArray["+i+"] "+ stringArray[i]);
            num = num % standardNumbers[i];
        }
        return answer;
    }
}
/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * 1. 길이 파악
 * 2. 숫자파악 ( 자릿수, 숫자 파악 )
 * 3. 변형 후 concat
 *
 */