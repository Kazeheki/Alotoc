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
	public static final int PREF_FRM_HEIGHT = 220;
	public static final int PREF_FRM_WIDTH = 550;
	public static final int SMALL_SIDE_PNL_SIZE = 15;
	public static final int GO_BTN_SIZE = 35;
	public static final int COLOR_PNL_SIZE = 50;
	
	// coordinates.
	public static final int COLOR_Y = 50;
	public static final int GO_X = 323;
	public static final int GO_Y = 162;

	// strings.
	public static final String DOT_ON = ":";
	public static final String DOT_OFF = " ";

	// time.
	public static final long ONE_SEC_IN_MS = 1000;

	// color.
	public static final Color[] COLORS = { 
			new Color(0, 0, 0), // black.
			new Color(51, 51, 51), // grayish.
			new Color(195, 195, 195), // more white grayish.
			new Color(255, 255, 255), // white.
			new Color(195, 50, 50), // dark red.
			new Color(255, 0, 0), // red.
			new Color(50, 195, 50), // dark green.
			new Color(0, 255, 0), // green.
			new Color(195, 195, 50), // dark yellow.
			new Color(255, 255, 0) //yellow.
	};
}
