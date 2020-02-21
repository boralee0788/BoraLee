
public class Ex0221_02 {

	public static void main(String[] args) {
		Card c = new Card();

		c.kind = "클로버";
		c.num = 1;

		System.out.println("기본생성자: " + c.kind + " " + c.num);

		Card c2 = new Card("하트", 2);
		System.out.println("매개변수가 있는 생성자: " + c2.kind + " " + c2.num);

		
		// for문 돌려서 kind - 클로버, 하트, 다이아몬드, 스페이스
		// num - 1~13까지 총 52개

		String[] kind = { "클로버", "하트", "다이아몬드", "스페이스" };
		Card[] c3 = new Card[52];
		Card[] c4 = new Card[52];
		Card[] c5 = new Card[52];
//
//		for (int i = 0; i < kind.length; i++) {
//			for (int j = 0; j < 13; j++) {
//				c3[i * 13 + j] = new Card();
//				c3[i * 13 + j].kind = kind[i];
//				c3[i * 13 + j].num = j + 1;
//			}
//		}
//		for (int i = 0; i < c3.length; i++) {
//			System.out.println(c3[i].kind + " " + c3[i].num);
//		}
//		
//		for (int i = 0; i < kind.length; i++) {
//			for (int j = 0; j < 13; j++) {
//				c4[i * 13 + j] = new Card(kind[i],j+1);
//				System.out.println(c4[i * 13 + j].kind + " " + c4[i * 13 + j].num);
//			}
//		}
//		
//		
		String[] num2 = {"1", "2","3","4","5","6","7","8","9","10","J","Q","K"};
	
		for (int i = 0; i < kind.length; i++) {
			for (int j = 0; j < 13; j++) {
				c4[i * 13 + j] = new Card();
				c4[i * 13 + j].kind = kind[i];
				c4[i * 13 + j].num = j + 1;
				System.out.println(c4[i * 13 + j].kind+" "+num2[c4[i * 13 + j].num-1]);
			}
		}


		
		
		
	}

}
