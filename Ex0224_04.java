import java.util.Scanner;

public class Ex0224_04 {

	public static void main(String[] args) {
		// 3명 학생을 입력 받아서, 학번/이름/국어/영어/수학/합계/평균/등수 
		// 학번은 1에서 1씩 자동 증가 입력
		// 입력 부분은 메소드로 분리
		// 출력 부분 메소드로 분리
		// 등수 출력 메소드로 분리
		// 1. 학생입력
		// 2. 학생성적출력
		// 3. 학생성적수정
		// 4. 학생등수입력
		// 5. 종료

		int select = 0;
		int s_count = 0;
		StuScore[] ss = new StuScore[3];
		String[] subject = {"학번", "이름", "국어", "영어", "수학", "합계", "평균", "등수"};
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
				System.out.println("시스템을 종료합니다.");
				break Loop1;

			default:
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			
		}
		
	}
	
	static int mainPrint() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("1. 학생입력");
		System.out.println("2. 학생성적출력");
		System.out.println("3. 학생성적수정");
		System.out.println("4. 학생등수입력");
		System.out.println("5. 종료");
		System.out.println("-------------------------");
		System.out.println("원하는 번호를 입력해주세요.");
		int select = scan.nextInt();
		return select;
	}
	
	static int scoreInput(StuScore[] ss, int s_count, int[] score, String[] subject) {
		Scanner scan = new Scanner(System.in);
		Loop1:
		while(true) {
			
			System.out.println("[학생입력]");
			for(int i=s_count;i<ss.length;i++) {
				System.out.println((i+1)+"번째 학생 이름을 입력해주세요.(상위이동: 99)");
				String name = scan.next();
				if(name.equals("99")) {
					i--;
					break Loop1;
				}
				for(int j=0; j<score.length;j++) {
					System.out.println(subject[j+2]+"점수을 입력해주세요.");
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
		System.out.println("[학생성적출력]");
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
			
			System.out.println("[학생성적수정]");
			System.out.println("********************************");
			System.out.println("수정하고 싶은 학생의 학번을 입력하세요.(상위이동: 99)");
			check = scan.nextInt();
			
			if(check==99) {
				break;
			}
			
			Loop3:
			for(int i=0;i<ss.length;i++) {
				if(ss[i].stuNo==check) {
					System.out.println("1. 이름 / 2.국어점수 / 3.영어점수 / 4.수학점수 / 99. 상위이동 ");
					System.out.println("수정하고 싶은 내용의 번호를 입력하세요.");
					
					switch (scan.nextInt()) {
					case 1:
						System.out.println("[이름 수정]");
						System.out.println("이름을 다시 입력해주세요.");
						ss[i].name = scan.next();
						break Loop3;
						
					case 2:
						System.out.println("[국어점수 수정]");
						System.out.println("국어점수를 다시 입력해주세요.");
						ss[i].kor = scan.nextInt();
						ss[i].modify();
						break Loop3;
						
					case 3:
						System.out.println("[영어점수 수정]");
						System.out.println("영어점수를 다시 입력해주세요.");
						ss[i].eng = scan.nextInt();
						ss[i].modify();
						break Loop3;
						
					case 4:
						System.out.println("[수학점수 수정]");
						System.out.println("수학점수를 다시 입력해주세요.");
						ss[i].math = scan.nextInt();
						ss[i].modify();
						break Loop3;
						
					case 99:
						System.out.println("상위로 이동");
						
						break;
					default:
						System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
						break;
					}
				}
				
				if(!(check>=1 && check<=s_count)) {
					System.out.println("찾으시는 학번의 학생이 없습니다.");
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

