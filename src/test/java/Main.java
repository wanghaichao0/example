import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		SimpleDateFormat start = new SimpleDateFormat("MM/dd HH:MM");
		System.out.println(start.format(new Date()));
	}
	
}
