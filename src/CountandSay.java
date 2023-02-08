//public class CountandSay {
//    public static void main(String[] args) {
//        System.out.println(countAndSay(4));
//    }
//
//  static String
//
//          e
//
//          (int n) {
//        if(n ==1) return "1";
//        if(n == 2) return "11";
//        String convertTarget = countAndSay(n-1);
////      System.out.println("n: "+n+" convertTarget: "+ convertTarget);
//        int count =0;
//        StringBuilder answer = new StringBuilder();
//        for (int i =0; i< convertTarget.length(); i++){
//            if(i==0) count++;
//            else if(convertTarget.charAt(i)!= convertTarget.charAt(i-1)) {
//                answer.append(Integer.toString(count));
//                answer.append(Character.toString(convertTarget.charAt(i-1)));
//                count = 1;
//                if(i==convertTarget.length()-1){
//                    answer.append(Integer.toString(count));
//                    answer.append(Character.toString(convertTarget.charAt(i)));
//                }
//            }else if(i==convertTarget.length()-1){
//                if(convertTarget.charAt(i)!= convertTarget.charAt(i-1)){
//                    answer.append(Integer.toString(count));
//                    count = 1;
//                    answer.append(Character.toString(convertTarget.charAt(i-1)));
//                }else{
//                    count++;
//                }
//                answer.append(Integer.toString(count));
//                answer.append(Character.toString(convertTarget.charAt(i)));
////                System.out.println(answer);
//            }
//            else{
//                count++;
//            }
//        }
//        return answer.toString();
//    }
//}
