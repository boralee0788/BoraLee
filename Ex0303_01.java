import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class Ex0303_01 {
	public static void main(String[]args) {
		int num = 0;
		Scanner scan = new Scanner(System.in);
		Main m = new Main();
		Student s = new Student();
		Stu_score sc = new Stu_score();
		
		Loop1:
		while(true) {
			subject();
			num = scan.nextInt();
			scan.nextLine();
			
			switch (num) {
			case 1:
				m.info_input(s);
				break;
				
			case 2:
				m.score_input(sc);
				break;
				
			case 3:
				m.print_info();
				break;
				
			case 4:
				m.print_score();
				break;
				
			case 5:
				m.serach_info();
				break;
				
			case 6:
				m.serach_score();
				break;
				
			case 0:
				System.out.println("�ý����� �����մϴ�.");
				break Loop1;

			default:
				break;
			}
		}
		
	}
	
	static void subject() {
		System.out.println("-----------------------------");
		System.out.println("	[�л����� ���α׷�]	");
		System.out.println("-----------------------------");
		System.out.println("1) �л������Է�");
		System.out.println("2) �л������Է�");
		System.out.println("3) �л��������");
		System.out.println("4) �л��������");
		System.out.println("5) �л������˻�");
		System.out.println("6) �л������˻�");
		System.out.println("0) ����");
		System.out.println("���Ͻô� ��ȣ�� �Է����ּ���.>>");
		
	}

}

class Main{
	
	String[] info_list = {"�й�", "�̸�", "�а�", "�г�"};
	String[] score_list = {"�й�", "�̸�", "����", "����", "�հ�", "���", "���"};
	
	ArrayList<Student> info = new ArrayList<Student>();
	ArrayList<Stu_score> score = new ArrayList<Stu_score>();
	
	Scanner scan = new Scanner(System.in);
	
	void info_input(Student s) {
		while(true) {
			System.out.println("[�л������Է�]");
			System.out.println("�й��� �Է����ּ���.>> (����ȭ��: 99)");
			s.hak_num = scan.nextInt();
			scan.nextLine();
			if(s.hak_num==99) {
				System.out.println("���� ȭ������ �̵��մϴ�.");
				break;
			}
			System.out.println("�̸��� �Է����ּ���.>>");
			s.name = scan.nextLine();
			System.out.println("�а��� �Է����ּ���.>>");
			s.major = scan.nextLine();
			System.out.println("�г��� �Է����ּ���.>>");
			s.grade = scan.nextInt();
			scan.nextLine();
			info.add(new Student(s.hak_num, s.name, s.major, s.grade));
		}
	}
	
	void score_input(Stu_score sc) {
		Loop2:
		while(true) {
			int count = 0;
			System.out.println("[�л������Է�]");
			System.out.println("�й��� �Է����ּ���.>> (����ȭ��:99)");
			sc.hak_num = scan.nextInt();
			scan.nextLine();
			if(sc.hak_num==99) {
				System.out.println("���� ȭ������ �̵��մϴ�.");
				break;
			}
			for(int i=0; i<info.size();i++) {
				Student s1 = (Student)info.get(i);
				if(sc.hak_num==s1.hak_num) {
					sc.name = s1.name;
					System.out.println("���������� �Է����ּ���.>>");
					sc.kor = scan.nextInt();
					if(!(sc.kor>=0 && sc.kor<=100)) {
						System.out.println("������ �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
						i--;
						continue;
					}
					System.out.println("���������� �Է����ּ���.>>");
					sc.eng = scan.nextInt();
					if(!(sc.eng>=0 && sc.eng<=100)) {
						System.out.println("������ �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
						i--;
						continue;
					}
					score.add(new Stu_score(sc.hak_num, sc.name, sc.kor, sc.eng));
					count++;
				}
			}
			if(count==0) {
				System.out.println("�Է��Ͻ� �й��� �����ϴ�. �л� ������ ���� �Է��ϼ���.");
				break Loop2;
			
			}
		}
	}
	
	void print_info() {
		System.out.println("[�л��������]");
		for(int i=0;i<info_list.length;i++) {
			System.out.print(info_list[i]+"\t");
		}
		System.out.println();
		
		for(int i=0;i<info.size();i++) {
			Student s2 = (Student)info.get(i);
			System.out.println(s2.hak_num+"\t"+s2.name+"\t"+s2.major+"\t"+s2.grade);
		}
	}
	
	void rank() {
		for(int i=0;i<score.size();i++) {
			int rank = 1;
			Stu_score sc = (Stu_score)score.get(i);
			for(int j=0;j<score.size();j++) {
				Stu_score sc1 = (Stu_score)score.get(j);
				if(sc.total<sc1.total) {
					rank++;
				}
			}
			sc.rank = rank;
		}
	}
	
	void print_score() {
		rank();

		System.out.println("[�л��������]");
		for(int i=0;i<score_list.length;i++) {
			System.out.print(score_list[i]+"\t");
		}
		System.out.println();
		
		for(int i=0;i<score.size();i++) {
			Stu_score sc2 = (Stu_score)score.get(i);
			System.out.println(sc2.hak_num+"\t"+sc2.name+"\t"+sc2.kor+"\t"+sc2.eng+"\t"+sc2.total+"\t"+sc2.avg+"\t"+sc2.rank);
		}
	}
	
	
	void serach_info() {
		int select=0;
		int hak_num=0;
		String name="";
		
		Loop3:
		while(true) {
			int count = 0;
			System.out.println("1)�й�  2)�̸�");
			System.out.println("���Ͻô� �˻� ����� �Է��ϼ���.>> (����ȭ��:99)");
			select = scan.nextInt();
			if(select==99) {
				System.out.println("���� ȭ������ �̵��մϴ�.");
				break Loop3;
			}
			switch (select) {
			case 1:
				System.out.println("ã���ô� �й��� �Է����ּ���.>>");
				hak_num = scan.nextInt();
				for(int i=0;i<info.size();i++) {
					Student s3 = (Student)info.get(i);
					if(hak_num==s3.hak_num) {
						for(int j=0;j<info_list.length;j++) {
							System.out.print(info_list[j]+"\t");
						}
						System.out.println();
						
						System.out.println(s3.hak_num+"\t"+s3.name+"\t"+s3.major+"\t"+s3.grade);
						count++;
					}
				}
				if(count==0) {
					System.out.println("ã���ô� �й��� �����ϴ�. �й��� �ٽ� �Է����ּ���.");
					break;
				}
				break;
				
			case 2:
				System.out.println("ã���ô� �̸��� �Է����ּ���.>>");
				name = scan.next();
				for(int i=0;i<info.size();i++) {
					Student s4 = (Student)info.get(i);
					if(name.equals(s4.name)) {
						for(int j=0;j<info_list.length;j++) {
							System.out.print(info_list[j]+"\t");
						}
						System.out.println();
						
						System.out.println(s4.hak_num+"\t"+s4.name+"\t"+s4.major+"\t"+s4.grade);
						count++;
					}
				}
				if(count==0) {
					System.out.println("ã���ô� �̸��� �����ϴ�. �̸��� �ٽ� �Է����ּ���.");
					break;
				}
				break;

			default:
				break;
			}
		}
	}
	
	void serach_score() {
		int select=0;
		int hak_num=0;
		String name="";
		
		Loop4:
		while(true) {
			int count=0;
			System.out.println("[�л������˻�]");
			System.out.println("1)�й�  2)�̸�");
			System.out.println("���Ͻô� �˻� ����� �Է��ϼ���.>> (����ȭ��:99)");
			select = scan.nextInt();
			if(select==99) {
				System.out.println("���� ȭ������ �̵��մϴ�.");
				break Loop4;
			}
			switch (select) {
			case 1:
				System.out.println("ã���ô� �й��� �Է����ּ���.>>");
				hak_num = scan.nextInt();
				for(int i=0;i<score.size();i++) {
					Stu_score sc3 = (Stu_score)score.get(i);
					if(hak_num==sc3.hak_num) {
						for(int j=0;j<score_list.length;j++) {
							System.out.print(score_list[j]+"\t");
						}
						System.out.println();
						
						System.out.println(sc3.hak_num+"\t"+sc3.name+"\t"+sc3.kor+"\t"+sc3.eng+"\t"+sc3.total+"\t"+sc3.avg+"\t"+sc3.rank);
						count++;
					}
				}
				if(count==0) {
					System.out.println("ã���ô� �й��� �����ϴ�. �й��� �ٽ� �Է����ּ���.");
					break;
				}
				
				break;
				
			case 2:
				System.out.println("ã���ô� �̸��� �Է����ּ���.>>");
				name = scan.next();
				for(int i=0;i<score.size();i++) {
					Stu_score sc4 = (Stu_score)score.get(i);
					if(name.equals(sc4.name)) {
						for(int j=0;j<score_list.length;j++) {
							System.out.print(score_list[j]+"\t");
						}
						System.out.println();
						
						System.out.println(sc4.hak_num+"\t"+sc4.name+"\t"+sc4.kor+"\t"+sc4.eng+"\t"+sc4.total+"\t"+sc4.avg+"\t"+sc4.rank);					
						count++;
					}
				}
			if(count==0) {
				System.out.println("ã���ô� �̸��� �����ϴ�. �̸��� �ٽ� �Է����ּ���.");
				break;
			}
				break;
				
				default:
					break;
			}
		}
	}
	
}
