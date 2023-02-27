import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        solveNQueens(4);
        System.out.println("1");
    }
    static List<List<String>> answer = new ArrayList<List<String>>(); // 왜 전역?
    static List<List<String>> solveNQueens(int n) {

        int [][] map = new int[n][n];
        System.out.println(map[0][0]);

        return answer;
    }

    static List<List<String>> recursiveFunc ( int [][] map, int count, int n){
    //return 조건
        if( count == n ){
            //변환
                List<String> stringList = new ArrayList<String>();
            for (int i = 0 ; i < n ; i++){
                String str = new String();
                for (int j = 0 ; j < n ; j++){
                    if(map[i][j] == 0){
                        str.concat(".");
                    }else{
                        str.concat("Q");
                    }
                }
                stringList.add(str);
            }
            answer.add(stringList);
        }else{
            for (int i = 0 ; i< n ; i++){
                if(isValid(map, n, i)){
                    map[n][i]=1;
                }
            }
        }
        return answer;
    }
    static boolean isValid (int [][] map, int row, int col){
        return true;
    }
}
/**
 * 1. queen 하나 놓고 다음 퀸 놓고, 다음 퀸 놓고,
 * 2. 재귀로 놓고 다 놓으면 리스트에 저장
 */