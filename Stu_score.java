
public class Stu_score {
	
	int hak_num;
	String name;
	int kor;
	int eng;
	int total;
	float avg;
	int rank;
	
	Stu_score(){
		
	}
	
	Stu_score(int hak_num, String name, int kor, int eng){
		this.hak_num = hak_num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.total = kor+eng;
		this.avg = (float)total/2;
		
	}
	
	}
