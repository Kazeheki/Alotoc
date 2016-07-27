package alotoc.logic;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import alotoc.Constants;
import alotoc.graphics.view.AbstractAlotocFrame;

/**
 * This is a MouseListener specifically for the preferences dialog.
 * 
 * @author Kazeheki
 *
 */
public class PrefMouseListener implements MouseListener {

	/** The panel the listener belongs to. */
	private final AbstractAlotocFrame frame;

	/** Whether the button is currently pressed. */
	private boolean isPressed = false;

	/**
	 * Ctor.
	 * 
	 * @param f
	 *            The frame the listener belongs to.
	 */
	public PrefMouseListener(final AbstractAlotocFrame f) {
		frame = f;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		boolean quit = checkQuit(e);

		if (!quit) {
			isPressed = true;
			Runnable r = new Runnable() {
				@Override
				public void run() {
					while (isPressed) {
						Point clickedAt = MouseInfo.getPointerInfo().getLocation();
						int x = clickedAt.x - e.getX();
						int y = clickedAt.y - e.getY();
						frame.setLocation(x, y);
					}
				}
			};
			Thread t = new Thread(r);
			t.setName("Move Frame");
			t.start();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isPressed = false;
	}

	/**
	 * Check whether the quit button was clicked. It will close the frame.
	 * 
	 * @param e
	 *            The MouseEvent that occurred.
	 * @return Whether the quit button was clicked.
	 */
	private boolean checkQuit(final MouseEvent e) {
		boolean clicked = false;

		final int x = frame.getWidth() - Constants.SMALL_SIDE_PNL_SIZE;
		final int y = 0;
		final int ex = frame.getWidth();
		final int ey = Constants.SMALL_SIDE_PNL_SIZE;

		final Point clickedAt = e.getPoint();
		if (isInside(clickedAt, x, y, ex, ey)) {
			clicked = true;
			frame.dispose();
		}

		return clicked;
	}

	/**
	 * Check whether the given Point (where it was clicked) is inside the given
	 * bounds.
	 * 
	 * @param clickedAt
	 *            The Point where in the frame was clicked.
	 * @param x
	 *            X position of left upper corner.
	 * @param y
	 *            Y position of left upper corner.
	 * @param ex
	 *            X position of right lower corner.
	 * @param ey
	 *            Y position of right lower corner.
	 * @return Whether the given Point is inside the given bounds.
	 */
	private boolean isInside(final Point clickedAt, final int x, final int y, final int ex, final int ey) {
		return clickedAt.x >= x && clickedAt.y >= y && clickedAt.x <= ex && clickedAt.y <= ey;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// nothing.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// nothing.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// nothing.
	}

}
