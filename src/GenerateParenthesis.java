import java.util.*;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println( generateParenthesis(3).toString());
    }
//    static List<String> generateParenthesis(int n) {
//
//        HashSet<String> answer = new HashSet<>();
//        HashSet<String> pastAnswer = new HashSet<>();
//        List<String> listAnswer = new ArrayList<>();
//        Stack<String> leftParenthesis = new Stack<>();
//        Stack<String> rightParenthesis = new Stack<>();
//
//        for (int i = 0 ; i < n ; i++){
//            leftParenthesis.push("(");
//            rightParenthesis.push(")");
//        }
//        answer.add("()");
//        pastAnswer.addAll(answer);
//        StringBuilder value = new StringBuilder();
//        for (int i = 1 ; i < n ;i ++) {
//            HashSet<String> tempAnswer = new HashSet<>();
//            for (String str : answer) {
//                String param = str;
//                tempAnswer.add("(" + param + ")");
//                for (String j : pastAnswer){
//                    if(str.length() + j.length() == (i+1)*2) {
//                        tempAnswer.add(str.concat(j));
//                        tempAnswer.add(j.concat(str));
//                    }
//                }
//                tempAnswer.add(str);
//            }
//            answer.addAll(tempAnswer);
//            pastAnswer.addAll(tempAnswer);
//        }
//        for (String str : answer) {
//            if(str.length() == n*2){
//                listAnswer.add(str);
//            }
//        }
//        System.out.println(listAnswer.toString());
//
//        return  listAnswer;
//    }

    static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        String currentStr = "(";
        recurse(1, 0, n, answer, currentStr);
        return answer;
    }
    static void recurse (int left, int right, int n, List<String> answer, String currentStr){
        if(left == n && right == n ){
            answer.add(currentStr);
            return;
        }
        if(left < n){
            recurse(left+1,right,n, answer,currentStr+"(");
        }
        if(left> right){
            recurse(left,right+1,n, answer,currentStr+")");
        }
        return;
    }

}

/**
 * ["((( )))",
 *  "(() ())",
 *  "(()) ()",
 *  "() (())",
 *  "() () ()"]
 */