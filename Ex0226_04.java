import java.util.Scanner;

public class Ex0226_04 {

	public static void main(String[] args) {
		// ī�� ���� ���α׷� 
		
		int select =0;
		int card_count = 0;
		Deck d = new Deck();
		Card[] user1 = new Card[7];
		Card[] user2 = new Card[7];
		Card[] com = new Card[7];
		d.shuffle();
		
		Loop1:
		while(true) {
			select = subject();
			
			switch (select) {
			case 1:
				System.out.println("[���ӽ���]");
				baseCard(user1, user2, com, d, card_count);

					
				break;
				
			case 2:
				cardAdd(d, user1, user2, com, card_count);
				
				break;
				
			case 3:
				check(user1, user2, com);
				break Loop1;
			
			case 4:
				System.out.println("�ý����� �����մϴ�.");
				break Loop1;

			default:
				break;
			
			}
		}
	}
		
	static int subject() {
		Scanner scan = new Scanner(System.in);
		System.out.println("*************************");
		System.out.println("1. ���ӽ���");
		System.out.println("2. 1�� �߰�");
		System.out.println("3. Ŭ�ι� ����");
		System.out.println("4. ����");
		System.out.println("*************************");
		System.out.println("���ϴ� ��ȣ�� �Է��ϼ���.>>");
		int select = scan.nextInt();
		return select;
	}
	
	
	static void baseCard(Card[] user1, Card[] user2, Card[] com, Deck d, int card_count) {
		System.out.println("<user 1>");
		for(int i=0;i<3;i++) {
			user1[i] = d.pick(i);
			System.out.println(user1[i]);
			card_count++;
		}
		
		System.out.println("-------------------");
		System.out.println("<user 2>");
		for(int i=0;i<3;i++) {
			user2[i] = d.pick(card_count);
			System.out.println(user2[i]);
			card_count++;
		}
		
		System.out.println("-------------------");
		System.out.println("<computer>");
		for(int i=0;i<3;i++) {
			com[i] = d.pick(card_count);
			System.out.println(com[i]);
			card_count++;
		}
	}
	
	static void cardAdd(Deck d, Card[] user1, Card[] user2,  Card[] com, int card_count) {
		int base_count = 3;
		Loop2:
		while(true) {
			System.out.println("[1�� �߰�]");
			Scanner scan = new Scanner(System.in);
			int add = 0;
			System.out.println("1. ī�� �߰�  99. ���� �̵�");
			add = scan.nextInt();
			
			switch (add) {
			case 1:
				if(base_count>=7) {
					System.out.println("���  ������ 7�徿 ī�带 �޾ҽ��ϴ�.");
					break Loop2;
				}
				
				user1[base_count] = d.pick(card_count);
				user2[base_count] = d.pick(card_count+1);
				com[base_count] = d.pick(card_count+2);
				
				System.out.println("<user 1>");
				for(int i=0;i<base_count+1;i++) {
					System.out.println(user1[i]);
				}
				System.out.println("-------------------");
				
				System.out.println("<user 2>");
				for(int i=0;i<base_count+1;i++) {
					System.out.println(user2[i]);
				}
				System.out.println("-------------------");
				
				System.out.println("<computer>");
				for(int i=0;i<base_count+1;i++) {
					System.out.println(com[i]);
				}
				
				card_count ++;
				base_count ++;
				
				break;
				
			case 99:
				System.out.println("������ �̵�");
				break Loop2;
				
			default:
				break;
			}
		}
	}
	
	static void check(Card[] user1, Card[] user2, Card[] com) {
		int user1_clover = 0;
		int user2_clover = 0;
		int com_clover = 0;
		for(int i=0; i<user1.length;i++) {
			if(user1[i].kind==1) {
				user1_clover ++;
			}
		}
		for(int i=0; i<user2.length;i++) {
			if(user2[i].kind==1) {
				user2_clover ++;
			}
		}

		for(int i=0; i<com.length;i++) {
			if(com[i].kind==1) {
				com_clover ++;
			}
		}
		
		
		System.out.println("user 1�� clover ����: "+user1_clover);
		System.out.println("user 2�� clover ����: "+user2_clover);
		System.out.println("computer�� clover ����: "+com_clover);
			
		}
		
	

}
