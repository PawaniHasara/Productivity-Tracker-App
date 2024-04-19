package EX;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Component;


public class ToDoList extends JPanel{ 
	public ToDoList() {
		setLayout(null);
        // Your application code here
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error occurred.");
        }
        new AppFrame();
    }
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

class Task extends JPanel {


	private static final long serialVersionUID = 1L;
	JLabel index;
	JTextField taskName;
	JButton done;

    Color blue = new Color(135, 206, 250); 
	Color green = new Color(188, 226, 158);
	Color doneColor = new Color(233, 119, 119);

	private boolean checked;

	Task() {
        this.setPreferredSize(new Dimension(400, 30)); 
		this.setBackground(blue); // set background color of task

		this.setLayout(new BorderLayout()); // set layout of task

		checked = false;

		index = new JLabel(""); // create index label
		index.setPreferredSize(new Dimension(20, 20)); // set size of index label
		index.setHorizontalAlignment(JLabel.CENTER); // set alignment of index label
		this.add(index, BorderLayout.WEST); // add index label to task

		taskName = new JTextField("Write something.."); // create task name text field
		taskName.setBorder(BorderFactory.createEmptyBorder()); // remove border of text field
		taskName.setBackground(blue); // set background color of text field
        taskName.setOpaque(false); // Set to false to remove the white background

		this.add(taskName, BorderLayout.CENTER);

		done = new JButton("Done");
		done.setPreferredSize(new Dimension(80, 20));
		done.setBorder(BorderFactory.createEmptyBorder());
		done.setBackground(doneColor);
		done.setFocusPainted(false);

		this.add(done, BorderLayout.EAST);

	}

	public void changeIndex(int num) {
		this.index.setText(num + ""); // num to String
		this.revalidate(); // refresh
	}

	public JButton getDone() {
		return done;
	}

	public boolean getState() {
		return checked;
	}

	public void changeState() {
		this.setBackground(green);
		taskName.setBackground(green);
		checked = true;
		revalidate();
	}
}

class List extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Color lightColor = new Color(252, 221, 176);
	Color lightColor = new Color(64, 64, 64);
	List() {

		GridLayout layout = new GridLayout(10, 1);
		layout.setVgap(5); // Vertical gap

		this.setLayout(layout); // 10 tasks
		this.setPreferredSize(new Dimension(400, 560));
		this.setBackground(lightColor);
	}

	public void updateNumbers() {
		Component[] listItems = this.getComponents();

		for (int i = 0; i < listItems.length; i++) {
			if (listItems[i] instanceof Task) {
				((Task) listItems[i]).changeIndex(i + 1);
			}
		}

	}

	public void removeCompletedTasks() {

		for (Component c : getComponents()) {
			if (c instanceof Task) {
				if (((Task) c).getState()) {
					remove(c); // remove the component
					updateNumbers(); // update the indexing of all items
				}
			}
		}

	}
}

class Footer extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton addTask;
	JButton clear;

	Color lightColor = new Color(252, 221, 176);
    Color blue = new Color(135, 206, 250); 

	Border emptyBorder = BorderFactory.createEmptyBorder();

	Footer() {
				 
		this.setPreferredSize(new Dimension(400, 60));
		this.setBackground(lightColor);

		addTask = new JButton("Add Task"); // add task button
		addTask.setFont(new Font("Trebuchet MS", Font.PLAIN, 12)); // set font
		addTask.setVerticalAlignment(JButton.CENTER); // align text to center
        addTask.setBackground(blue); // Set background color to transparent
        addTask.setPreferredSize(new Dimension(120, 40));
		this.add(addTask); // add to footer

		this.add(Box.createHorizontalStrut(10)); // Space between buttons

		clear = new JButton("Clear finished tasks"); // clear button
		clear.setFont(new Font("Trebuchet MS", Font.PLAIN, 12)); // set font
		addTask.setVerticalAlignment(JButton.CENTER); // align text to center
		addTask.setBackground(blue); // Set background color to transparent
	    addTask.setPreferredSize(new Dimension(120, 40));
	    this.add(clear); 
		
		
		// add to footer
	}

	public JButton getNewTask() {
		return addTask;
	}

	public JButton getClear() {
		return clear;
	}

}

class TitleBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color lightColor = new Color(252, 221, 176);

	TitleBar() {
		this.setPreferredSize(new Dimension(400, 80)); // Size of the title bar
		this.setBackground(lightColor); // Color of the title bar
		JLabel titleText = new JLabel("To Do List"); // Text of the title bar
		titleText.setPreferredSize(new Dimension(200, 60)); // Size of the text
		titleText.setFont(new Font("Trebuchet MS", Font.PLAIN, 18)); // Font of the text
		titleText.setHorizontalAlignment(JLabel.CENTER); // Align the text to the center
		this.add(titleText); // Add the text to the title bar
	}
}

class AppFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TitleBar title;
	private Footer footer;
	private List list;

	private JButton newTask;
	private JButton clear;

	AppFrame() {
		this.setSize(400, 600); // 400 width and 600 height
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Close on exit
        this.setTitle("To Do List"); // Set the title of the frame
		this.setVisible(true); // Make visible
		this.setAlwaysOnTop(true);

		title = new TitleBar();
		footer = new Footer();
		list = new List();

        getContentPane().setBackground(new Color(173, 216, 230)); // Set light blue background color

		getContentPane().add(title, BorderLayout.NORTH); // Add title bar on top of the screen
		getContentPane().add(footer, BorderLayout.SOUTH); // Add footer on bottom of the screen
		getContentPane().add(list, BorderLayout.CENTER); // Add list in middle of footer and title

		newTask = footer.getNewTask();
		clear = footer.getClear();

		addListeners();
	}

	public void addListeners() {
		newTask.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Task task = new Task();
				list.add(task); // Add new task to list
				list.updateNumbers(); // Updates the numbers of the tasks

				task.getDone().addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {

						task.changeState(); // Change color of task
						list.updateNumbers(); // Updates the numbers of the tasks
						revalidate(); // Updates the frame

					}
				});
				
			}

		});

		clear.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				list.removeCompletedTasks(); // Removes all tasks that are done
				repaint(); // Repaints the list
			}
		});
	}
	



	
	    
}

public void setVisible(boolean b) {
	
}
}