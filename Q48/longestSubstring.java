/*
 * 从字符串中找出一个最长的不包含重复字符的子字符串。
 */

//动态规划思想
//dp[i]为以i结尾的不包含重复字符的子字符串长度。
//tmp记录到i-1为止的字符串长度。
//若tmp中不包含ch[i],则dp[i] = dp[i-1] + 1
//若tmp中包含ch[i]，则截取tmp的最后一个ch[i]，与目前的ch[i]重组
//
//若不能使用string的方法，则可以构造一个hashmap，key是字符，value是其对应的index.
public class Q {
    public static int getMaxSubString(String str){
        if(str == null || str.length() == 0) return 0;
        char[] ch = str.toCharArray();
        int[] count = new int[str.length()];
        count[0] = 1;
        int max = count[0];
        String tmp = "" + ch[0];
        for(int i = 1; i < str.length(); i++){
            if(tmp.indexOf(ch[i]) < 0){
                tmp += ch[i];
                count[i] = count[i-1] + 1;
            }
            else{
                tmp = tmp.substring(tmp.lastIndexOf(ch[i]) + 1, tmp.length()) + ch[i];
                count[i] = tmp.length();
            }
            max = Math.max(max, count[i]);
        }
        return max;
    }

    public static void main(String[] args){
        String str = "abcdahi";
        int n = getMaxSubString(str);
        System.out.println(n);
    }
}

