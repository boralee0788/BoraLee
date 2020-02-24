
public class StuScore {

	static int count;
	int stuNo;
	String name;
	int kor;
	int eng;
	int math;
	int total;
	float avg;
	int rank;
	
	{
		count++;
		stuNo = count;
	}

	StuScore(String n, int k, int e, int m) {

		name = n;
		kor = k;
		eng = e;
		math = m;
		total = k + e + m;
		avg = total / 3;

	}

	void modify() {
		total();
		avg();
		rank=0;
	}
	void total() {
		total = kor + eng + math;
	}
	
	void avg() {
		avg = total/3;
	}

}
