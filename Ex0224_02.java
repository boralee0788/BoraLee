import java.util.Scanner;

public class Ex0224_02 {

	public static void main(String[] args) {
		// 2명의 학생 - 홍길동 , 100, 100, 90 / 이순신, 80, 90, 70
		// 기본 생성자는  test, 50, 50, 50


		Student[] stu = new Student[2];
		int[] score = new int[3];
		int stu_count = 0;
		
		
		stu_count = input(stu,score);
				
		for(int i=0; i<stu_count;i++) {
			System.out.println(stu[i].name+"/"+stu[i].total+"/"+stu[i].avg);
		}
		System.out.println("입력된 학생 수: "+stu_count);
		
		
		
//		Student stu = new Student();
//		Student stu1 = new Student("홍길동",100,100,90);
//		Student stu2 = new Student("이순신", 80,90, 70);
//				
//		System.out.println(stu1.name+"/"+stu1.kor+"/"+stu1.eng+"/"+stu1.math+"/"+stu1.total+"/"+stu1.avg);
//		System.out.println(stu2.name+"/"+stu2.kor+"/"+stu2.eng+"/"+stu2.math+"/"+stu2.total+"/"+stu2.avg);
	}
	
	static int input(Student[] stu, int[] score) {
		Scanner scan = new Scanner(System.in);
		int stu_count = 0;
		for(int i=0;i<stu.length;i++) {
			stu[i] = new Student(); // 기본 생성자
			System.out.println("이름을 입력하세요.>>");
			String name = scan.nextLine();
			for(int j=0;j<score.length;j++) {
				System.out.println("점수를 입력하세요.>>");
				score[j] = scan.nextInt();
				scan.nextLine();
			}
			stu[i] = new Student(name,score[0],score[1],score[2]); // 매개변수 있는 생성자
			stu_count++;
		}
		
		return stu_count;
		

	}

}
