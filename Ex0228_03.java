import java.util.Scanner;

public class Ex0228_03 {

	public static void main(String[] args) {
		// 1) 컴퓨터	2) TV	3) 냉장고	4) 세탁기	5) 에어컨
		// 6) 구매물품, 구매 금액  출력	7) 보유금액 출력
		// 8) 보유금액 충전	0)종료
		
		int select = 0;
		Consumer c = new Consumer();
				
		Loop1:
		while(true) {
			if(c.count>=10) {
				System.out.println("총 10개의 상품을 이미 구매하셨습니다.");
			}
			
			select = subject();

			switch (select) {
			case 1:
				c.buy(new Computer1());
				System.out.println("컴퓨터 1대 구매");
				break;
				
			case 2:
				c.buy(new Tv1());
				System.out.println("Tv 1대 구매");
				
				break;
				
			case 3:
				c.buy(new Ref1());
				System.out.println("냉장고 1대 구매");
				break;
				
			case 4:
				c.buy(new WM1());
				System.out.println("세탁기 1대 구매");
				break;
				
			case 5:
				c.buy(new AC1());
				System.out.println("에어컨 1대 구매");
				break;
				
			case 6:
				c.print1();
		
				break;
				
			case 7:
				c.print2();
				
				break;
				
			case 8:
				c.charge();
				
				break;
				
			case 9:
				c.delete();
				
				break;
				
			case 10:
				c.search();
				
				break;
			
			case 0:
				System.out.println("시스템을 종료합니다.");
				
				break Loop1;

			default:
				break;
			}
			
		}
		
	}
	
	static int subject() {
		int select = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------------------------");
		System.out.println("             [제품 구매 프로그램]");
		System.out.println("-------------------------------------------");
		System.out.println("1) 컴퓨터	2) TV	3) 냉장고	4) 세탁기	5) 에어컨");
		System.out.println("6) 구매물품, 구매 금액  출력	7) 보유금액, 보너스포인트 출력");
		System.out.println("8) 보유금액 충전	9) 구매 취소	10) 검색	0)종료");
		System.out.println("원하는 번호를 입력하세요.>>");
		select = scan.nextInt();
		return select;
	}

}

class Consumer{
	Product1[] p = new Product1[10];
	int money = 100000;
	int bonusPoint = 0;
	int count=0;
	int sum=0;
	int delete_num=0;
	
	void buy(Product1 p) {
		if(money<p.price) {
			System.out.println("금액이 부족합니다.");
			System.out.println("금액을 충전하세요.");
			return;
		}
		money -=p.price;
		bonusPoint +=p.bonusPoint;
		this.p[count] = p;
		count++;
		sum += p.price;
	}
	
	// 구매물품 및 구매 금액 출력
	void print1() {
		System.out.println("************************");
		if(count==0) {
			System.out.println("구매한 상품이 없습니다.");
			return;
		}
		
		System.out.print("구매 품목: ");
		for(int i=0;i<count+delete_num;i++) {
			System.out.print(p[i].name+" ");
		}
		System.out.println();
		System.out.println("총 구매 개수: "+(count));
		System.out.println("총 구매 금액: "+sum);
		System.out.println("************************");
	}
	
	// 현보유금액 & 보너스 포인트 출력
	void print2() {
		System.out.println("************************");
		System.out.println("현재 보유 금액: "+money);
		System.out.println("현재 보너스포인트: "+bonusPoint);
		System.out.println("************************");
	}
	
	// 금액 충전
	void charge() {
		int add = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("충전할 금액을 입력해주세요.");
		// 카드결제 선택시 - 카드회사 card(num,card_num,price); (회원번호, 카드번호, 금액)
		//           - 회원번호, 금액, true/false 
		add = scan.nextInt();
		
		money += add;
		
		System.out.println("************************");
		System.out.println("충전 금액: "+add);
		System.out.println("충전 후 보유 금액: "+money);
		System.out.println("************************");
	}
	
	// 구매 취소
	void delete() {
		int d = 0;
		String[] item_list = { "", "컴퓨터", "Tv", "냉장고", "세탁기", "에어컨" };
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("[구매취소]");
			System.out.println("구매를 취소하고 싶은 제품을 선택해주세요.");
			System.out.println("1) 컴퓨터	2) TV	3) 냉장고	4) 세탁기	5) 에어컨 ");
			d = scan.nextInt();

			if (!(d > 0 && d < 6)) {
				System.out.println("잘못된 번호를 입력하셨습니다.번호를 다시 입력해주세요.");
				continue;
			}

			Loop2: for (int i = 0; i < count; i++) {
				if (item_list[d].equals(p[i].name)) {
					System.out.println(p[i].name + " 1대 구매를 취소합니다.");
					money += p[i].price;
					bonusPoint -= p[i].bonusPoint;
					sum -= p[i].price;
					p[i].name = null;
					count -= 1;
					delete_num++;
					break Loop2;
				} else if (p[i] == null) {
					break;
				}
			}
			break;
		}
	}
	
	// 구매 제품 검색
	void search() {
		System.out.println("[검색]");
		int tv_count = 0;
		int com_count=0;
		int ref_count=0;
		int wm_count=0;
		int ac_count=0;
		for (int j=0; j<count+delete_num;j++) {
			if(count==0) {
				break;
			}
			if(p[j].name.equals("컴퓨터")) {
				com_count++;
			}else if(p[j].name.equals("Tv")) {
				tv_count++;
			}else if(p[j].name.equals("냉장고")) {
				ref_count++;
			}else if(p[j].name.equals("세탁기")) {
				wm_count++;
			}else if(p[j].name.equals("에어컨")) {
				ac_count++;
			}
		}
		System.out.println("컴퓨터 구매 대수: "+com_count+"대");
		System.out.println("Tv 구매 대수: "+tv_count+"대");
		System.out.println("냉장고 구매 대수: "+ref_count+"대");
		System.out.println("세탁기 구매 대수: "+wm_count+"대");
		System.out.println("에어컨 구매 대수: "+ac_count+"대");
		
	}
	
}


class Product1{
	int price;
	String name;
	int bonusPoint;
	
	Product1(int price, String name, int bonusPoint){
		this.price = price;
		this.name = name;
		this.bonusPoint = bonusPoint;
	}
}

class Computer1 extends Product1{
	
	Computer1(){
		super(900, "컴퓨터", 90);
	}
}

class Tv1 extends Product1{
	
	Tv1(){
		super(1000, "Tv", 100);
	}
}

class Ref1 extends Product1{
	
	Ref1(){
		super(1500, "냉장고", 150);
	}
}

class WM1 extends Product1{
	
	WM1(){
		super(1200, "세탁기", 120);
	}
}

class AC1 extends Product1{
	
	AC1(){
		super(1000, "에어컨", 100);
	}
}







