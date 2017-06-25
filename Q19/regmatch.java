//请实现一个函数用来匹配包括'.'和'*'的正则表达式。
//模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
//在本题中，匹配是指字符串的所有字符匹配整个模式。
//例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配 

//解法１：动态规划。
//二维数组。
//若str[i-1] == pattern[j-1]||pattern[j-1]=='.'，则匹配成功一个字母，dp[i][j]=dp[i-1][j-1]
//否则：
//如果pattern[j-1]=='*'，
//分两种情况：
//1)str[i-1] == pattern[j-1] || pattern[j-1] == '.',则dp[i][j] = dp[i][j-2]，没匹配
//2)否则：dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j]　没匹配，匹配了一个，或者匹配了多个。
//
//
//
//解法2：递归。
//java没有指针，要格外小心数组越界的情况。保险起见还是用dp吧。
public class Solution {
    public boolean match(char[] str, char[] pattern)
    {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        for(int i = 1; i < dp[0].length; i++)
            if(pattern[i - 1] == '*')
                dp[0][i] = dp[0][i-2];
        for(int i = 1; i < dp.length; i++)
            for(int j = 1; j < dp[0].length; j++){
                if(str[i-1] == pattern[j-1] || pattern[j-1] == '.')
                    dp[i][j] = dp[i-1][j-1];
                else{
                    if(pattern[j-1] == '*'){
                        if(pattern[j-2] != str[i-1] && pattern[j-2] != '.')
                            dp[i][j] = dp[i][j-2];
                        else
                            dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                    }
                }
            }
        return dp[str.length][pattern.length];
    }
}
