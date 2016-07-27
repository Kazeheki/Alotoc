package alotoc.graphics.panels;

import java.awt.Color;

import alotoc.Constants;
import alotoc.graphics.view.AbstractAlotocFrame;

/**
 * This is a Panel for a Quit-Button.
 * 
 * @author Kazeheki
 * @see Panel
 */
@SuppressWarnings("serial")
public class QuitPanel extends Panel {

	/**
	 * Ctor.
	 * 
	 * @param f
	 *            Frame the panel shall be added to.
	 */
	public QuitPanel(final AbstractAlotocFrame f) {
		super(f.getWidth() - Constants.SMALL_SIDE_PNL_SIZE, 0, Constants.SMALL_SIDE_PNL_SIZE,
				Constants.SMALL_SIDE_PNL_SIZE, "X", 15);
		this.setBackground(new Color(94, 04, 22, 128));
		f.add(this);
	}
}
