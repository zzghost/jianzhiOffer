package jP;

public class Queen {
	public int count = 0;
	public static int MAXQUEEN = 8;
	public int [] rows = new int[MAXQUEEN];
	public Queen(){
		getArrange(0);
		System.out.println();
		System.out.println(MAXQUEEN + "皇后共有" + count + "种解法");
	}
	public void getArrange(int n){
		boolean[] cols = new boolean[MAXQUEEN];
		for(int i = 0; i < n; i++){
			cols[rows[i]] = true;
			int d = n - i;
			if(rows[i] >= d) cols[rows[i] - d] = true;
			if(rows[i] + d <= MAXQUEEN - 1) cols[rows[i] + d] = true;
		}
		for(int i = 0; i < MAXQUEEN; i++){
			if(cols[i]) continue;
			rows[n] = i;
			if(n < MAXQUEEN - 1) getArrange(n+1);
			else{
				count++;
				printChessBoard();
			}
		}
	}
	public void printChessBoard(){
		System.out.println("第" + count + "种解法：");
		for(int i = 0; i < MAXQUEEN; i++){
			for(int j = 0; j < MAXQUEEN; j++)
				if(rows[j] == i)
					System.out.print("1 ");
				else
					System.out.print("0 ");
			System.out.println();
		}
	}
	public static void main(String[] args){
		Queen queen = new Queen();
	}
}
