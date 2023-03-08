//import java.util.List;
//
//public class CombinationSum {
//    public static void main(String[] args) {
//
//    }
//
//   static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        //조합 갯수 설정
//       for (int i = 1 ; i <= candidates.length; i++){
//
//       }
//       return new List<List<Integer>> temp;
//    }
//    static boolean combinationCalculation (int count, int currentNum){
//        if(count!=2) {
////            combinatiionCalculation(count-1, currentNum);
//        }
//        return true;
//    }
//}
///**
// * 모든 조합을 놓고,
// * 나누기..?
// * 2,3,6,7
// *
// * 조합을 먼저 만든다.
// *
// * 하나를 빼고 나머지 조합,
// * 하나 * 2를 하고 나머지 조합
// * ...
// *
// * 조합 함수 필요 (이건 두개 )
// *
// */
//
import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5}, 8).toString());

    }
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>(); //정답

        List [] candidateList = new ArrayList [target+1]; //3중 리스트, 앞선 숫자들을 넣을 곳

        for (int i = 0; i < candidateList.length; i++) {
            candidateList[i] = new ArrayList<Integer>(); // initialize each element with a new ArrayList
        }

        List<List<Integer>> temp = new ArrayList<>();
        List<Integer> tempintlist = new ArrayList<>(Arrays.asList(0)); // comment: DP는 초기화 잘해야함
        temp.add(tempintlist);
        System.out.println(temp.toString());
        candidateList[0] = temp;

//        candidateList.add(new ArrayList(){{
//            add(0);
//        }}); // [] -> [[]]

        HashSet<List> answerSet = new HashSet<>();
        for (int i = 1 ; i <= target; i++){ // 앞 숫자들을 계산하면서 타겟까지 가는 for 문
            for (int currentPosition = 0; currentPosition <= i; currentPosition++) { // 앞선 계산을 하는 for 문



                for (int currentCandidate : candidates) { // 후보 숫자를 돌면서 덧셈을 통해 현재 타겟을 만들 수 있냐 계산
                    List<List<Integer>> tempCandiList = new ArrayList<>();
                    if (currentPosition + currentCandidate == i) { //
                            System.out.println("TT! "+currentPosition+" "+ currentCandidate +" = "+ i+ " / "+ candidateList[currentPosition].toString());
//                            System.out.println("pre1");
                            for (int h = 0 ; h <  candidateList[currentPosition].size(); h++) {
                                List<Integer> tempList = new ArrayList<>();
//                                System.out.println("1");
                                if(i == target){
                                    tempList.addAll((Collection<? extends Integer>) candidateList[currentPosition].get(h));
                                    tempList.add(currentCandidate);
                                    tempList.remove(tempList.indexOf(0));

                                    answerSet.add(tempList);
                                    list.add(tempList);
                                }else{
                                    tempList.addAll((Collection<? extends Integer>) candidateList[currentPosition].get(h));
                                    tempList.add(currentCandidate);
                                    tempCandiList.add(tempList);
                                }
                            }
                            candidateList[i] = tempCandiList;
                        }
                }
                }
            }

        System.out.println("answer: "+answerSet.toString());
        return list;
    }
}