import java.util.Scanner;

public class Ex0219_06 {

	public static void main(String[] args) {

//		Card c1 = new Card();
//		
//		c1.num = 10;
//		c1.kind = "Ŭ�ι�";
//		
//		System.out.println(c1.num+" "+c1.kind);

//		Card c1 = new Card(10, "Ŭ�ι�");           
//		System.out.println(c1.num+" "+c1.kind);
//		
//		Card c2 = new Card();  // Card Ŭ������ �⺻ ������ Card() {} �� �־�� ��

		// Card Ŭ������ 52���� �迭�� ���� 1~13������ ���ڸ� ����ְ�, ���̴� 4����

//		for(int i=0;i<13;i++) {
//			Card c1 = new Card(i+1, "Ŭ�ι�");
//			System.out.println(c1.num+" "+c1.kind);
//		}
//		
//
//		
//		String[] kind = {"Ŭ�ι�", "���̾Ƹ��", "��Ʈ", "�����̵�"};
//		
//		Card[] c = new Card[52];
//		for(int i=0;i<4;i++) {
//			for(int j=0;j<13;j++) {
////				c[(i*13)+j] = new Card(j+1,kind[i]);
//				c[(i*13)+j] = new Card();
//				c[(i*13)+j].num = j+1;
//				c[(i*13)+j].kind = kind[i];
//			}
//		}
//		
//			for(int i=0;i<c.length;i++) {
//					System.out.println(c[i].num+" "+c[i].kind);
//				}

//		Lotto[] ball =new Lotto[45];
//			for(int i=0;i<l.length;i++) {
//				ball[i] = new Lotto();
//				ball[i].number = i+1;
//			}

//		Lotto[] l = new Lotto[45];
//		for(int i=0;i<l.length;i++) {
//			l[i] = new Lotto(i+1);
//			System.out.println(l[i].number);
//		}

		// ����ó��

//		Student[] stu = new Student[2];
//		Scanner scan = new Scanner(System.in);
//		String name = "";
//		int kor = 0, eng =0, math=0;
//		
//		for(int i=0;i<stu.length;i++) {
//			System.out.println("�̸��� �Է��ϼ���.");
//			name = scan.nextLine();
//			System.out.println("���������� �Է��ϼ���.");
//			kor = scan.nextInt();
//			System.out.println("���������� �Է��ϼ���.");
//			eng = scan.nextInt();
//			System.out.println("���������� �Է��ϼ���.");
//			math = scan.nextInt();
//			scan.nextLine();
//			stu[i] = new Student(name, kor, eng, math);
//			System.out.println(stu[i].name+" "+stu[i].total+" "+stu[i].avg);
//		}

		// 1. �л����� �Է�
		// 2. �л�����
		// 3. �л�����
		// 4. �л��˻�
		// 5. ���ó��
		// 6. ����

		Scanner scan = new Scanner(System.in);
		Student[] stu = new Student[10];
		String name = "";
		int select = 0, kor = 0, eng = 0, math = 0, count = 0;
		String[] subject = { "�̸�", "����", "����", "����", "�԰�", "���", "���" };
		int check = 0;

		Loop1: while (true) {
			System.out.println("[ �л�����ó�� ���α׷� ]");
			System.out.println("--------------------");
			System.out.println("1. �л������Է�");
			System.out.println("2. �л�����");
			System.out.println("3. �л�����");
			System.out.println("4. �л��˻�");
			System.out.println("5. ���ó��");
			System.out.println("6. ����");

			System.out.println("���ϴ� ��ȣ�� �Է��ϼ���.>>");
			select = scan.nextInt();
			scan.nextLine();

			switch (select) {

			case 1:
				System.out.println("[ �л� ���� �Է� ]");
				for (int i = count; i < stu.length; i++) {
					System.out.println((i + 1) + "��° �л� �̸��� �Է��ϼ���.(����ȭ��:99)");
					name = scan.nextLine();
					if (name.equals("99")) {
						i--;
						break;
					}
					System.out.println((i + 1) + "��° �л� ���������� �Է��ϼ���.");
					kor = scan.nextInt();
					System.out.println((i + 1) + "��° �л� ���������� �Է��ϼ���.");
					eng = scan.nextInt();
					System.out.println((i + 1) + "��° �л� ���������� �Է��ϼ���.");
					math = scan.nextInt();
					scan.nextLine();
					stu[i] = new Student(name, kor, eng, math);
					count++;
				}
				break;

			case 2:
				System.out.println("[ �л� ���� ���� ]");
				System.out.println("�����Ϸ��� �л��� �̸��� �Է��ϼ���.");
				name = scan.nextLine();

				Loop3: for (int i = 0; i < count; i++) {
					if (stu[i].name.equals(name)) {
						System.out.println(stu[i].name + "�� �л��� �˻��Ǿ����ϴ�. �����ϰ� ���� ��ȣ�� �Է��ϼ���.");
						System.out.println("1. �������� 2. �������� 3. ��������");
						select = scan.nextInt();
						scan.nextLine();

						switch (select) {
						case 1:
							System.out.println("���� ������ �������ּ���.");
							stu[i].kor = scan.nextInt();
							scan.nextLine();
							System.out.println("���������� " + stu[i].kor + "�� ����Ǿ����ϴ�.");
							continue Loop1;

						case 2:
							System.out.println("���� ������ �������ּ���.");
							stu[i].eng = scan.nextInt();
							scan.nextLine();
							System.out.println("���������� " + stu[i].eng + "�� ����Ǿ����ϴ�.");
							continue Loop1;

						case 3:
							System.out.println("���� ������ �������ּ���.");
							stu[i].math = scan.nextInt();
							scan.nextLine();
							System.out.println("���������� " + stu[i].math + "�� ����Ǿ����ϴ�.");
							continue Loop1;

						default:
							break;
						}
					}
				}
				System.out.println("ã���ô� �л��� �����ϴ�. �ٽ� �Է����ּ���.");

				break;

			case 3:

				break;

			case 4:
				while (true) {
					System.out.println("[ �л� �˻� ]");
					System.out.println("ã���ô� �л��� �̸��� �Է��ϼ���.>> (�����̵�: 99)");
					name = scan.nextLine();

					if (name.equals("99")) {
						break;
					}

					for (int i = 0; i < count; i++) {
						if (stu[i].name.equals(name)) {
							check = i;
						}
					}

					if (check >= 0 && check < count) {

						for (int i = 0; i < subject.length; i++) {
							System.out.print(subject[i] + "\t");
						}
						System.out.println();

						System.out.println(
								stu[check].name + "\t" + stu[check].kor + "\t" + stu[check].eng + "\t" + stu[check].math
										+ "\t" + stu[check].total + "\t" + stu[check].avg + "\t" + stu[check].rank);
						break;
					} else {
						System.out.println("ã���ô� �л��� ������ �����ϴ�. �ٽ� �˻����ּ���.");
					}
				}
				break;

			case 5:
				for (int i = 0; i < count; i++) {
					stu[i].rank = 1;
					for (int j = 0; j < count; j++) {
						if (stu[i].total < stu[j].total) {
							stu[i].rank++;
						}
					}
				}

				for (int i = 0; i < subject.length; i++) {
					System.out.print(subject[i] + "\t");
				}
				System.out.println();

				for (int i = 0; i < count; i++) {
					System.out.println(stu[i].name + "\t" + stu[i].kor + "\t" + stu[i].eng + "\t" + stu[i].math + "\t"
							+ stu[i].total + "\t" + stu[i].avg + "\t" + stu[i].rank);
				}
				break;

			case 6:

				break;

			default:
				break;
			}

		}

	}

}
