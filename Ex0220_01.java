
public class Ex0220_01 {

	public static void main(String[] args) {
		Data d = new Data();  // °´Ã¼¼±¾ð
		
		d.x = 10;
		d.y = 100;
	
		int result =0;
	
//		change1(d);
//		System.out.println("change1: "+d.x);
//		
//
//		d.y = change2(d.x, d.y);
//		System.out.println("change2: "+d.y);

		change3(d);
		System.out.println("change3: "+d.y);
		
		d.y = change3_1(d.y);
		System.out.println("change3_1: "+d.y);
		
		
	} // main

	static void change1(Data d) {
		d.x =1000;
		System.out.println("change: "+d.x);
	}
	
	
	static int change2(int a, int b) {
		return a-b;
	}



	static void change3(Data d) {
		d.y=2000;
	}
	

	static int change3_1(int y) {
		y=2000;
		return y;
	}
	
	
	
	
	
}
	
class Data{
	int x;
	int y;
}
