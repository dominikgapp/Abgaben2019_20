package parkgarage;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {

		 
		int[] lvl1 =  {19, -19, 11, -11, 1, -1, 17 ,-17, 10, 7, -10, -7, 3, 14, -14, -3, 13, -13, 4, 12, 20, 18, 6, 16, -18, -12, -16, 5, -5, -20, -6, -4, 8, 15, -8, 2, -15, 9, -2, -9}; 
		

		
		Garage g = new Garage(lvl1,100);
		g.checknumbers(lvl1);
		
		
		
		
	 
	}
}