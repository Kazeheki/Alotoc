package alotoc.logic;

import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JLabel;

/**
 * This is a class for getting the time in specific formats.
 * 
 * @author Kazeheki
 *
 */
public final class Time {

	/**
	 * Write the hour and minute of the current time into the given labels.
	 * 
	 * @param hour
	 *            Label for the hour display.
	 * @param min
	 *            Label for the minute display.
	 */
	public static void getTime(final JLabel hour, final JLabel min) {
		Calendar c = Calendar.getInstance(TimeZone.getDefault());
		String tmp = "" + c.get(Calendar.HOUR_OF_DAY);
		tmp = tmp.length() == 1 ? "0" + tmp : tmp;
		hour.setText(tmp);

		tmp = "" + c.get(Calendar.MINUTE);
		tmp = tmp.length() == 1 ? "0" + tmp : tmp;
		min.setText(tmp);
	}

	/**
	 * Set the TimeZone (location) for the clock to use.
	 * 
	 * @param tz
	 *            The TimeZone for the clock to use.
	 */
	public static void setLocale(final TimeZone tz) {
		TimeZone.setDefault(tz);
	}
}
