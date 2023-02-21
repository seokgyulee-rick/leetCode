import java.util.LinkedList;
import java.util.Queue;
// DFS 아닌 DP 문제
public class MinimumPathSum_BFS {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    //    static int currentMaxValue = Integer.MAX_VALUE;
    static int minPathSum(int[][] grid) {
        int currentMaxValue;
//        System.out.println(grid.length);
//        System.out.println(grid[0].length);
        int[][] memo = new int[grid.length][grid[0].length];
        if(grid.length>=1 && grid[0].length >=1) {
            currentMaxValue = Integer.MAX_VALUE;
        }else{
            return 0;
        }
        for (int i = grid.length-1 ; i>=0 ; i--){
            for (int j = grid[0].length-1; j>=0 ; j--){
                if(i == grid.length-1 && j == grid[0].length-1) memo[i][j] = grid[i][j];
                else if (i==grid.length-1 ) memo[i][j] = grid[i][j] + memo[i][j+1];
                else if (j== grid[0].length-1) memo[i][j] = grid[i][j] + memo[i+1][j];
                else {
                    if(memo[i][j+1] < memo[i+1][j]){
                        memo[i][j] =  grid[i][j] + memo[i][j+1];
                    }else{
                        memo[i][j] = grid[i][j] + memo[i+1][j];
                    }
                }
            }
        }
        return memo[0][0];
    }

}
/**
 * #1 dfs로 가다가 맥스 값보다 크면 탈락
 */