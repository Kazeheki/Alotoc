package alotoc.graphics.panels;

import java.awt.Color;

import alotoc.Constants;
import alotoc.graphics.view.AbstractAlotocFrame;

/**
 * This is a Panel for a Preferences-Button.
 * 
 * @author Kazeheki
 * @see Panel
 */
@SuppressWarnings("serial")
class PrefPanel extends Panel {

	/**
	 * Ctor.
	 * 
	 * @param f Frame the panel shall be added to.
	 */
	PrefPanel(final AbstractAlotocFrame f) {
		super(f.getWidth() - Constants.SMALL_SIDE_PNL_SIZE, Constants.SMALL_SIDE_PNL_SIZE,
				Constants.SMALL_SIDE_PNL_SIZE, Constants.SMALL_SIDE_PNL_SIZE, "O");
		this.setBackground(new Color(128, 128, 128, 128));
		f.add(this);
	}
}
