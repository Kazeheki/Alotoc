package alotoc;

import java.awt.Color;

/**
 * This is a class only for constants needed in this project.
 * 
 * @author Kazeheki
 *
 */
public final class Constants {
	// sizes.
	public static final int MAIN_FRM_HEIGHT = 100;
	public static final int MAIN_FRM_WIDTH = (int) (2.8 * MAIN_FRM_HEIGHT);
	public static final int PREF_FRM_HEIGHT = 100;
	public static final int PREF_FRM_WIDTH = 3 * PREF_FRM_HEIGHT;
	public static final int SMALL_SIDE_PNL_SIZE = 15;
	public static final int GO_BTN_SIZE = 50;
	public static final int COLOR_PNL_SIZE = 50;

	// strings.
	public static final String DOT_ON = ":";
	public static final String DOT_OFF = " ";

	// time.
	public static final long ONE_SEC_IN_MS = 1000;

	// color.
	public static final Color[] COLORS = { new Color(0, 0, 0), // black.
			new Color(51, 51, 51), // grayish.
			new Color(255, 255, 255), // white.
			new Color(255, 0, 0) // red.
	};
}
