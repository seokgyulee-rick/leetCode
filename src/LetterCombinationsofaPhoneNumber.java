import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {


    public static void main(String[] args) {

        List<String> answer = letterCombinations("");
        System.out.println(answer.toString());

    }

    static List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<String>();
        int count = digits.length();
        int input = Integer.parseInt(digits);
        List<String> alphabetList = Arrays.asList("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
        List<String> answer = new ArrayList<String>();
        recursiveStringBuilder(digits,0,"",answer,alphabetList);

        return answer;
    }
    static void recursiveStringBuilder (String digits, int count, String currentAnswer,List<String> answer, List<String> alphabetList ){
        if(count == digits.length() ) {
            answer.add(currentAnswer);
            return;
        }
        String currentList = alphabetList.get(Character.getNumericValue(digits.charAt(count))-2);
        StringBuilder currentAnswerBuilder = new StringBuilder(currentAnswer);
        for (int i = 0; i < currentList.length(); i++){
            currentAnswerBuilder.append(currentList.charAt(i));
        String tempCurrentAnswer = currentAnswerBuilder.toString();
        count++;
        recursiveStringBuilder(digits,count,tempCurrentAnswer,answer, alphabetList);
        currentAnswerBuilder.deleteCharAt(currentAnswerBuilder.length()-1);
        count--;
        }
    }
}

/**
 * 재귀를 사용할 것 같음.
 */