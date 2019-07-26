package pastEQ;

public class Demo1 {

	/*
	 * 1x1=1
	 * 1x2=2 2x2=4 
	 * 1x3=3 2x3=6  3x3=9
	 * 1x4=4 2x4=8  3x4=12 4x4=16
	 * 1x5=5 2x5=10 3x5=15 4x5=20 5x5=25
	 * 
	 *   *  i=1, 1   j=1; j<(2*i) - 1; j++
	 *  ***  i=2, 3
	 * *****  i=3, 5
	 * 
	 * 1x1=1 1x2=2 1x3=3 .. 1x9=9
	 * 2x1=2 2x2=4 ...
	 */
	public static void main(String[] args) {
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print((j)+"*"+i+"="+(i*j)+"  ");
			}
			System.out.println();
		}
	}
}
