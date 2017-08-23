/*
 * N个骰子，求所有可能出现的和s的概率
 * 输入：n
 * 输出：所有可能出现的和s的概率值
 *
 */

//递归思想：每个骰子都有6种可能情况。终止条件：骰子为0个和也为0，计为1种可能；骰子或和若为0，计为0种可能。

public class Q {
    public static int getCount(int number, int s){
        if(number == 0 && s == 0)
            return 1;
        if(number == 0 || s == 0)
            return 0;
        int count = 0;
        for(int i = 1; i <= 6; i++){
            count += getCount(number - 1, s - i);
        }
        return count;
    }
    public static void main(String[] args){
        int number = 4;
        for(int i = number; i <= 6 * number; i++)
            System.out.println(i + " appears :" +  getCount(number, i) + "/" + Math.pow(6, number));
    }
}

//递归涉及到大量重复计算，使用动态规划消除重复子问题。
//二维数组dp[i][j]代表i个骰子的和为j的种数。
//dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] + ... + dp[i-1][j-6]
//又由于dp[i-1][j]只依赖于i-1状态的值，可以只用两个一维数组保存结果，优化空间复杂度

public class Q {
    public static void getCountDP(int number){
        int[][] dp = new int[number + 1][6 * number + 1];
        for(int i = 1; i <= 6; i++)
            dp[1][i] = 1;
        for(int i = 2; i <= number; i++){//行
            for(int j = i; j <= 6 * i; j++)//列
                for(int k = 1; k <= j && k <= 6; k++)
                    dp[i][j] += dp[i-1][j-k];
        }
        for(int i = number; i <= 6 * number; i++)
            System.out.println(i + " appears :" +  dp[number][i] + "/" + Math.pow(6, number));
    }
    public static void main(String[] args){
        int number = 3;
        getCountDP(number);
    }
}
