import java.util.Scanner;

public class Ex0219_06 {

	public static void main(String[] args) {

//		Card c1 = new Card();
//		
//		c1.num = 10;
//		c1.kind = "클로버";
//		
//		System.out.println(c1.num+" "+c1.kind);

//		Card c1 = new Card(10, "클로버");           
//		System.out.println(c1.num+" "+c1.kind);
//		
//		Card c2 = new Card();  // Card 클래스에 기본 생성자 Card() {} 가 있어야 함

		// Card 클래스를 52장의 배열을 만들어서 1~13까지를 숫자를 집어넣고, 무늬는 4종류

//		for(int i=0;i<13;i++) {
//			Card c1 = new Card(i+1, "클로버");
//			System.out.println(c1.num+" "+c1.kind);
//		}
//		
//
//		
//		String[] kind = {"클로버", "다이아몬드", "하트", "스페이드"};
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

		// 성적처리

//		Student[] stu = new Student[2];
//		Scanner scan = new Scanner(System.in);
//		String name = "";
//		int kor = 0, eng =0, math=0;
//		
//		for(int i=0;i<stu.length;i++) {
//			System.out.println("이름을 입력하세요.");
//			name = scan.nextLine();
//			System.out.println("국어점수를 입력하세요.");
//			kor = scan.nextInt();
//			System.out.println("영어점수를 입력하세요.");
//			eng = scan.nextInt();
//			System.out.println("수학점수를 입력하세요.");
//			math = scan.nextInt();
//			scan.nextLine();
//			stu[i] = new Student(name, kor, eng, math);
//			System.out.println(stu[i].name+" "+stu[i].total+" "+stu[i].avg);
//		}

		// 1. 학생점수 입력
		// 2. 학생수정
		// 3. 학생삭제
		// 4. 학생검색
		// 5. 등수처리
		// 6. 종료

		Scanner scan = new Scanner(System.in);
		Student[] stu = new Student[10];
		String name = "";
		int select = 0, kor = 0, eng = 0, math = 0, count = 0;
		String[] subject = { "이름", "국어", "영어", "수학", "함계", "평균", "등수" };
		int check = 0;

		Loop1: while (true) {
			System.out.println("[ 학생성적처리 프로그램 ]");
			System.out.println("--------------------");
			System.out.println("1. 학생점수입력");
			System.out.println("2. 학생수정");
			System.out.println("3. 학생삭제");
			System.out.println("4. 학생검색");
			System.out.println("5. 등수처리");
			System.out.println("6. 종료");

			System.out.println("원하는 번호를 입력하세요.>>");
			select = scan.nextInt();
			scan.nextLine();

			switch (select) {

			case 1:
				System.out.println("[ 학생 점수 입력 ]");
				for (int i = count; i < stu.length; i++) {
					System.out.println((i + 1) + "번째 학생 이름을 입력하세요.(이전화면:99)");
					name = scan.nextLine();
					if (name.equals("99")) {
						i--;
						break;
					}
					System.out.println((i + 1) + "번째 학생 국어점수를 입력하세요.");
					kor = scan.nextInt();
					System.out.println((i + 1) + "번째 학생 영어점수를 입력하세요.");
					eng = scan.nextInt();
					System.out.println((i + 1) + "번째 학생 수학점수를 입력하세요.");
					math = scan.nextInt();
					scan.nextLine();
					stu[i] = new Student(name, kor, eng, math);
					count++;
				}
				break;

			case 2:
				System.out.println("[ 학생 성적 수정 ]");
				System.out.println("수정하려는 학생의 이름을 입력하세요.");
				name = scan.nextLine();

				Loop3: for (int i = 0; i < count; i++) {
					if (stu[i].name.equals(name)) {
						System.out.println(stu[i].name + "의 학생이 검색되었습니다. 수정하고 싶은 번호를 입력하세요.");
						System.out.println("1. 국어점수 2. 영어점수 3. 수학점수");
						select = scan.nextInt();
						scan.nextLine();

						switch (select) {
						case 1:
							System.out.println("국어 점수를 수정해주세요.");
							stu[i].kor = scan.nextInt();
							scan.nextLine();
							System.out.println("국어점수가 " + stu[i].kor + "로 변경되었습니다.");
							continue Loop1;

						case 2:
							System.out.println("영어 점수를 수정해주세요.");
							stu[i].eng = scan.nextInt();
							scan.nextLine();
							System.out.println("영어점수가 " + stu[i].eng + "로 변경되었습니다.");
							continue Loop1;

						case 3:
							System.out.println("수학 점수를 수정해주세요.");
							stu[i].math = scan.nextInt();
							scan.nextLine();
							System.out.println("수학점수가 " + stu[i].math + "로 변경되었습니다.");
							continue Loop1;

						default:
							break;
						}
					}
				}
				System.out.println("찾으시는 학생이 없습니다. 다시 입력해주세요.");

				break;

			case 3:

				break;

			case 4:
				while (true) {
					System.out.println("[ 학생 검색 ]");
					System.out.println("찾으시는 학생의 이름을 입력하세요.>> (상위이동: 99)");
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
						System.out.println("찾으시는 학생의 정보가 없습니다. 다시 검색해주세요.");
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
