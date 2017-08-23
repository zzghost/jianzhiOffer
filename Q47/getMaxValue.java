/*
 * m*n的棋盘，每一格代表礼物的价值。
 * 价值>0。
 * 从棋盘左上角开始拿格子里的礼物，每次向左或者向下移动一格，直到达到棋盘右下角。
 * 请问最多能拿到多少价值的礼物。
 */

//递归思路:f(i, j)= max(f(i-1, j), f(i, j-1)) + gift[i,j]
public class Q {
    public static int getMaxValueSolution(int[][] values, int row, int col){
        int rows = values.length, cols = values[0].length;
        if(row > rows - 1 || col > cols - 1)
            return 0;
        return values[row][col] + Math.max(getMaxValueSolution(values, row, col+1), getMaxValueSolution(values, row+1, col));
    }

    public static void main(String[] args){
        int[][] values = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int n = getMaxValueSolution(values, 0, 0);
        System.out.println(n);
    }
}

//动态规划。辅助二维数组，dp[i][j]代表在i,j坐标处能得到的礼物的最大价值。
//dp[i][j]=values[i][j] + Math.max(dp[i-1][j], dp[i][j-1])
public class Q {
    public static int getMaxValueSolution(int[][] values, int row, int col){
        int rows = values.length, cols = values[0].length;
        int[][] dp = new int[rows][cols];
        dp[row][col] = values[row][col];
        for(int i = row;i < rows; i++)
            for(int j = col; j < cols; j++){
                if(i-1 >= 0 && j-1 >= 0)
                    dp[i][j] = values[i][j] + Math.max(dp[i-1][j], dp[i][j-1]);
                if(i-1 < 0 && j-1>= 0)
                    dp[i][j] = values[i][j] + dp[i][j-1];
                if(j-1 < 0 && i-1 >= 0)
                    dp[i][j] = values[i][j] + dp[i-1][j];

            }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args){
        int[][] values = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int n = getMaxValueSolution(values, 0, 0);
        System.out.println(n);
    }
}
//对动态规划的空间优化：因为dp[i][j]只依赖于dp[i-1][j]与dp[i][j-1]两种状态，所以可以将二维数组转变为一维数组
public class Q {
    public static int getMaxValueSolution(int[][] values, int row, int col){
        int rows = values.length, cols = values[0].length;
        int[] dp = new int[cols];
        //初始化
        dp[col] = values[row][col];
        for(int i = col + 1; i < cols; i++){
            dp[i] = dp[i-1] + values[row][i];
        }

        for(int i = row + 1; i < rows; i++){
            dp[col] = dp[col] + values[i][col];
            for(int j = col + 1; j < cols; j++){
                dp[j] = values[i][j] + Math.max(dp[j], dp[j-1]);
            }
        }
        return dp[cols-1];
    }

    public static void main(String[] args){
        int[][] values = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int n = getMaxValueSolution(values, 0, 0);
        System.out.println(n);
    }
}


