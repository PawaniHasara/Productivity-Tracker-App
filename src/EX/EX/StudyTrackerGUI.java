package EX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class StudyTrackerGUI extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, ArrayList<StudySession>> studySessionsMap;
    private JFrame frame;
    private JTextArea textArea;

    private String currentSubject;
    private long currentStartTime;

    public StudyTrackerGUI() {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}catch (Exception e) {
	            System.out.println("Error occurred.");
	        }
        studySessionsMap = new HashMap<>();
        frame = new JFrame("Study Tracker");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(500,500);

        textArea = new JTextArea(15, 30);
        textArea.setBackground(new Color(255, 255, 224));
        textArea.setEditable(false);

        JButton startButton = new JButton("Start Study Session");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSubject = JOptionPane.showInputDialog("Enter the subject:");
                currentStartTime = System.currentTimeMillis();
                textArea.append("Started studying " + currentSubject + " at " + new java.util.Date(currentStartTime) + "\n");
            }
        });

        JButton endButton = new JButton("End Study Session");
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long endTime = System.currentTimeMillis();
                int durationMinutes = (int) ((endTime - currentStartTime) / 60000);
                ArrayList<StudySession> sessions = studySessionsMap.getOrDefault(currentSubject, new ArrayList<>());
                sessions.add(new StudySession(currentStartTime, endTime, currentSubject, durationMinutes));
                studySessionsMap.put(currentSubject, sessions);
                textArea.append("Ended studying " + currentSubject + " after " + durationMinutes + " minutes.\n");
            }
        });

        JButton displayButton = new JButton("Display Study Sessions");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Clear the text area
                for (String subject : studySessionsMap.keySet()) {
                    textArea.append("Subject: " + subject + "\n");
                    for (StudySession session : studySessionsMap.get(subject)) {
                        textArea.append("Start Time: " + new java.util.Date(session.getStartTime()) + "\n");
                        textArea.append("End Time: " + new java.util.Date(session.getEndTime()) + "\n");
                        textArea.append("Duration (minutes): " + session.getDurationMinutes() + "\n\n");
                    }
                }
            }
        });
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	exitApplication();    
           }
            private void exitApplication() {
				int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
			    
			    if (result == JOptionPane.YES_OPTION) {
			    	frame.dispose();
			    }
			}	
            
            
        });  

        JPanel panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        panel.add(startButton);
        panel.add(endButton);
        panel.add(displayButton);
        panel.add(exitButton);
        
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.setVisible(true);
        
    


		frame.setAlwaysOnTop(true);
        frame.setVisible(true);	
        
    }

	public void setVisible(boolean b) {
		
	}
}

class StudySession {
    private long startTime;
    private long endTime;
    private String subject;
    private int durationMinutes;

    public StudySession(long startTime, long endTime, String subject, int durationMinutes) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.subject = subject;
        this.durationMinutes = durationMinutes;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public String getSubject() {
        return subject;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }
}