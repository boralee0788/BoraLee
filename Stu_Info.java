
public class Stu_Info {
	
	// �л�����
	// �й�, �̸�, �а�, �г�, ��ȭ��ȣ
	
	static int count=0;
	int hak_num;
	String name;
	String major;
	int grade;
	String tel;
	
	{
		hak_num = ++count;
	}
	
	Stu_Info(){
		
	}
	
	Stu_Info(String name, String major, int grade, String tel){
		this.name = name;
		this.major = major;
		this.grade = grade;
		this.tel = tel;
	}
	
	public String toString() {
	 return hak_num+"\t"+name+"\t"+major+"\t"+grade+"\t"+tel+"\t";
	}
}
