package roughuSE;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opencsv.exceptions.CsvException;

public class ROUGH {

	public static void main(String[] args) throws IOException, CsvException {
		ROUGH r = new ROUGH();
		String value ="Twinkle Team_Merchant_Report_"+r.dateAndTime()+".pdf";
		System.out.println(value);
	}
	
	public String dateAndTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
		Date date = new Date();
		System.out.println(formatter.format(date));
		return formatter.format(date);
	}

}
