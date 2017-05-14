/*
 *输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 */

//解法：分为从左到右，从上到下，从右到左，从下到上打印。
//要注意的是各种判断边界条件。
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    ArrayList<Integer> aList = new ArrayList<Integer>();
    if(row == 0 || col == 0) return null;
    if(row == 1)
        for(int i = 0; i < col; i++)
            aList.add(matrix[row-1][i]);
    else if(col == 1)
        for(int i = 0; i < row; i++)
            aList.add(matrix[i][col-1]);
    else{
        int Min = Math.min(row, col);
        int end = (Min % 2 == 0) ? (Min/2) : (Min/2+1);
        for(int num = 0; num < end; num++){
            int sHeng = num, eHeng = col - sHeng;
            int sShu = num + 1, eShu = row - sShu ;
            for(int i = sHeng; i < eHeng; i++)
                aList.add(matrix[sHeng][i]);
            if(sShu <= eShu){
                for(int i = sShu; i < eShu; i++)
                    aList.add(matrix[i][eHeng-1]);
                for(int i = eHeng-1; i >= sHeng; i--)
                    aList.add(matrix[eShu][i]);
                for(int i = eShu-1; i >= sShu; i--)
                    aList.add(matrix[i][sHeng]);
            }
        }
    }
        return aList;
    }
}
