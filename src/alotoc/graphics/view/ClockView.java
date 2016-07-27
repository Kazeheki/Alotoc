package alotoc.graphics.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import alotoc.Constants;
import alotoc.graphics.panels.PrefPanel;
import alotoc.graphics.panels.QuitPanel;
import alotoc.logic.Time;

/**
 * This is a view for the clock.
 * 
 * @author Kazeheki
 *
 */
@SuppressWarnings("serial")
public class ClockView extends JPanel {

	/** Label for hour display. */
	private static JLabel lblHour = new JLabel();
	/** Label for minute display. */
	private static JLabel lblMin = new JLabel();
	/** Label for dot display. */
	private static JLabel lblDot = new JLabel();

	/**
	 * Ctor.
	 * 
	 * @param f
	 *            The frame this panel belongs to.
	 */
	ClockView(final AbstractAlotocFrame f) {
		this.setBounds(0, 0, f.getWidth(), f.getHeight());
		this.setOpaque(false);
		this.setLayout(null);

		setTexts();
		setFonts();
		setBounds();
		setColor(51, 51, 51);

		this.add(lblHour);
		this.add(lblDot);
		this.add(lblMin);

		new QuitPanel(f);
		new PrefPanel(f);

		this.setVisible(true);
	}

	/**
	 * Set the text of the labels.
	 */
	private void setTexts() {
		Time.getTime(lblHour, lblMin);
		lblDot.setText(Constants.DOT_ON);
	}

	/**
	 * Set the fonts of the labels.
	 */
	private void setFonts() {
		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 100);
		lblDot.setFont(font);
		lblHour.setFont(font);
		lblMin.setFont(font);
	}

	/**
	 * Set the bounds of the labels.
	 */
	private void setBounds() {
		Dimension d = lblHour.getPreferredSize();
		lblHour.setBounds(0, 0, d.width, d.height - 25);
		int lastX = d.width;

		d = lblDot.getPreferredSize();
		lblDot.setBounds(lastX * 4, 0, d.width, d.height - 25);
		lastX = d.width;

		d = lblMin.getPreferredSize();
		lblMin.setBounds(lastX * 4, 0, d.width, d.height - 25);
	}

	/**
	 * Set the color of the labels to given RGB value.
	 * 
	 * @param r
	 *            red
	 * @param g
	 *            green
	 * @param b
	 *            blue
	 */
	void setColor(final int r, final int g, final int b) {
		Color c = new Color(r, g, b);
		lblDot.setForeground(c);
		lblHour.setForeground(c);
		lblMin.setForeground(c);
	}

	/**
	 * Updates the text of the labels/the clock.
	 */
	public static void updateText() {
		Time.getTime(lblHour, lblMin);
		if (lblDot.getText() == Constants.DOT_OFF) {
			lblDot.setText(Constants.DOT_ON);
		} else {
			lblDot.setText(Constants.DOT_OFF);
		}
	}
}
