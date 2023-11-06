package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class DateConverter {

	public static void main(String[] args) {

		long epoch = 0l;
		String date = "06May2023";
		String dateformat = "ddMMMyyyy";
		try {

			SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
			sdf.setTimeZone(TimeZone.getTimeZone("IST"));
			epoch = sdf.parse(date).getTime();
			System.out.println("Converted date : " + date + " to" + epoch);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
