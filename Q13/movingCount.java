/*
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 *  例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *  但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Solution {
        public int sum(int i){
            int sum = 0;
            while(i != 0){
                sum += (i % 10);
                i = i / 10;
            }
            return sum;
        }
        public int move(int[][] matrix, int threshold, int rows, int cols, int startI, int startJ){
            if(startI < 0 || startJ < 0 || startI >= rows || startJ >= cols || sum(startI) + sum(startJ) > threshold || matrix[startI][startJ] == 1)
                return 0;
            matrix[startI][startJ] = 1;
            return move(matrix, threshold, rows, cols, startI-1, startJ) +
                    move(matrix, threshold, rows, cols, startI+1, startJ) + 
                    move(matrix, threshold, rows, cols, startI, startJ-1) +
                    move(matrix, threshold, rows, cols, startI, startJ+1) + 1;
            }
        public int movingCount(int threshold, int rows, int cols){
            if(rows == 0 && cols == 0)
                return 0;
            int[][] matrix = new int[rows][cols];
            int cnt = move(matrix, threshold, rows, cols, 0, 0);
            return cnt;
        }
}
