import java.util.ArrayList;
import java.util.Scanner;

public class Ex0302_03 {

	public static void main(String[] args) {
		// �л������Է�

		String name = "";
		String major = "";
		int grade = 0;
		String tel = "";
		ArrayList<Stu_Info> list = new ArrayList<Stu_Info>();

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {

		}

		while (true) {
			System.out.println("1) �л������Է�  2) ���  3) �˻�");
			int num = scan.nextInt();
			scan.nextLine();

			switch (num) {
			case 1:
				while (true) {
					System.out.println("�̸��� �Է����ּ���.>>(���� ȭ��:99)");
					name = scan.nextLine();
					if (name.equals("99")) {
						System.out.println("���� ȭ������ ���ư��ϴ�.");
						break;
					}
					System.out.println("�а��� �Է����ּ���.>>");
					major = scan.nextLine();
					System.out.println("�г��� �Է����ּ���.>>");
					grade = scan.nextInt();
					scan.nextLine();
					System.out.println("��ȭ��ȣ�� �Է����ּ���.>>");
					tel = scan.nextLine();

					list.add(new Stu_Info(name, major, grade, tel)); // ��ü�� �ֱ�
				}

				break;

			case 2:
				if (list.isEmpty()) {
					System.out.println("�Էµ� �л� ������ �����ϴ�.");

				} else {
					System.out.println("�й�" + "\t" + "�̸�" + "\t" + "�а�" + "\t" + "�г�" + "\t" + "��ȭ");
					for (int i = 0; i < list.size(); i++) {
						Stu_Info info = (Stu_Info) list.get(i);
						System.out.println(info);

					}
				}

				break;

			case 3:

				int check = 0;
				while (true) {
					System.out.println("�˻��� �̸��� �Է��ϼ���.>>(���� ȭ��:99)");
					String name2 = scan.nextLine();
					if (name2.equals("99")) {
						System.out.println("���� ȭ������ ���ư��ϴ�.");
						break;
					}
					for (int i = 0; i < list.size(); i++) {
						Stu_Info info = (Stu_Info) list.get(i);
						if (name2.equals(info.name)) {
							check++;
							System.out.println("ã�� �л��� ");
							System.out.println("�й�" + "\t" + "�̸�" + "\t" + "�а�" + "\t" + "�г�" + "\t" + "��ȭ");
							System.out.println(info.hak_num + "\t" + info.name + "\t" + info.major + "\t" + info.grade
									+ "\t" + info.tel);
						}
					}
					if (check == 0) {
						System.out.println("ã�� �л��� ������ �����ϴ�.");
					}
				}

				break;

			default:
				break;
			}
		}

	}

}
