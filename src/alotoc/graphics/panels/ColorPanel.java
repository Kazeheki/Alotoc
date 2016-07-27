package alotoc.graphics.panels;

import java.awt.Color;

import alotoc.Constants;

/**
 * This is a Panel for displaying colors.
 * 
 * @author Kazeheki
 *
 */
@SuppressWarnings("serial")
public class ColorPanel extends Panel {

	/**
	 * Ctor.
	 * 
	 * @param x
	 *            X position of panel.
	 * @param y
	 *            Y position of panel.
	 * @param c
	 *            Color of panel.
	 */
	public ColorPanel(final int x, final int y, final Color c) {
		super(x, y, Constants.COLOR_PNL_SIZE, Constants.COLOR_PNL_SIZE);
		this.setBackground(c);
	}
}
