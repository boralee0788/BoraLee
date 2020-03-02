import java.util.ArrayList;
import java.util.Scanner;

public class Ex0302_03 {

	public static void main(String[] args) {
		// 학생정보입력

		String name = "";
		String major = "";
		int grade = 0;
		String tel = "";
		ArrayList<Stu_Info> list = new ArrayList<Stu_Info>();

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {

		}

		while (true) {
			System.out.println("1) 학생정보입력  2) 출력  3) 검색");
			int num = scan.nextInt();
			scan.nextLine();

			switch (num) {
			case 1:
				while (true) {
					System.out.println("이름을 입력해주세요.>>(이전 화면:99)");
					name = scan.nextLine();
					if (name.equals("99")) {
						System.out.println("이전 화면으로 돌아갑니다.");
						break;
					}
					System.out.println("학과를 입력해주세요.>>");
					major = scan.nextLine();
					System.out.println("학년을 입력해주세요.>>");
					grade = scan.nextInt();
					scan.nextLine();
					System.out.println("전화번호를 입력해주세요.>>");
					tel = scan.nextLine();

					list.add(new Stu_Info(name, major, grade, tel)); // 객체에 넣기
				}

				break;

			case 2:
				if (list.isEmpty()) {
					System.out.println("입력된 학생 정보가 없습니다.");

				} else {
					System.out.println("학번" + "\t" + "이름" + "\t" + "학과" + "\t" + "학년" + "\t" + "전화");
					for (int i = 0; i < list.size(); i++) {
						Stu_Info info = (Stu_Info) list.get(i);
						System.out.println(info);

					}
				}

				break;

			case 3:

				int check = 0;
				while (true) {
					System.out.println("검색할 이름을 입력하세요.>>(이전 화면:99)");
					String name2 = scan.nextLine();
					if (name2.equals("99")) {
						System.out.println("이전 화면으로 돌아갑니다.");
						break;
					}
					for (int i = 0; i < list.size(); i++) {
						Stu_Info info = (Stu_Info) list.get(i);
						if (name2.equals(info.name)) {
							check++;
							System.out.println("찾는 학생은 ");
							System.out.println("학번" + "\t" + "이름" + "\t" + "학과" + "\t" + "학년" + "\t" + "전화");
							System.out.println(info.hak_num + "\t" + info.name + "\t" + info.major + "\t" + info.grade
									+ "\t" + info.tel);
						}
					}
					if (check == 0) {
						System.out.println("찾는 학생의 정보가 없습니다.");
					}
				}

				break;

			default:
				break;
			}
		}

	}

}
