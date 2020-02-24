
public class Student {
	
	int hak_num;
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float avg;
	
	
	Student(){  // 생성자는 클래스명과 동일한 메소드명을 갖고, return 값이 없지만 앞에 void를 붙이지 않음
		name = "test";
		kor = 50;
		eng = 50;
		math = 50;
	}
	
	
	Student(String n, int k, int e, int m){
		name = n;
		kor = k;
		eng = e;
		math = m;
		total = k+e+m;
		avg = total/3;
	}
	
}
