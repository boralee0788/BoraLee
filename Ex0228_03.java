import java.util.Scanner;

public class Ex0228_03 {

	public static void main(String[] args) {
		// 1) ��ǻ��	2) TV	3) �����	4) ��Ź��	5) ������
		// 6) ���Ź�ǰ, ���� �ݾ�  ���	7) �����ݾ� ���
		// 8) �����ݾ� ����	0)����
		
		int select = 0;
		Consumer c = new Consumer();
				
		Loop1:
		while(true) {
			if(c.count>=10) {
				System.out.println("�� 10���� ��ǰ�� �̹� �����ϼ̽��ϴ�.");
			}
			
			select = subject();

			switch (select) {
			case 1:
				c.buy(new Computer1());
				System.out.println("��ǻ�� 1�� ����");
				break;
				
			case 2:
				c.buy(new Tv1());
				System.out.println("Tv 1�� ����");
				
				break;
				
			case 3:
				c.buy(new Ref1());
				System.out.println("����� 1�� ����");
				break;
				
			case 4:
				c.buy(new WM1());
				System.out.println("��Ź�� 1�� ����");
				break;
				
			case 5:
				c.buy(new AC1());
				System.out.println("������ 1�� ����");
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
				System.out.println("�ý����� �����մϴ�.");
				
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
		System.out.println("             [��ǰ ���� ���α׷�]");
		System.out.println("-------------------------------------------");
		System.out.println("1) ��ǻ��	2) TV	3) �����	4) ��Ź��	5) ������");
		System.out.println("6) ���Ź�ǰ, ���� �ݾ�  ���	7) �����ݾ�, ���ʽ�����Ʈ ���");
		System.out.println("8) �����ݾ� ����	9) ���� ���	10) �˻�	0)����");
		System.out.println("���ϴ� ��ȣ�� �Է��ϼ���.>>");
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
			System.out.println("�ݾ��� �����մϴ�.");
			System.out.println("�ݾ��� �����ϼ���.");
			return;
		}
		money -=p.price;
		bonusPoint +=p.bonusPoint;
		this.p[count] = p;
		count++;
		sum += p.price;
	}
	
	// ���Ź�ǰ �� ���� �ݾ� ���
	void print1() {
		System.out.println("************************");
		if(count==0) {
			System.out.println("������ ��ǰ�� �����ϴ�.");
			return;
		}
		
		System.out.print("���� ǰ��: ");
		for(int i=0;i<count+delete_num;i++) {
			System.out.print(p[i].name+" ");
		}
		System.out.println();
		System.out.println("�� ���� ����: "+(count));
		System.out.println("�� ���� �ݾ�: "+sum);
		System.out.println("************************");
	}
	
	// �������ݾ� & ���ʽ� ����Ʈ ���
	void print2() {
		System.out.println("************************");
		System.out.println("���� ���� �ݾ�: "+money);
		System.out.println("���� ���ʽ�����Ʈ: "+bonusPoint);
		System.out.println("************************");
	}
	
	// �ݾ� ����
	void charge() {
		int add = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("������ �ݾ��� �Է����ּ���.");
		// ī����� ���ý� - ī��ȸ�� card(num,card_num,price); (ȸ����ȣ, ī���ȣ, �ݾ�)
		//           - ȸ����ȣ, �ݾ�, true/false 
		add = scan.nextInt();
		
		money += add;
		
		System.out.println("************************");
		System.out.println("���� �ݾ�: "+add);
		System.out.println("���� �� ���� �ݾ�: "+money);
		System.out.println("************************");
	}
	
	// ���� ���
	void delete() {
		int d = 0;
		String[] item_list = { "", "��ǻ��", "Tv", "�����", "��Ź��", "������" };
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("[�������]");
			System.out.println("���Ÿ� ����ϰ� ���� ��ǰ�� �������ּ���.");
			System.out.println("1) ��ǻ��	2) TV	3) �����	4) ��Ź��	5) ������ ");
			d = scan.nextInt();

			if (!(d > 0 && d < 6)) {
				System.out.println("�߸��� ��ȣ�� �Է��ϼ̽��ϴ�.��ȣ�� �ٽ� �Է����ּ���.");
				continue;
			}

			Loop2: for (int i = 0; i < count; i++) {
				if (item_list[d].equals(p[i].name)) {
					System.out.println(p[i].name + " 1�� ���Ÿ� ����մϴ�.");
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
	
	// ���� ��ǰ �˻�
	void search() {
		System.out.println("[�˻�]");
		int tv_count = 0;
		int com_count=0;
		int ref_count=0;
		int wm_count=0;
		int ac_count=0;
		for (int j=0; j<count+delete_num;j++) {
			if(count==0) {
				break;
			}
			if(p[j].name.equals("��ǻ��")) {
				com_count++;
			}else if(p[j].name.equals("Tv")) {
				tv_count++;
			}else if(p[j].name.equals("�����")) {
				ref_count++;
			}else if(p[j].name.equals("��Ź��")) {
				wm_count++;
			}else if(p[j].name.equals("������")) {
				ac_count++;
			}
		}
		System.out.println("��ǻ�� ���� ���: "+com_count+"��");
		System.out.println("Tv ���� ���: "+tv_count+"��");
		System.out.println("����� ���� ���: "+ref_count+"��");
		System.out.println("��Ź�� ���� ���: "+wm_count+"��");
		System.out.println("������ ���� ���: "+ac_count+"��");
		
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
		super(900, "��ǻ��", 90);
	}
}

class Tv1 extends Product1{
	
	Tv1(){
		super(1000, "Tv", 100);
	}
}

class Ref1 extends Product1{
	
	Ref1(){
		super(1500, "�����", 150);
	}
}

class WM1 extends Product1{
	
	WM1(){
		super(1200, "��Ź��", 120);
	}
}

class AC1 extends Product1{
	
	AC1(){
		super(1000, "������", 100);
	}
}







