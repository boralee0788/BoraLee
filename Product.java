
public class Product {

	String name;
	int price;
	int bonusPoint;
	
	Product(){}
	Product(String name, int price){
		this.name = name;
		this.price = price;
		this.bonusPoint = (int)(price*0.1);
	}
	
}

class TV extends Product{
	
	String screen;
	int inch;
	
	TV(){}
	TV(String name, int price, String screen, int inch) {
		this.name = name;
		this.price = price;
		this.bonusPoint = (int)(price*0.1);
		this.screen = screen;
		this.inch = inch;
	}
	
}

class LCD extends TV{
	
	LCD(){
		super("LCD TV", 10000, "LCD", 42);
	}
}
	
class LED extends TV{
	
	LED(){
		super("LED TV", 13000, "LED", 50);
	}
}

class OLED extends TV{
	
	OLED(){
		super("OLED TV", 15000, "OLED", 64);
	}
	
	void hdr() {
		System.out.println("hdr ����� �ֽ��ϴ�.");
	}
}

class Ref extends Product{
	int liter;
	int door;
	
	Ref(){}
	Ref(String name, int price, int liter, int door){
		this.name = name;
		this.price = price;
		this.bonusPoint = (int)(price*0.1);
		this.liter = liter;
		this.door = door;
	}
	
	void dcooling() {
		System.out.println("����ð� ����� �ֽ��ϴ�.");
	}
}

class Ref1 extends Ref{
	
	Ref1(){
		super("�Ϲ� �����", 20000, 500, 1);
	}
}

class Ref2 extends Ref{
	
	Ref2(){
		super("�繮�� �����", 25000, 800, 2);
	}
}

class WM extends Product{
	int size;
	String shape;
	
	WM(){}
	WM(String name, int price, int size, String shape){
		this.name = name;
		this.price = price;
		this.bonusPoint = (int)(price*0.1);
		this.size = size;
		this.shape = shape;
	}
	
	void sterilization() {
		System.out.println("��� ����� �ֽ��ϴ�.");
	}
	
}
 
class WM1 extends WM{
	
	WM1(){
		super("�뵹�� ��Ź��", 15000, 10, "�簢��");
	}
}
 
class WM2 extends WM{
	
	WM2(){
		super("�巳 ��Ź��", 19000, 15, "�簢��");
	}
}

class WM3 extends WM{
	
	WM3(){
		super("�巳���� ��Ź��", 23000, 15, "�簢��");
	}
}
		










	
