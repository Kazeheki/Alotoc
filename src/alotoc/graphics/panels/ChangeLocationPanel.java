package alotoc.graphics.panels;

import java.awt.Color;

import alotoc.Constants;
import alotoc.graphics.view.AbstractAlotocFrame;

/**
 * This is a Panel for the Change Location Button.
 * 
 * @author Kazeheki
 *
 */
@SuppressWarnings("serial")
public class ChangeLocationPanel extends Panel {

	/**
	 * Ctor.
	 * 
	 * @param f
	 *            The frame that the panel shall be added to.
	 * @param x
	 *            X position of panel.
	 * @param y
	 *            Y position of panel.
	 */
	public ChangeLocationPanel(final AbstractAlotocFrame f) {
		super(f.getWidth() - Constants.CHNG_LOC_WIDTH, f.getHeight() - Constants.CHNG_LOC_HEIGHT,
				Constants.CHNG_LOC_WIDTH, Constants.CHNG_LOC_HEIGHT, "change location", 15);
		this.setBackground(new Color(50, 50, 50, 200));
		lbl.setLocation(3, 0);
		lbl.setForeground(new Color(230, 230, 230));
		f.add(this);
	}
}
