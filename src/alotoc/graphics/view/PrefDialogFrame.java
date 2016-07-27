package alotoc.graphics.view;

import java.awt.Color;

import alotoc.Constants;
import alotoc.logic.PrefMouseListener;

/**
 * This is a Frame for the preferences dialog.
 * 
 * @author Kazeheki
 * @see AbstractAlotocFrame
 */
@SuppressWarnings("serial")
public class PrefDialogFrame extends AbstractAlotocFrame {

	/**
	 * Ctor.
	 * 
	 * @param x
	 *            X position of frame.
	 * @param y
	 *            Y position of frame.
	 */
	public PrefDialogFrame(final int x, final int y) {
		super(x, y, Constants.PREF_FRM_WIDTH, Constants.PREF_FRM_HEIGHT, "Preferences");
		this.setBackground(new Color(50, 50, 50, 200));
		this.addMouseListener(new PrefMouseListener(this));
		this.add(new PrefView(this));

		this.setVisible(true);
	}
}
