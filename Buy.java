import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Buy {
	
	String id;
	String name;
	int price;
	int bonusPoint;
	String date;
	int sum;

	
	Calendar buy_cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	Buy(){}
	
	Buy(String id, String name, int price, int bonusPoint){
		this.id = id;
		this.name = name;
		this.price = price;
		this.bonusPoint = (int)(price*0.1);
		this.date = sdf.format(buy_cal.getTime());

	}

}
