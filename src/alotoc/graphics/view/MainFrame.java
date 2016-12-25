package alotoc.graphics.view;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

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
	
	/** This Frame. */
	private static MainFrame instance = null;
	
	/**
	 * Get an instance of the MainFrame.
	 * @return Instance of MainFrame.
	 */
	public static MainFrame getInstance(){
		if(instance == null){
			instance = new MainFrame();
		}
		return instance;
	}

	/**
	 * Ctor.
	 */
	private MainFrame() {
		super(MouseInfo.getPointerInfo().getLocation(), Constants.MAIN_FRM_WIDTH, Constants.MAIN_FRM_HEIGHT, "Clock");
		if(fileIsExistent()){
			int[] xY = loadPosition();
			this.setLocation(xY[0], xY[1]);
		}
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
	
	/**
	 * Get the ClockView of this Frame.
	 * 
	 * @return The ClockView of this Frame.
	 */
	public final ClockView getClockView(){
		return cv;
	}
	
	/**
	 * Get the position saved in the storage file.
	 * Returns array of size 2. 
	 * array[0] -> x-Coordinate,
	 * array[1] -> y-Coordinate;
	 * @return Coordinates of last position.
	 */
	private final int[] loadPosition(){
		int[] arr = new int[2];
		
		try{
			FileInputStream fileStream = new FileInputStream(file);
			ObjectInputStream objStream = new ObjectInputStream(fileStream);
			
			arr = (int[]) objStream.readObject();
			
			objStream.close();
			fileStream.close();
		}catch(Exception e){
			Point p = MouseInfo.getPointerInfo().getLocation();
			arr[0] = p.x;
			arr[1] = p.y;
		}
		
		return arr;
	}		
}
