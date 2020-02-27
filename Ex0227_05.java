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
			System.out.println("1. �ＺTV ����");
			System.out.println("2. ����� ���� ");
			System.out.println("3. ������ ����");
			System.out.println("4. ���� ������ �ݾ� Ȯ��");
			System.out.println("5. ��ǰ �� ���� ��� Ȯ��");
			System.out.println("���ϴ� ��ȣ�� �����ϼ���.");
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
	String name = "ȫ�浿";
	int tv_count = 0;
	int ref_count = 0;
	int air_count = 0;

	void buy(Product p) {

		if (money < p.price) {
			System.out.println("�ݾ��� �����մϴ�.");
		} else {
			System.out.println(p.name + " 1�븦 �����߽��ϴ�.");
			money -= p.price;

			if (p instanceof SamsungTv) {
				tv_count++;
				System.out.println("�Ｚ TV ���� ���: " + tv_count);
			}

			if (p instanceof Ref) {
				ref_count++;
				System.out.println("����� ���� ���: " + ref_count);
			}

			if (p instanceof Condi) {
				air_count++;
				System.out.println("������ ���� ���: " + air_count);
			}
		}
	}

	void money_now() {
		System.out.println("���� ���� ���� �ݾ�: " + money);

	}
	
	void total() {
		System.out.println("�Ｚ TV �� ���� ���: "+tv_count);
		System.out.println("����� �� ���� ���: "+ref_count);
		System.out.println("������ �� ���� ���: "+air_count);
	}
}