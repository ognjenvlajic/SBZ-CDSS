package sbz.cdss.facts;

import java.util.Calendar;
import java.util.Date;

public class Util {

	// ukoliko je neki parametar negativan onda ce se oduzimati od datuma
	// oduzimanje je mozda nebezbedno
	public static Date dodajDane(Date date, int dani, int meseci, int godine) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (dani != 0) {
			cal.add(Calendar.DATE, dani);
		}
		if ( meseci != 0 ) {
			cal.add(Calendar.MONTH, meseci);
		}
		if (godine != 0 ) {
			cal.add(Calendar.YEAR, godine);
		}
		return cal.getTime();
	}

}
