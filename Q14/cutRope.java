public class cutRope{
    //解法1：动态规划
    //f[n]表示长度为n的绳子，被切分以后的所有段的乘积最大值。
    //f[0]~f[3]的初始化含义：代表绳子没有被切分过,f[i]=i
    //从f[4]起，就可以认为绳子开始被切分。
    //很久没写动态规划题了，思路很生疏了。要记得动态规划是把大问题分解成小问题，小问题中又套小问题。想清楚了这一点，就不会疑惑绳子到底是不是被切成若干段而不是两段
    //作者说的动态规划的4个特点，这里总结一下：
    //1）把小问题的最优解组合起来能够得到整个问题的最优解。
    //2）整体问题的最优解依赖于各个子问题的最优解。
    //3）把大问题分成若干个小问题，这些小问题之间还有相互重叠的更小子问题。
    //4）从上往下分析问题，从下往上求解问题。
    public static int solution(int n){
        if(n < 2) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        for(int i = 4; i <= n; i++){
            for(int j = 1; j <= i/2; j++){
                int tmp = f[j] * f[i-j];
                f[i] = Math.max(f[i], tmp);
            }
        }
        return f[n];
    }
    //解法2：贪心算法
    //当n >= 5时，每次都剪3，当剩下的绳子长度为4时，把绳子剪成2*2。
    public static int solution2(int n){
        if(n < 2) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        
        int t = n / 3;
        if(n - t*3 == 1)
            t--;
        int t2 = (n - t * 3) / 2;
        return (int)(Math.pow(3, t))*(int)(Math.pow(2,t2));
    }

    public static void main(String[] args){
        System.out.println(solution(6)); 
        System.out.println(solution2(6));
    }
}
