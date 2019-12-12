
public class CCC {
	
	public static boolean isPrime(int n) {
	    //check if n is a multiple of 2
	    if (n%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true; 	    
	}
	
	
	public static long filter(long zahl, int ziffer)
	{
		return zahl / 10 == 0 ? // Sind wir bei der letzten Ziffer?
				(zahl % 10 == ziffer ? 0 : zahl % 10) : // Letzte Ziffer streichen? Falls ja -> 0, sonst eben der letzte Rest
					(zahl % 10 == ziffer ? filter(zahl / 10, ziffer) : 10 * filter(zahl / 10, ziffer) + zahl % 10);
				    // In der Zeile zuvor findet nun das Herausstreichen statt:
				    // - Soll die momentane Ziffer gestrichen werden, so werden nur alle bisher nicht herausgestrichenen
				    //   Ziffern zurückgeliefert.
				    // - Soll die momentane Ziffer nicht gestrichen werden, so werden alle bisher nicht herausgestrichenen
				    //   Ziffern um eine weitere Stelle erweitert (Multiplikation mit 10) und die momentane Ziffer reiht
				    //   sich mit ein (Addition des momentanen Rests).
	}
	
	
	
	public static void main(String[] args) {
		
		int zahl = 11223344; 
		int ziffer = 3;  
		
		System.out.println(zahl);
		System.out.println(filter(zahl,ziffer));
		
	}
	

}
