package alotoc.logic;

import java.util.Calendar;
import java.util.Locale;

import javax.swing.JLabel;

/**
 * This is a class for getting the time in specific formats.
 * 
 * @author Kazeheki
 *
 */
public final class Time {
	
	/** The locale the clock should use. */
	private static Locale locale = Locale.GERMAN;

	/**
	 * Write the hour and minute of the current time into the given labels.
	 * 
	 * @param hour
	 *            Label for the hour display.
	 * @param min
	 *            Label for the minute display.
	 */
	public static void getTime(final JLabel hour, final JLabel min) {
		Calendar c = Calendar.getInstance(locale);
		String tmp = "" + c.get(Calendar.HOUR_OF_DAY);
		tmp = tmp.length() == 1 ? "0" + tmp : tmp;
		hour.setText(tmp);

		tmp = "" + c.get(Calendar.MINUTE);
		tmp = tmp.length() == 1 ? "0" + tmp : tmp;
		min.setText(tmp);
	}
	
	/**
	 * Set the Locale (location) for the clock to use.
	 * 
	 * @param l The Locale for the clock to use.
	 */
	public static void setLocale(final Locale l){
		locale = l;
	}
}
