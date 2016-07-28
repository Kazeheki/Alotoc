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
	/** An instance of this object. */
	private static PrefDialogFrame instance = null;

	/**
	 * Ctor.
	 * 
	 * @param x
	 *            X position of frame.
	 * @param y
	 *            Y position of frame.
	 */
	private PrefDialogFrame(final int x, final int y) {
		super(x, y, Constants.PREF_FRM_WIDTH, Constants.PREF_FRM_HEIGHT, "Preferences");
		this.setBackground(new Color(50, 50, 50, 200));
		this.addMouseListener(new PrefMouseListener(this));
		PrefView view = new PrefView(this);
		this.add(view);
		this.inputField = view.getInputField();

		this.setVisible(true);
	}

	/**
	 * Gets an instance of the object. If non is existent, a new one will be
	 * created.
	 * 
	 * @param x
	 *            X position of frame.
	 * @param y
	 *            Y position of frame.
	 * @return Instances of object.
	 */
	public static PrefDialogFrame getInstance(final int x, final int y) {
		if (instance == null) {
			instance = new PrefDialogFrame(x, y);
		}

		return instance;
	}
	
	public static void close(){
		instance = null;
	}

	public final JTextField getInputField() {
		return inputField;
	}
}
