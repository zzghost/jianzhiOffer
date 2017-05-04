/*请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径.
 *路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子.
 *如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *例如[a b c e s f c s a d e e]是3*4矩阵，其包含字符串"bcced"的路径，但是矩阵中不包含“abcb”路径，
 *因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

//解法：回溯法，递归。要注意边界条件的检查，还有特殊情况:matrix.length == str.length == 1
public class Solution{
    public boolean find(char[] matrix, char[] str, int startI, int startJ, int rows, int cols){
        if(startI < 0 || startI >= rows || startJ < 0 || startJ >= cols)
            return false;
        int position = startI  * cols + startJ;
        if(position >= matrix.length || position < 0)
            return false;
        if(str.length == 0)
            return true;
        if(matrix[position] != str[0])
            return false;
        char c = matrix[position];
        matrix[position] = '0';
        char[] next = java.util.Arrays.copyOfRange(str, 1, str.length);
        if(find(matrix, next, startI-1, startJ, rows, cols)||
        find(matrix, next, startI+1, startJ, rows, cols)||
        find(matrix, next, startI, startJ-1, rows, cols)||
        find(matrix, next, startI, startJ+1, rows, cols))
            return true;
        else matrix[position] = c;
        return false;
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(str.length == 0)
            return false;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i*cols + j] == str[0]){
                    boolean rst = find(matrix, str, i, j, rows, cols);
                    if(rst || str.length == 1)
                        return true;
                }
            }
        }
             return false;
    }
}
