package number;

public class checker {
	public String jg(Number NM,int n) {
		if( NM.getBaseNumber()== n) {
			return "Bingo" ;
		}else if(NM.getBaseNumber() > n) {
			return "は低いです" ;
		}else {
			return "は高いです" ;
		}
	}
}
