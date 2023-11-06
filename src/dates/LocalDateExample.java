package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LocalDateExample {

	public static void main(String[] args) {
		String dateformat = "ddMMMyyyy";
		String date = "05MaY1996";
		convertDate(date, dateformat);
	}
	
	public static long convertDate(String date, String dateformat) {

		
		/*
		 * String dateTime = date + " 00:00:00 " + "IST"; DateTimeFormatter dtf =
		 * DateTimeFormatter.ofPattern(dateformat + " HH:mm:ss zzz"); ZonedDateTime zdt
		 * = ZonedDateTime.parse(dateTime, dtf); long localDateTime =
		 * zdt.toLocalDateTime()
		 * .toEpochSecond(ZoneId.of("Asia/Kolkata").getRules().getOffset(Instant.now()))
		 * ; long epoch = localDateTime * 1000;
		 * 
		 */

		long epoch = 0L;
		try {

			SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
			epoch = sdf.parse(date).getTime();
			System.out.println("Converted date " + date + "" + epoch);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return epoch;

	}

}
