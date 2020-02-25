
public class Ex0225_05 {

	public static void main(String[] args) {
		
		Deck d = new Deck(); //52���� ī�� �����
		
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
	
	// �ʱ�ȭ
	Deck() { // kind,number
		for(int i=0;i<Card.KIND_MAX;i++) {
			for(int j=0;j<Card.NUM_MAX;j++) {
				cardArr[13*i+j] = new Card(i+1,j+1);
			}
		}
	}
	
	
	// ī�� �̱� 
	Card pick(int index) {
		return cardArr[index];  // index = 10 �̸� clover 11
	}
	
	// ���� �̱�
	Card pick() {
		int index= 0;
		index = (int)(Math.random()*52); // 0~51�� �迭 ����
		return pick(index);
	}
	
	// ī�� ����
	void shuffle() {
		for(int i=0;i<2000;i++) {
			int num = (int)(Math.random()*52);
			Card temp = cardArr[num]; //cardArr[] �� Card�� ��ü�̱� ������ Card temp �̶�� �ӽ� Card ��ü�� �ϳ� ���� �־�� ��
			cardArr[num] = cardArr[0];
			cardArr[0] = temp;
		}
	}
}


class Card{
	static final int KIND_MAX = 4; // ī�幫�� ���� (���)
	static final int NUM_MAX = 13; // ���̺� ī�� �� (���)
	
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
	
	// ī�� ��ü ���
	public String toString() {
		String[] kinds = {"","Clover", "Heart", "Diamond", "Spade"};
		String numbers = "0123456789XJQK";

		return kinds[kind]+" "+numbers.charAt(number);
	}
}