
public class Deck {
	
	final int CARD_NUM = 52;
	Card[] array = new Card[CARD_NUM]; // ����
	
	Deck(){
		for(int i=0;i<Card.KIND_MAX;i++) { // KIND_NUM�� CARD Ŭ�������� �̹Ƿ�, (Ŭ������.������) ������� �Է�
			for(int j=0;j<Card.NUM_MAX;j++) {
				array[i*13+j] = new Card(i+1, j+1);
			}
		}
	}
	
	Card pick(int index) {
		return array[index];
	}
	
//	Card pick() {
//		int num = 0;
//		num = (int)(Math.random()*52);
//		return pick(num);
//	}
	
	void shuffle() {
		for(int i=0;i<2000;i++) {
			int num = (int)(Math.random()*52);
			Card temp = array[0];
			array[0] = array[num];
			array[num] = temp;
		}
	}
	
}
