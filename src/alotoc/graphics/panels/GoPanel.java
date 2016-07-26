package alotoc.graphics.panels;

import java.awt.Color;

import alotoc.Constants;
import alotoc.graphics.view.AbstractAlotocFrame;

/**
 * This is a Panel for a Go-Button.
 * 
 * @author Kazeheki
 * @see Panel
 */
@SuppressWarnings("serial")
class GoPanel extends Panel {

	/**
	 * Ctor.
	 * 
	 * @param f Frame the panel shall be added to.
	 * @param x X position of panel.
	 * @param y Y position of panel.
	 */
	GoPanel(final AbstractAlotocFrame f, final int x, final int y){
		super(x, y, Constants.GO_BTN_SIZE, Constants.GO_BTN_SIZE, "GO");
		this.setBackground(new Color(50, 50, 50, 200));
		f.add(this);
	}
}
