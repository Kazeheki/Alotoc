package alotoc.logic;

import alotoc.Constants;
import alotoc.graphics.view.ClockView;
import alotoc.graphics.view.MainFrame;

/**
 * This is a class for all the runnable in the project.
 * 
 * @author Kazeheki
 *
 */
public final class AlotocRunnables {

	/** Whether the program is running. */
	private static boolean running = true;

	/**
	 * This runnable updates the clock.
	 * 
	 * @param f
	 *            The frame the runnable belongs to.
	 * @return A Runnable for clock update.
	 */
	public static final Runnable clockTickRunnable(final MainFrame f) {
		Runnable r = new Runnable() {

			@Override
			public void run() {

				while (running) {
					ClockView.updateText();
					try {
						Thread.sleep(Constants.ONE_SEC_IN_MS);
					} catch (InterruptedException e) {
						// should not happen
						e.printStackTrace();
					}
				}
			}

		};

		return r;
	}

	/** Stop all runnables. */
	public static void halt() {
		running = false;
	}
}
