import java.util.Scanner;

public class Ex0224_04 {

	public static void main(String[] args) {
		// 3�� �л��� �Է� �޾Ƽ�, �й�/�̸�/����/����/����/�հ�/���/��� 
		// �й��� 1���� 1�� �ڵ� ���� �Է�
		// �Է� �κ��� �޼ҵ�� �и�
		// ��� �κ� �޼ҵ�� �и�
		// ��� ��� �޼ҵ�� �и�
		// 1. �л��Է�
		// 2. �л��������
		// 3. �л���������
		// 4. �л�����Է�
		// 5. ����

		int select = 0;
		int s_count = 0;
		StuScore[] ss = new StuScore[3];
		String[] subject = {"�й�", "�̸�", "����", "����", "����", "�հ�", "���", "���"};
		int[] score = new int[3];
		
		Scanner scan = new Scanner(System.in);
		
		Loop1:
		while(true) {
			select = mainPrint();
			
			switch (select) {
			case 1:
				s_count = scoreInput(ss, s_count, score, subject);
				break;
				
			case 2:
				scorePrint(ss, s_count, subject);
				break;
				
			case 3:
				scoreChange(ss, s_count);
				break;
				
			case 4:
				rank(ss, subject, s_count);
				break;
				
			case 5:
				System.out.println("�ý����� �����մϴ�.");
				break Loop1;

			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
				break;
			}
			
		}
		
	}
	
	static int mainPrint() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("1. �л��Է�");
		System.out.println("2. �л��������");
		System.out.println("3. �л���������");
		System.out.println("4. �л�����Է�");
		System.out.println("5. ����");
		System.out.println("-------------------------");
		System.out.println("���ϴ� ��ȣ�� �Է����ּ���.");
		int select = scan.nextInt();
		return select;
	}
	
	static int scoreInput(StuScore[] ss, int s_count, int[] score, String[] subject) {
		Scanner scan = new Scanner(System.in);
		Loop1:
		while(true) {
			
			System.out.println("[�л��Է�]");
			for(int i=s_count;i<ss.length;i++) {
				System.out.println((i+1)+"��° �л� �̸��� �Է����ּ���.(�����̵�: 99)");
				String name = scan.next();
				if(name.equals("99")) {
					i--;
					break Loop1;
				}
				for(int j=0; j<score.length;j++) {
					System.out.println(subject[j+2]+"������ �Է����ּ���.");
					score[j] = scan.nextInt();
				}
				ss[i] = new StuScore(name, score[0], score[1], score[2]);
				s_count++;
			}
			break;
		}
		return s_count;
	}
	
	static void scorePrint(StuScore[] ss, int s_count, String[] subject) {
		System.out.println("[�л��������]");
		System.out.println("********************************");
	
		for(int i=0;i<subject.length-1;i++) {
			System.out.print(subject[i]+"\t");
		}
		System.out.println();
		
		for(int i=0;i<s_count;i++) {
			System.out.print(ss[i].stuNo+"\t"+ss[i].name+"\t"+ss[i].kor+"\t"+ss[i].eng+"\t"+ss[i].math+"\t"+ss[i].total+"\t"+ss[i].avg);
			System.out.println();
		}
	}
	
	static void scoreChange(StuScore[] ss, int s_count) {
		Scanner scan = new Scanner(System.in);
		int check = 0;
		while(true) {
			
			System.out.println("[�л���������]");
			System.out.println("********************************");
			System.out.println("�����ϰ� ���� �л��� �й��� �Է��ϼ���.(�����̵�: 99)");
			check = scan.nextInt();
			
			if(check==99) {
				break;
			}
			
			Loop3:
			for(int i=0;i<ss.length;i++) {
				if(ss[i].stuNo==check) {
					System.out.println("1. �̸� / 2.�������� / 3.�������� / 4.�������� / 99. �����̵� ");
					System.out.println("�����ϰ� ���� ������ ��ȣ�� �Է��ϼ���.");
					
					switch (scan.nextInt()) {
					case 1:
						System.out.println("[�̸� ����]");
						System.out.println("�̸��� �ٽ� �Է����ּ���.");
						ss[i].name = scan.next();
						break Loop3;
						
					case 2:
						System.out.println("[�������� ����]");
						System.out.println("���������� �ٽ� �Է����ּ���.");
						ss[i].kor = scan.nextInt();
						ss[i].modify();
						break Loop3;
						
					case 3:
						System.out.println("[�������� ����]");
						System.out.println("���������� �ٽ� �Է����ּ���.");
						ss[i].eng = scan.nextInt();
						ss[i].modify();
						break Loop3;
						
					case 4:
						System.out.println("[�������� ����]");
						System.out.println("���������� �ٽ� �Է����ּ���.");
						ss[i].math = scan.nextInt();
						ss[i].modify();
						break Loop3;
						
					case 99:
						System.out.println("������ �̵�");
						
						break;
					default:
						System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
						break;
					}
				}
				
				if(!(check>=1 && check<=s_count)) {
					System.out.println("ã���ô� �й��� �л��� �����ϴ�.");
					break;
				}
			}
		}
	}
	
	
	static void rank(StuScore[] ss, String[] subject,int s_count) {
		for(int i=0;i<s_count;i++) {
			ss[i].rank = 1;
			for(int j=0; j<s_count; j++) {
				if(ss[i].total<ss[j].total) {
					ss[i].rank++;
				}
			}
		}
		
		
		for(int i=0;i<subject.length;i++) {
			System.out.print(subject[i]+"\t");
		}
		System.out.println();
		
		for(int i=0;i<s_count;i++) {
			System.out.print(ss[i].stuNo+"\t"+ss[i].name+"\t"+ss[i].kor+"\t"+ss[i].eng+"\t"+ss[i].math
					         +"\t"+ss[i].total+"\t"+ss[i].avg+"\t"+ss[i].rank);
			System.out.println();
		}
	}


}

