import java.util.Scanner;

public class Ex0227_05 {

	public static void main(String[] args) {

		SamsungTv[] sam = new SamsungTv[10];
		Ref[] ref = new Ref[10];
		Condi[] con = new Condi[10];
		User user = new User();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("-----------------------");
			System.out.println("1. 삼성TV 구매");
			System.out.println("2. 냉장고 구매 ");
			System.out.println("3. 에어컨 구매");
			System.out.println("4. 현재 보유한 금액 확인");
			System.out.println("5. 제품 별 구매 대수 확인");
			System.out.println("원하는 번호를 선택하세요.");
			System.out.println("-----------------------");
			int num = scan.nextInt();

			switch (num) {
			case 1:
				user.buy(new SamsungTv());

				break;

			case 2:
				user.buy(new Ref());

				break;

			case 3:
				user.buy(new Condi());

				break;

			case 4:
				user.money_now();

				break;
				
			case 5:
				user.total();

				break;

			default:
				break;
			}

		}

	}

}

class User {
	int money = 10000;
	String name = "홍길동";
	int tv_count = 0;
	int ref_count = 0;
	int air_count = 0;

	void buy(Product p) {

		if (money < p.price) {
			System.out.println("금액이 부족합니다.");
		} else {
			System.out.println(p.name + " 1대를 구매했습니다.");
			money -= p.price;

			if (p instanceof SamsungTv) {
				tv_count++;
				System.out.println("삼성 TV 구매 대수: " + tv_count);
			}

			if (p instanceof Ref) {
				ref_count++;
				System.out.println("냉장고 구매 대수: " + ref_count);
			}

			if (p instanceof Condi) {
				air_count++;
				System.out.println("에어컨 구매 대수: " + air_count);
			}
		}
	}

	void money_now() {
		System.out.println("현재 유저 보유 금액: " + money);

	}
	
	void total() {
		System.out.println("삼성 TV 총 구매 대수: "+tv_count);
		System.out.println("냉장고 총 구매 대수: "+ref_count);
		System.out.println("에어컨 총 구매 대수: "+air_count);
	}
}