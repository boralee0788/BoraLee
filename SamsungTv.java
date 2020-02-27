
public class SamsungTv extends Product{

	static int count;
	int product_n = 1000;


	
	{
		product_n += ++count;
	}
		
	
	SamsungTv() {
		price = 1000;
		name = "TV";
	}
	

}
