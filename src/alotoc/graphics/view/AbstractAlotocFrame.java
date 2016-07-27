package alotoc.graphics.view;

import java.awt.Point;

import javax.swing.JFrame;

/**
 * This is an abstract class for all the frames in the program.
 * 
 * @author Kazeheki
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractAlotocFrame extends JFrame {

	/**
	 * Ctor.
	 * 
	 * @param x
	 *            X position of frame.
	 * @param y
	 *            Y position of frame.
	 * @param w
	 *            Width of frame.
	 * @param h
	 *            Height of frame.
	 * @param title
	 *            Title of frame.
	 */
	public AbstractAlotocFrame(final int x, final int y, final int w, final int h, final String title) {
		this.setTitle(title);
		this.setAlwaysOnTop(true);
		this.setBounds(x, y, w, h);
		this.setUndecorated(true);
		this.setLayout(null);
		this.setResizable(false);
	}

	/**
	 * Ctor.
	 * 
	 * @param p
	 *            Postion Point of frame.
	 * @param w
	 *            Width of frame.
	 * @param h
	 *            Height of frame.
	 * @param title
	 *            Title of frame.
	 */
	public AbstractAlotocFrame(final Point p, final int w, final int h, final String title) {
		this(p.x, p.y, w, h, title);
	}
}
