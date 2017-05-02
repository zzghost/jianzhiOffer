package 剑指offer;
/*创建singleton模式*/
public class Singleton {
	public Singleton(){
	}
	private static final Singleton sg = new Singleton();
	public static Singleton SG(){
		return sg;
	}
}
