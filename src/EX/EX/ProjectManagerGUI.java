package EX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProjectManagerGUI extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
    private JTextField taskNameField;
    private JTextField startDateField;
    private JTextField dueDateField;
    private JTextArea commentArea;
    private JComboBox<String> priorityComboBox;
    private JComboBox<String> statusComboBox;
    private JTextField reminderTimeField;
    private JTextArea attachmentsArea;
    private List<Project> projects;
    
   

    


    public ProjectManagerGUI() {
    	
    		
    		try {
    			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    			}catch (Exception e) {
    	            System.out.println("Error occurred.");
    	        }
        frame = new JFrame("Customer Project Manager");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(400, 400);

        projects = new ArrayList<>();

        JLabel titleLabel = new JLabel("Add Customer Project");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 15));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel taskLabel = new JLabel("  Task Name:");
        taskNameField = new JTextField(20);

        JLabel startDateLabel = new JLabel("  Start Date:");
        startDateField = new JTextField(20);

        JLabel dueDateLabel = new JLabel("  Due Date:");
        dueDateField = new JTextField(20);

        JLabel commentLabel = new JLabel("  Comment:");
        commentArea = new JTextArea(5, 20);
        commentArea.setLineWrap(true);

        JLabel priorityLabel = new JLabel("  Priority:");
        String[] priorities = {"High", "Medium", "Low"};
        priorityComboBox = new JComboBox<>(priorities);

        JLabel statusLabel = new JLabel("  Status:");
        String[] statuses = {"Not Started", "In Progress", "Completed"};
        statusComboBox = new JComboBox<>(statuses);

        JLabel reminderTimeLabel = new JLabel("  Reminder Time (in days):");
        reminderTimeField = new JTextField(20);

        JLabel attachmentsLabel = new JLabel("  Attachments (comma-separated):");
        attachmentsArea = new JTextArea(3, 20);
        attachmentsArea.setLineWrap(true);

        JButton addButton = new JButton("Add Project");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProject();
            }
        });

        JButton displayButton = new JButton("Display Projects");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayProjects();
            }
        });
        JButton btnNewButton = new JButton("Exit");
        btnNewButton.addActionListener(new ActionListener() {
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
        panel.setLayout(new GridLayout(11, 2));
        panel.add(titleLabel);
        panel.add(new JLabel(""));
        panel.add(taskLabel);
        panel.add(taskNameField);
        panel.add(startDateLabel);
        panel.add(startDateField);
        panel.add(dueDateLabel);
        panel.add(dueDateField);
        panel.add(commentLabel);
        panel.add(new JScrollPane(commentArea));
        panel.add(priorityLabel);
        panel.add(priorityComboBox);
        panel.add(statusLabel);
        panel.add(statusComboBox);
        panel.add(reminderTimeLabel);
        panel.add(reminderTimeField);
        panel.add(attachmentsLabel);
        panel.add(new JScrollPane(attachmentsArea));
        panel.add(new JLabel(""));
        panel.add(addButton);
        panel.add(displayButton);
        panel.add(btnNewButton);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

    }
    
    
    

   




    private void addProject() {
        try {
            String taskName = taskNameField.getText();
            String startDate = startDateField.getText();
            String dueDate = dueDateField.getText();
            String comment = commentArea.getText();
            String priority = (String) priorityComboBox.getSelectedItem();
            String status = (String) statusComboBox.getSelectedItem();
            int reminderTime = Integer.parseInt(reminderTimeField.getText());
            String attachments = attachmentsArea.getText();

            Project project = new Project(taskName, startDate, dueDate, comment, priority, status, reminderTime, attachments);
            projects.add(project);

            JOptionPane.showMessageDialog(frame, "Project added successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number for Reminder Time.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	    
    private void displayProjects() {
        StringBuilder projectList = new StringBuilder("Project List:\n");

        for (Project project : projects) {
            projectList.append("Task Name: ").append(project.getTaskName()).append("\n");
            projectList.append("Start Date: ").append(project.getStartDate()).append("\n");
            projectList.append("Due Date: ").append(project.getDueDate()).append("\n");
            projectList.append("Comment: ").append(project.getComment()).append("\n");
            projectList.append("Priority: ").append(project.getPriority()).append("\n");
            projectList.append("Status: ").append(project.getStatus()).append("\n");
            projectList.append("Reminder Time: ").append(project.getReminderTime()).append("\n");
            projectList.append("Attachments: ").append(project.getAttachments()).append("\n");
            projectList.append("\n");
        }
        JTextArea projectListArea = new JTextArea(10, 40);
        projectListArea.setText(projectList.toString());
        projectListArea.setEditable(false);

        JOptionPane.showMessageDialog(frame, new JScrollPane(projectListArea), "Project List", JOptionPane.INFORMATION_MESSAGE);
    

    
        
        
    }

    public static class Project {
        private String taskName;
        private String startDate;
        private String dueDate;
        private String comment;
        private String priority;
        private String status;
        private int reminderTime;
        private String attachments;

        public Project(String taskName, String startDate, String dueDate, String comment, String priority, String status, int reminderTime, String attachments) {
            this.taskName = taskName;
            this.startDate = startDate;
            this.dueDate = dueDate;
            this.setComment(comment);
            this.setPriority(priority);
            this.setStatus(status);
            this.setReminderTime(reminderTime);
            this.setAttachments(attachments);
        }

        
        public String getTaskName() {
            return taskName;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getDueDate() {
            return dueDate;
        }

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getReminderTime() {
			return reminderTime;
		}

		public void setReminderTime(int reminderTime) {
			this.reminderTime = reminderTime;
		}

		public String getAttachments() {
			return attachments;
		}

		public void setAttachments(String attachments) {
			this.attachments = attachments;
		}
    }
}