package alotoc.graphics.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import alotoc.Constants;
import alotoc.graphics.panels.ColorPanel;
import alotoc.graphics.panels.GoPanel;
import alotoc.graphics.panels.QuitPanel;

/**
 * This is a panel for the display of the preferences.
 * 
 * @author Kazeheki
 *
 */
@SuppressWarnings("serial")
public class PrefView extends JPanel {

	/** First headline to be displayed. */
	private final JLabel h1 = new JLabel();
	/** Second headline to be displayed. */
	private final JLabel h2 = new JLabel();
	/** ColorPanels for choosing color of clock. */
	private final ColorPanel[] colorPnls = new ColorPanel[Constants.COLORS.length];
	/** TextField for the input of a hex-value for the color. */
	private final JTextField inputField = new JTextField();
	/** The frame this panel belongs to. */
	private final AbstractAlotocFrame frame;
	
	
	/**
	 * Ctor.
	 * 
	 * @param f
	 *            Frame the panel belongs to.
	 */
	public PrefView(final AbstractAlotocFrame f) {
		this.frame = f;
		this.setBounds(0, 0, f.getWidth(), f.getHeight());
		this.setOpaque(false);
		this.setLayout(null);

		setTexts();
		setFonts();
		setBounds();
		
		this.add(h1);
		this.add(h2);
		this.add(new GoPanel(frame, Constants.GO_X, Constants.GO_Y));
		inputField.setHorizontalAlignment(JTextField.CENTER);
		this.add(inputField);
		new QuitPanel(frame);

		final int y = Constants.COLOR_Y;
		int x = (f.getWidth() - (Constants.COLOR_PNL_SIZE * colorPnls.length)) / 2;
		for (int i = 0; i < colorPnls.length; i++) {
			colorPnls[i] = new ColorPanel(x, y, Constants.COLORS[i]);
			x += Constants.COLOR_PNL_SIZE;
			this.add(colorPnls[i]);
		}

		this.setVisible(true);
	}

	/**
	 * Set texts of labels.
	 */
	private void setTexts() {
		h1.setText("Choose a color for the clock");
		h2.setText("Or type in a hex-value");
		String str = Integer.toHexString(Constants.COLORS[1].getRed());
		str += Integer.toHexString(Constants.COLORS[1].getGreen());
		str += Integer.toHexString(Constants.COLORS[1].getBlue());
		inputField.setText(str);
	}

	/**
	 * Set fonts of labels.
	 */
	private void setFonts() {
		Font font = new Font(Font.MONOSPACED, Font.BOLD, 25);
		Color c = new Color(230, 230, 230, 230);
		h1.setFont(font);
		h2.setFont(font);
		inputField.setFont(font);
		h1.setForeground(c);
		h2.setForeground(c);
	}

	/**
	 * Set bounds of labels.
	 */
	private void setBounds() {
		Dimension d = h1.getMinimumSize();
		h1.setBounds(20, 10, d.width, d.height);
		d = h2.getMinimumSize();
		h2.setBounds(20, 120, d.width, d.height);
		d = inputField.getPreferredSize();
		inputField.setBounds(Constants.PREF_FRM_WIDTH/2 - d.width/2-20, 160, d.width+12, d.height);
	}
	
	
	protected JTextField getInputField(){
		return inputField;
	}
}
