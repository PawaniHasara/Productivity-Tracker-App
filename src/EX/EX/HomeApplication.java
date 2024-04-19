package EX;
import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class HomeApplication {
   
	protected JFrame frame;
	protected Map<String, String> userDatabass = new HashMap<>(); 
	private static HomeApplication instance;
	
	
   // Singleton method to get or create the instance
   public static HomeApplication getInstance() {
       if (instance == null) {
           instance = new HomeApplication();
       }
       return instance;
   }

    public HomeApplication() {
    	frame = new JFrame();
        frame.setTitle("Home Page");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        
        JButton calendarButton = new JButton("Calendar");
        calendarButton.setBackground(new Color(153, 180, 209));
        calendarButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        calendarButton.setBounds(20, 51, 166, 64);
        JButton todoButton = new JButton("To-Do List");
        todoButton.setBackground(SystemColor.activeCaption);
        todoButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        todoButton.setBounds(399, 51, 166, 64);
        JButton expenseButton = new JButton("Expense Tracker");
        expenseButton.setBackground(SystemColor.activeCaption);
        expenseButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        expenseButton.setBounds(20, 126, 166, 68);
        JButton journalButton = new JButton("Journal");
        journalButton.setBackground(SystemColor.activeCaption);
        journalButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        journalButton.setBounds(399, 126, 166, 68);
        JButton studyTrackerButton = new JButton("Study Tracker");
        studyTrackerButton.setBackground(SystemColor.activeCaption);
        studyTrackerButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        studyTrackerButton.setBounds(20, 205, 166, 68);
        JButton customProjectButton = new JButton("Custom Project");
        customProjectButton.setBackground(SystemColor.activeCaption);
        customProjectButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        customProjectButton.setBounds(399, 209, 166, 64);
        JButton profileButton = new JButton("Edit Profile");
        profileButton.setBackground(SystemColor.activeCaption);
        profileButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        profileButton.setBounds(20, 284, 166, 68);
        
        JButton loginPgButton = new JButton("Login Page");
        loginPgButton.setBackground(SystemColor.activeCaption);
        loginPgButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        loginPgButton.setBounds(399, 288, 166, 64);
        loginPgButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Make the HomeApplication JPanel invisible
                HomeApplication homeApplication2 = new HomeApplication();
                homeApplication2.frame.setVisible(false);
                try {
                    UserForm window = new UserForm();
                    window.frame.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
        }
    });


        calendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Make the HomeApplication JPanel invisible
                HomeApplication homeApplication = new HomeApplication();
                homeApplication.frame.setVisible(false);
                try {
        	        CalendarAndDigitalClock calendarFrame1 = new CalendarAndDigitalClock();
        	        calendarFrame1.setVisible(true);
        	    } catch (Exception e1) {
        	        e1.printStackTrace();
        	    }
            }
        });
            todoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	HomeApplication homeApplication = new HomeApplication();
    				homeApplication.frame.setVisible(false);
                	openToDoListFeature();
                }
        });
            expenseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	HomeApplication homeApplication = new HomeApplication();
    				homeApplication.frame.setVisible(false);
                	openExpenseFeature();
                }
        });
 
            journalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	HomeApplication homeApplication = new HomeApplication();
    				homeApplication.frame.setVisible(false);
    				// checkthis
                	openJournalFeature();
                }
        });
            studyTrackerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	HomeApplication homeApplication = new HomeApplication();
    				homeApplication.frame.setVisible(false);
    				// checkthis
    				openStudyTrackerFeature();
                }
        });
            customProjectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	HomeApplication homeApplication = new HomeApplication();
    				homeApplication.frame.setVisible(false);
    				// checkthis
    				opencustomProjectFeature();
                }
        });
            
            profileButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                	HomeApplication homeApplication = new HomeApplication();
    				homeApplication.frame.setVisible(false);
    				// checkthis
    				openEditFeature();
                }
        });
        // Add action listeners for other buttons

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(SystemColor.inactiveCaptionBorder);
        buttonPanel.setLayout(null);
        buttonPanel.add(calendarButton);
        buttonPanel.add(todoButton);
        buttonPanel.add(expenseButton);
        buttonPanel.add(journalButton);
        buttonPanel.add(studyTrackerButton);
        buttonPanel.add(customProjectButton);
        buttonPanel.add(profileButton);
        buttonPanel.add(loginPgButton);
        frame.getContentPane().add(buttonPanel);
        
        JLabel lblNewLabel = new JLabel("Welcome \r\nto a \r\nProductive Day!");
        lblNewLabel.setForeground(new Color(0, 51, 102));
        lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 27));
        lblNewLabel.setBounds(155, -18, 366, 116);
        buttonPanel.add(lblNewLabel);
        
        
        ImageIcon logoIcon = new ImageIcon("Img/Icon.png");
        JLabel lblLogo = new JLabel(new ImageIcon("C:\\Users\\BhagyaWijeratne\\eclipse-workspace\\ProductivityApp\\Img\\Icon.png"));
        lblLogo.setBounds(199, 89, 190, 225);
        buttonPanel.add(lblLogo);
        frame.setVisible(true);
    }

	
	    
	  



		private void openToDoListFeature() {
		    try {
		    	ToDoList toDoListFrame = new ToDoList();
		    	toDoListFrame.setVisible(true);
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
	}
	    private void openExpenseFeature() {
		    try {
		        tracker trackerFrame = new tracker();
		        trackerFrame.setVisible(true);
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
	    }
	    private void openJournalFeature() {
		    try {
		    	MyJournal journalFrame = new MyJournal();
		    	journalFrame.setVisible(true);
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
	    }
	    private void openStudyTrackerFeature() {
		    try {
		    	StudyTrackerGUI studyTrackerFrame = new StudyTrackerGUI();
		    	studyTrackerFrame.setVisible(true);
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
	    }
	    private void opencustomProjectFeature() {
		    try {
		    	ProjectManagerGUI projectManagerGUIFrame = new ProjectManagerGUI();
		    	projectManagerGUIFrame.setVisible(true);
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
	    }
	    private void openEditFeature() {
		    try {
		    	Edit editFrame = new Edit();
		    	editFrame.setVisible(true);
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
	    }
}