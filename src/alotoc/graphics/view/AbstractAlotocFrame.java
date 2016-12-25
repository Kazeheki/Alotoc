package alotoc.graphics.view;

import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This is an abstract class for all the frames in the program.
 * 
 * @author Kazeheki
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractAlotocFrame extends JFrame {
	
	/** Home dir. */
	private final String appdata = System.getenv("LOCALAPPDATA");
	/** Path to storage file. */
	private final String path = appdata + "\\.Alotoc";
	/** Position storage file complete path. */
	protected final String file = path + "\\ini.txt";
	
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
	 *            Position Point of frame.
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
	
	
	/**
	 * Check whether the file with the stored position is existent.
	 * @return Whether file is existent.
	 */
	protected final boolean fileIsExistent(){
		File f = new File(file);
		return f.exists() && f.isFile();
	}
	
	
	/**
	 * Store the current position of the frame into the storage file.
	 */
	public void storePosition(){
		Point p = MouseInfo.getPointerInfo().getLocation();
		int x = p.x;
		int y = p.y;
		int[] arr = {x,y};
		try{

			System.out.println(file);
			if(!fileIsExistent()){
				File f = new File(path);
				f.mkdirs();
				f = new File(file);
				f.createNewFile();
			}
			
			FileOutputStream fileStream = new FileOutputStream(file);
			ObjectOutputStream objStream = new ObjectOutputStream(fileStream);
			
			objStream.writeObject(arr);
			
			objStream.close();
			fileStream.close();
		}catch(Exception e){
			JOptionPane.showConfirmDialog(null, 
					"Could not save position. Default will be loaded next time.",
					"Error while saving position",
					JOptionPane.DEFAULT_OPTION);   
			
			e.printStackTrace();
		}
	}
}
