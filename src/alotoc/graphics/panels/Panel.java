package alotoc.graphics.panels;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class is the parent class for all Panels that hold a function like a
 * "Go"-Button or "Quit-Button".
 * 
 * @author Kazeheki
 *
 */
@SuppressWarnings("serial")
public abstract class Panel extends JPanel {

	/**
	 * Ctor.
	 * 
	 * Set visibility and opacity as well as location and size. If text is
	 * available it will also be set.
	 * 
	 * @param x
	 *            Relative x position of panel.
	 * @param y
	 *            Relative y position of panel.
	 * @param width
	 *            Width of panel.
	 * @param height
	 *            Height of panel.
	 * @param text
	 *            Text that shall be displayed on panel.
	 * @param fontSize
	 *            Size of the font of the label on panel.
	 */
	public Panel(final int x, final int y, final int width, final int height, final String text, final int fontSize) {
		boolean hasText = !text.equals("");
		this.setBounds(x, y, width, height);
		this.setOpaque(true);
		this.setLayout(null);
		if (hasText) {
			JLabel lbl = new JLabel();
			lbl.setText(text);
			lbl.setFont(new Font(Font.MONOSPACED, Font.BOLD, fontSize));
			lbl.setBounds(width / 4 + 1, -1, width, height);
			this.add(lbl);
		}
		this.setVisible(true);
	}

	/**
	 * Ctor.
	 * 
	 * Set visibility and opacity as well as location and size. No text will be
	 * set.
	 * 
	 * @param x
	 *            Relative x position of panel.
	 * @param y
	 *            Relative y position of panel.
	 * @param width
	 *            Width of panel.
	 * @param height
	 *            Height of panel.
	 */
	public Panel(final int x, final int y, final int width, final int height) {
		this(x, y, width, height, "", 0);
	}
}
