public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,2},{5,6},{1,1}}));
    }
//    static int currentMaxValue = Integer.MAX_VALUE;
    static int minPathSum(int[][] grid) {
        int currentMaxValue;
        System.out.println(grid.length);
        System.out.println(grid[0].length);
        int[][] memo = new int[grid.length][grid[0].length];
//        for (int i = 0 ; i < grid.length; i++){
//            for (int j = 0 ; j < grid[0].length ; j++){
//                memo[i][j] = Integer.MAX_VALUE;
//            }
//        }
        if(grid.length>=1 && grid[0].length >=1) {
            currentMaxValue = Integer.MAX_VALUE;
        }else{
            return 0;
        }
        currentMaxValue = recursiveFunc(grid,0,0,grid[0][0], currentMaxValue, memo);
        return currentMaxValue;
    }

    static int  recursiveFunc(int[][] grid, int curX, int curY, int sum, int currentMaxValue, int[][] memo){
        if( sum > currentMaxValue) return currentMaxValue;
        if(curY == grid.length-1 && curX == grid[curY].length-1) {
            currentMaxValue = Math.min(currentMaxValue, sum);
            return currentMaxValue;
        }
        if(memo[curY][curX] == 0 || memo[curY][curX] >= sum) memo[curY][curX] = sum;
        else return currentMaxValue;

        if(curX < grid[curY].length-1){
            currentMaxValue = recursiveFunc(grid,curX+1,curY,sum + grid[curY][curX+1], currentMaxValue, memo);
        }
        if(curY < grid.length-1){
            currentMaxValue =  recursiveFunc(grid,curX,curY+1,sum + grid[curY+1][curX], currentMaxValue, memo);
        }
        return currentMaxValue;
    }
}
/**
 * #1 dfs로 가다가 맥스 값보다 크면 탈락
 */