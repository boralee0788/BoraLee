import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Mall_execute {
	// ���δ�
	Scanner scan = new Scanner(System.in);
	ArrayList<Member> m = new ArrayList<Member>();
//	ArrayList<Login> l= new ArrayList<Login>();
	HashMap map = new HashMap();
	ArrayList<Buy> buy_list = new ArrayList<Buy>();
	String current_id = "";

// ������ ����------------------------------------------------------------------------
	void manager() {
		m.add(new Member("admin","admin123", "������", "02"));
	}
	
	
// ȸ������ ---------------------------------------------------------------------------------------------------	
	void input() {

		Loop1:
		while (true) {
			System.out.println("���̵� �Է��ϼ���.>> (����ȭ��:99)");
			String id = scan.nextLine();

			if (id.equals("99")) {
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				break;
			}

			if (id.length() < 3) {
				System.out.println("���̵�� 3�ڸ� �̻����� �Է����ּ���.");
				continue;
			}

			for (int i = 0; i < m.size(); i++) {
				Member m1 = (Member) m.get(i);
					if (m1.id.equals(id)) {
						System.out.println("�̹� �����ϴ� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
						continue Loop1;
					}
				}

			System.out.println("��й�ȣ�� �Է��ϼ���.>>");
			String pw = scan.nextLine();
			if (pw.length() < 5) {
				System.out.println("��й�ȣ�� 5�ڸ� �̻����� �Է����ּ���.");
				continue;
			}

			System.out.println("�̸��� �Է��ϼ���.>>");
			String name = scan.nextLine();

			System.out.println("��ȭ��ȣ�� �Է��ϼ���.>>");
			String tel = scan.nextLine();

			m.add(new Member(id, pw, name, tel));

		}
	}

// �α���	 ---------------------------------------------------------------------------------------------------
	void login() {

		if (!(map.isEmpty())) {
			System.out.println("�̹� �α����� �Ǿ� �ֽ��ϴ�.");
			return;
		}

		while (true) {
			String id_check="";
			String pw_check ="";
			System.out.println("���̵� �Է��ϼ���.>> (����ȭ��: 99)");
			id_check = scan.nextLine();

			if (id_check.equals("99")) {
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				break;
			}

			boolean check1 = false;
			boolean check2 = false;
			for (int i = 0; i < m.size(); i++) {
				Member m1 = (Member) m.get(i);
				if (id_check.equals(m1.id)) {
					check1 = true;
					System.out.println("��й�ȣ�� �Է��ϼ���.>>");
					pw_check = scan.nextLine();
					if (pw_check.equals(m1.pw)) {
						check2 = true;
						System.out.println("�α����� �Ǿ����ϴ�.");
						
					}
				}
			}

			if (check1 == false) {
				System.out.println("��ġ�ϴ� ���̵� �����ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}

			if (check2 == false) {
				System.out.println("pw�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
				continue;
			}
			map.put(id_check, pw_check);
			current_id = id_check;
			return;
		}
	}


// �α��� ���� Ȯ�� ---------------------------------------------------------------------------------------------------
	boolean login_check() {
		boolean check = true;
		if (map.isEmpty()) {
			check = false;
		}
		return check;
	}
	
	

// �α׾ƿ� ---------------------------------------------------------------------------------------------------
	void logout() {

		if (map.isEmpty()) {
			System.out.println("�α����� �Ǿ����� �ʽ��ϴ�.");
		} else {
			System.out.println("�α׾ƿ��� �Ͻðڽ��ϱ�?(y/n)");
			String yn = scan.nextLine();

			if (yn.equalsIgnoreCase("y")) {
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
				map.clear();
			} else if (yn.equalsIgnoreCase("n")) {
				System.out.println("���� �������� �̵��մϴ�.");
				return;
			}
		}

//			Iterator<Login> it = map.entrySet().iterator();
//			
//			while(true){
//				System.out.println("���̵� �Է��ϼ���.>> (����ȭ��:99)");
//				String id_logout = scan.nextLine();
//				
//				if(id_logout.equals("99")) {
//					System.out.println("���� ȭ������ ���ư��ϴ�.");
//					break;
//				}
//				
//				if(!(map.containsKey(id_logout))) {
//					System.out.println("��ġ�ϴ� ���̵� �����ϴ�. �α����� ���ּ���.");
//					break;
//				}
//				
//				System.out.println("��й�ȣ�� �Է��ϼ���.>>");
//				String pw_logout = scan.nextLine();
//				
//				if(!(map.containsKey(pw_logout))) {
//					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
//					continue;
//				} else {
//					System.out.println("�α׾ƿ��� �Ǿ����ϴ�.");
//					map.remove(id_logout);
//				}

	}

// ȸ�� ���� �˻�	 ---------------------------------------------------------------------------------------------------
	void search() {
		String[] list = { "���̵�", "��й�ȣ", "�̸�", "��ȭ��ȣ", "�����ݾ�", "���ʽ�����Ʈ" };
		while (true) {
			System.out.println("�˻��Ͻ� �̸��� �Է����ּ���. �̸��� �� ���ڸ� �Է��ϼŵ� �˴ϴ�.>> (���� ȭ��:99)");
			String name_search = scan.nextLine();

			if (name_search.equals("99")) {
				System.out.println("���� ȭ������ ���ư��ϴ�.");
				break;
			}
			
			for (int i = 0; i < list.length; i++) {
				System.out.print(list[i] + "\t");
			}
			System.out.println();

			boolean check = false;
			for (int i = 0; i < m.size(); i++) {
				Member m1 = (Member) m.get(i);
				if (m1.name.contains(name_search)) {
					check = true;
					System.out.println(m1.id + "\t" + m1.pw+"\t"+ m1.name + "\t" + m1.tel + "\t" + m1.money + "\t" + m1.bonusPoint);
				}
			}
			if (check == false) {
				System.out.println("ã���ô� �̸��� �����ϴ�. �ٽ� �˻����ּ���.");
				continue;
			}
		}
	}

// ȸ�� ���� ���	 (�̸�������) ---------------------------------------------------------------------------------------------------
	void prit_member() {
		String[] list = { "���̵�", "��й�ȣ", "�̸�", "��ȭ��ȣ", "�����ݾ�", "���ʽ�����Ʈ" };
		Collections.sort(m, new Comparator<Member>() {

			@Override
			public int compare(Member m1, Member m2) {
				// TODO Auto-generated method stub
				return m1.name.compareTo(m2.name);
			}
		});

		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + "\t");
		}
		System.out.println();

		for (int i = 0; i < m.size(); i++) {
			Member m1 = (Member) m.get(i);
			System.out.println(m1.id + "\t" + m1.pw+"\t"+ m1.name + "\t" + m1.tel + "\t" + m1.money + "\t" + m1.bonusPoint);
		}
	}

	
	
// TV ���� ---------------------------------------------------------------------------------------------------	

	void buy_tv(TV t) {

		System.out.println("��ǰ��: " + t.name);
		System.out.println("����: " + t.price);
		System.out.println("��ũ��: " + t.screen);
		System.out.println("��ġ: " + t.inch);

		for (int i = 0; i < m.size(); i++) {
			Member m3 = (Member) m.get(i);
			if (m3.id.equals(current_id)) {
				if (m3.money < t.price) {
					System.out.println("�ݾ��� �����մϴ�. �������ּ���.");
					return;
				}
				m3.money -= t.price;
				m3.bonusPoint += t.bonusPoint;
				buy_list.add(new Buy(current_id,t.name, t.price, t.bonusPoint));
				System.out.println(t.name + " 1�븦 �����߽��ϴ�.");
			}
		}
	}

// Ref ���� ---------------------------------------------------------------------------------------------------

	void buy_ref(Ref r) {

		System.out.println("��ǰ��: " + r.name);
		System.out.println("����: " + r.price);
		System.out.println("�뷮: " + r.liter);
		System.out.println("�� ����: " + r.door);

		int money = 0;

		for (int i = 0; i < m.size(); i++) {
			Member m3 = (Member) m.get(i);
			if (m3.id.equals(current_id)) {
				if (m3.money < r.price) {
					System.out.println("�ݾ��� �����մϴ�. �������ּ���.");
					return;
				}
				m3.money -= r.price;
				m3.bonusPoint += r.bonusPoint;
				buy_list.add(new Buy(current_id, r.name, r.price, r.bonusPoint));
				System.out.println(r.name + " 1�븦 �����߽��ϴ�.");;
			}
		}

	}
	
	
// WM ���� ---------------------------------------------------------------------------------------------------

	void buy_wm(WM w) {

		System.out.println("��ǰ��: " + w.name);
		System.out.println("����: " + w.price);
		System.out.println("������: " + w.size);
		System.out.println("���: " + w.shape);

		for (int i = 0; i < m.size(); i++) {
			Member m3 = (Member) m.get(i);
			if (m3.id.equals(current_id)) {

				if (m3.money < w.price) {
					System.out.println("�ݾ��� �����մϴ�. �������ּ���.");
					return;
				} else {
					m3.money -= w.price;
					m3.bonusPoint += w.bonusPoint;
					buy_list.add(new Buy(current_id, w.name, w.price, w.bonusPoint));
					System.out.println(w.name + " 1�븦 �����߽��ϴ�.");
				}
				
			}
		}
	}
	

// ���Ÿ�� ��� ---------------------------------------------------------------------------------------------------

	void print_buy() {
		
		String[] subject = {"���̵�", "��ǰ��", "����", "����Ʈ", "��������"};
		String[] subject2 = {"���̵�", "�� ���űݾ�","�� ���Ű���"};
		
		if (map.isEmpty()) {
			System.out.println("�α����� �Ǿ����� �ʽ��ϴ�. �α����� �������ּ���.");
			return;
		}
		
		int sum = 0;
		int count = 0;
		if(current_id.equals("admin")) {
			for(int i=0;i<subject.length;i++) {
				System.out.print(subject[i]+"\t");
			}
			System.out.println();
				
			for(int j=0; j<buy_list.size();j++) {
				Buy b1 = (Buy)buy_list.get(j);
				System.out.println(b1.id+"\t"+b1.name+"\t"+b1.price+"\t"+b1.bonusPoint+"\t"+b1.date);
				sum +=b1.price;
				count++;
			}
			
			System.out.println();
			System.out.println("-----------------------------------------------------------------------");

			System.out.println("�� ���űݾ�: "+sum);
			System.out.println("�� ���Ű���: "+count);
		} else {
			for(int i=0;i<subject.length;i++) {
				System.out.print(subject[i]+"\t");
			}
			System.out.println();
			
			
			for(int j=0; j<buy_list.size();j++) {
				Buy b2 = (Buy)buy_list.get(j);
				if(b2.id.equals(current_id)) {
					System.out.println(b2.id+"\t"+b2.name+"\t"+b2.price+"\t"+b2.bonusPoint+"\t"+b2.date);
					sum +=b2.price;
					count++;
				}
			}
			System.out.println();
			System.out.println("-----------------------------------------------------------------------");
			
			System.out.println("�� ���űݾ�: "+sum);
			System.out.println("�� ���Ű���: "+count);
		}
	}
			
}
