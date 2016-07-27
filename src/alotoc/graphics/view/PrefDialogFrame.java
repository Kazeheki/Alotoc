package alotoc.graphics.view;

import java.awt.Color;

import javax.swing.JTextField;

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
	
	/** The input field of this frame. */
	private JTextField inputField;

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
		PrefView view = new PrefView(this);
		this.add(view);
		this.inputField = view.getInputField();

		this.setVisible(true);
	}
	
	public final JTextField getInputField(){
		return inputField;
	}
}
