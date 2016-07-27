package alotoc.logic;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

import alotoc.Constants;
import alotoc.graphics.view.ClockView;
import alotoc.graphics.view.PrefDialogFrame;

/**
 * This is a MouseListener specifically for the preferences dialog.
 * 
 * @author Kazeheki
 *
 */
public class PrefMouseListener implements MouseListener {

	/** The panel the listener belongs to. */
	private final PrefDialogFrame frame;

	/** Whether the button is currently pressed. */
	private boolean isPressed = false;

	/**
	 * Ctor.
	 * 
	 * @param f
	 *            The frame the listener belongs to.
	 */
	public PrefMouseListener(final PrefDialogFrame f) {
		frame = f;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		boolean quit = checkQuit(e);
		quit |= checkColor(e);
		quit |= checkGo(e);

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
	 * Check whether a color was clicked.
	 * 
	 * @param e The MouseEvent that happend.
	 * @return Whether a color was clicked.
	 */
	private boolean checkColor(final MouseEvent e){
		boolean clicked = false;
		
		final Point clickedAt = e.getPoint();
		final int x = (frame.getWidth() - (Constants.COLOR_PNL_SIZE * Constants.COLORS.length)) / 2;
		final int y = Constants.COLOR_Y;
		final int ex = x + Constants.COLORS.length * Constants.COLOR_PNL_SIZE;
		final int ey = y + Constants.COLOR_PNL_SIZE;
		
		if(isInside(clickedAt, x, y, ex, ey)){
			clicked = true;
			int idx = (clickedAt.x - x) / Constants.COLOR_PNL_SIZE;
			ClockView.setColor(Constants.COLORS[idx]);
		}
		
		return clicked;
	}
	
	private boolean checkGo(final MouseEvent e){
		boolean clicked = false;
		
		final Point clickedAt = e.getPoint();
		final int x = Constants.GO_X;
		final int y = Constants.GO_Y;
		final int ex = x + Constants.GO_BTN_SIZE;
		final int ey = y + Constants.GO_BTN_SIZE;
		
		if(isInside(clickedAt, x, y, ex, ey)){
			JTextField txt = frame.getInputField();
			ClockView.setColor(hexToColor(txt.getText()));
		}
		
		return clicked;
	}
	
	private Color hexToColor(final String hex){
		Color c = null;
		try{
			int r = Integer.parseInt(hex.substring(0, 2), 16);
			int g = Integer.parseInt(hex.substring(2, 5), 16);
			int b = Integer.parseInt(hex.substring(4, 6), 16);
			int a = 255;
			if(hex.length() == 8){
				a = Integer.parseInt(hex.substring(6, 8), 16);
			}
			c = new Color(r,g,b,a);
			
		}catch(NumberFormatException n){
			frame.getInputField().setText("ERROR");
		}
		
		return c;		
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
