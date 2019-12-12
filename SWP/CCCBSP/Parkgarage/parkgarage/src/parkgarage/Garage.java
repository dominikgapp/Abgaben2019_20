package parkgarage;

import java.util.ArrayList;

public class Garage {

	
	private int [] a; 
	private int wert=0;
	private int max = 0; 
	private boolean ausgebucht = false; 
	private int maxaut; 
	private int maxwart = 0; 
	
	private ArrayList<Integer> warteautos = new ArrayList<Integer>(); 
	
	public Garage(int[] array, int ma)
	{
		a = array; 
		maxaut = ma; 
	}
	
	
	public void checknumbers(int[] array) 
	{
		for (int i= 0; i< array.length; i++)
		{
			if(array[i]>0)
			{
				if (ausgebucht == false) {
				wert+=1;
				}else if (ausgebucht == true) {
					warteautos.add(array[i]); 
				}
			}
			else
			{
				if (ausgebucht == false) {
				wert-=1;
				}
				else if (ausgebucht ==true) {
					warteautos.remove(0); 
					if (warteautos.size()>maxwart)
					{
						maxwart = warteautos.size(); 
					}
					
				}
				
			}
			
			if (wert > max)
			{
				max = wert; 
			}
			
			if (wert == maxaut)
			{
				ausgebucht = true; 
			}
			
			
		}
		
		System.out.println(max);
		System.out.println(maxwart);
		
		
	}

	
}
