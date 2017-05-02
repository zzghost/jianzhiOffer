/*
 * 实现一个函数，把字符串中的每个空格替换成"%20"。
 */
public class replaceSpace {
	//解法：找出空格的个数，先扩展数组大小，再进行改变。
	public static String replace(String s){
		char[] t = s.toCharArray();
		int cnt = 0;
		for(char x : t){
			if(x == ' ')
				cnt++;
		}
		int l = cnt * 2;
		char[] dest = new char[s.length() + l];
		System.arraycopy(t, 0, dest, 0, t.length);
		int i = s.length() -1;
		t = dest;
		for(int j = s.length() + l -1; j >= 0 && i >= 0; i--){
			if(t[i] == ' '){
				t[j--] = '0';
				t[j--] = '2';
				t[j--] = '%';
			}
			else 
				t[j--] = t[i];
		}
		s = String.valueOf(t);
		return s;
	}
	public static void main(String[] args){
		String s = " We are happy ";
		s = replace(s);
		System.out.println(s);
	}
}
