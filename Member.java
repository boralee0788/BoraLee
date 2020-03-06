
public class Member {
	// ¸í·É¾î

	String id;
	String pw;
	String name;
	String tel;
	int money = 100000;
	int bonusPoint;
	
	Member(){}
	
	Member(String id, String pw, String name, String tel){
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.money = 100000;
		this.bonusPoint=0;
	}
	
	
	
}
