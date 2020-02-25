
public class Ex0225_05 {

	public static void main(String[] args) {
		
		Deck d = new Deck(); //52장의 카드 만들기
		
//		Card c = d.pick(10); // cardArr[10] 
//		System.out.println(c);

		for(int i=0;i<d.CARD_NUM;i++) {
			System.out.println(d.pick(i));
		}
		
		System.out.println("-----------------------");
		d.shuffle();
//		Card c2 = d.pick(10);
//		System.out.println(c2);
		
		for(int i=0;i<d.CARD_NUM;i++) {
			System.out.println(d.pick(i));
		}

	}

}

class Deck{
	final int CARD_NUM = 52;
	Card[] cardArr = new Card[CARD_NUM];
	
	// 초기화
	Deck() { // kind,number
		for(int i=0;i<Card.KIND_MAX;i++) {
			for(int j=0;j<Card.NUM_MAX;j++) {
				cardArr[13*i+j] = new Card(i+1,j+1);
			}
		}
	}
	
	
	// 카드 뽑기 
	Card pick(int index) {
		return cardArr[index];  // index = 10 이면 clover 11
	}
	
	// 랜덤 뽑기
	Card pick() {
		int index= 0;
		index = (int)(Math.random()*52); // 0~51번 배열 선택
		return pick(index);
	}
	
	// 카드 섞기
	void shuffle() {
		for(int i=0;i<2000;i++) {
			int num = (int)(Math.random()*52);
			Card temp = cardArr[num]; //cardArr[] 가 Card의 객체이기 때문에 Card temp 이라는 임시 Card 객체를 하나 만들어서 넣어야 함
			cardArr[num] = cardArr[0];
			cardArr[0] = temp;
		}
	}
}


class Card{
	static final int KIND_MAX = 4; // 카드무늬 개수 (상수)
	static final int NUM_MAX = 13; // 무늬별 카드 수 (상수)
	
	static final int SPADE = 4;
	static final int DIAMOND = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	
	int kind; // 1=clover, 2=heart, 3=diamond, 4=spade
	int number; // 1~9, X, J, Q, K
	
	Card(){
		
	}
	
	Card(int kind, int number){
		this.kind = kind;
		this.number = number;
		
	}
	
	// 카드 객체 찍기
	public String toString() {
		String[] kinds = {"","Clover", "Heart", "Diamond", "Spade"};
		String numbers = "0123456789XJQK";

		return kinds[kind]+" "+numbers.charAt(number);
	}
}