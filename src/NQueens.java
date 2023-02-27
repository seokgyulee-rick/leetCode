import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        solveNQueens(4);
//        System.out.println("1");
    }

    static List<List<String>> solveNQueens(int n) {

        int [][] map = new int[n][n];
        int[][] memo = new int[n][n];
        List<List<String>> answer = new ArrayList<List<String>>();
        recursiveFunc(map, 0, n , answer, memo);
        return answer;
    }

    static List<List<String>> recursiveFunc ( int [][] map, int count, int n, List<List<String>> answer , int[][] memo){
    //return 조건
        if( count == n ){
            //변환
                List<String> stringList = new ArrayList<String>();
            for (int i = 0 ; i < n ; i++){
                StringBuilder str = new StringBuilder();
                for (int j = 0 ; j < n ; j++){
                    if(map[i][j] == 0){
                            str.append(".");
                    }else{
                            str.append("Q");
                    }
                }
                stringList.add(String.valueOf(str));
            }
            answer.add(stringList);
        }else{

            for (int i = 0 ; i< n ; i++){
                if(memo[count][i] == 0){
                    map[count][i]=1;
                    //처리
                    for (int k = 0 ; k < n ; k++){
                        for (int t = 0 ; t < n ; t++){
                            if(k==count ||t == i || Math.abs(k-count) == Math.abs(t-i))
                                memo[k][t]++;
                        }
                    }
                    recursiveFunc(map, count+1, n, answer, memo);
                    map[count][i]=0;
                    //복귀
                    for (int k = 0 ; k < n ; k++){
                        for (int t = 0 ; t < n ; t++){
                            if(k==count ||t == i || Math.abs(k-count) == Math.abs(t-i))
                                memo[k][t]--;
                        }
                    }
                }
            }
        }
        return answer;
    }
//    static boolean isValid2 (int [][] map, int row, int col, int n ){
//
//    }
//    static boolean isValid (int [][] map, int row, int col, int n ){
//        for (int j = 0 ; j < row ; j++){
//            for (int i = 0 ; i < n ; i++){
//                if(map[j][i] != 0){
//                    //놓여진 부분 발견
//                    if(Math.abs(j-row) == Math.abs(i-col) || col == i){
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
}
/**
 * 1. queen 하나 놓고 다음 퀸 놓고, 다음 퀸 놓고,
 * 2. 재귀로 놓고 다 놓으면 리스트에 저장
 일단 풀었음
 두가지 방법 해봤는데 더 빠른 방법 공부해보기

 */