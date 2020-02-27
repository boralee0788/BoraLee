
public class Ref extends Product{
	
	static int count1;
	int product_n = 2000;


	
	{
		product_n += ++count1;
	}
		
	
	Ref() {
		price = 1500;
		name = "≥√¿Â∞Ì";
	}
}
