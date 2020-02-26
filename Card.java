
public class Card {

	static final int KIND_MAX = 4;
	static final int NUM_MAX = 13;
	
	static final int CLOVER = 1;
	static final int HEART = 2;
	static final int DIAMOND = 3;
	static final int SPADE = 4;
		
	int kind;
	int number;
	
	
	Card(){
		
	}
	
	Card(int kind, int number){
		this.kind = kind;
		this.number = number;
	}
	
	public String toString() {
		String[] kinds = {"","CLOVER", "HEART", "DIAMOND", "SPADE"};
		String numbers = "0123456789XJQK";
		return kinds[kind]+" "+numbers.charAt(number);
	}
	
}
