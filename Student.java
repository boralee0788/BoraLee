
public class Student {
	
	int hak_num;
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float avg;
	
	
	Student(){  // �����ڴ� Ŭ������� ������ �޼ҵ���� ����, return ���� ������ �տ� void�� ������ ����
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
