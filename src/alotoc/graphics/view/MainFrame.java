package alotoc.graphics.view;

import java.awt.Color;
import java.awt.MouseInfo;

import alotoc.Constants;
import alotoc.logic.AlotocRunnables;
import alotoc.logic.ClockMouseListener;

/**
 * This is a Frame for the main of the program. It contains the actual clock
 * view.
 * 
 * @author Kazeheki
 * @see AbstractAlotocFrame
 */
@SuppressWarnings("serial")
public class MainFrame extends AbstractAlotocFrame {

	/** The clockView of this frame. */
	private final ClockView cv;

	/**
	 * Ctor.
	 */
	public MainFrame() {
		super(MouseInfo.getPointerInfo().getLocation(), Constants.MAIN_FRM_WIDTH, Constants.MAIN_FRM_HEIGHT, "Clock");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackground(new Color(0, 0, 0, 0));
		this.addMouseListener(new ClockMouseListener(this));
		cv = new ClockView(this);
		this.add(cv);

		Thread t = new Thread(AlotocRunnables.clockTickRunnable(this));
		t.setName("CLOCK");
		t.start();

		this.setVisible(true);
	}
}
