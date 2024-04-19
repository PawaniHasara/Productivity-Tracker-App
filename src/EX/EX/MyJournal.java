package EX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Date;

public class MyJournal {

    public static class JournalEntry {
        private Date date;
        private String entryText;

        public JournalEntry(Date date, String entryText) {
            this.date = date;
            this.entryText = entryText;
        }

        public Date getDate() {
            return date;
        }

        public String getEntryText() {
            return entryText;
        }

		public void setEntryText(String editedText) {
						
		}
    }

    private ArrayList<JournalEntry> entries = new ArrayList<>();
    private JFrame frame;
    private JPanel entryPanel; // Create a separate panel for entries

    public MyJournal() {
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}catch (Exception e) {
	            System.out.println("Error occurred.");
	        }
        frame = new JFrame("MY JOURNAL");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setSize(444, 145);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        entryPanel = new JPanel();
        entryPanel.setBackground(new Color(255, 255, 224));
        entryPanel.setLayout(new BoxLayout(entryPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(entryPanel);

        frame.getContentPane().add(mainPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        JTextField entryField = new JTextField();
        entryField.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Set the placeholder
        entryField.setForeground(Color.GRAY);
        entryField.setText("Enter your journal entry...");

        // Add focus listener to clear placeholder when focused
        entryField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (entryField.getText().equals("Enter your journal entry...")) {
                    entryField.setText("");
                    entryField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (entryField.getText().isEmpty()) {
                    entryField.setForeground(Color.GRAY);
                    entryField.setText("Enter your journal entry...");
                }
            }
        });

        inputPanel.add(entryField, BorderLayout.CENTER);

        JButton addButton = new JButton("Add Entry");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEntry(entryField.getText());
                entryField.setText("");
                entryField.setForeground(Color.GRAY);
                entryField.setText("Enter your journal entry..."); // Reset placeholder
            }
        }); 
        
        JButton exitJournalButton = new JButton("Exit Journal");
        exitJournalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitJournal();
            }

			
        });
          
        
       inputPanel.add(exitJournalButton, BorderLayout.EAST);
        
        inputPanel.add(addButton, BorderLayout.WEST);

        mainPanel.add(inputPanel, BorderLayout.SOUTH);
        
        // Display existing entries when the journal is created
        displayEntries();

        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        
}
        private void exitJournal() {
            int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit the journal?", "Exit Journal Confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                frame.dispose();
            }
    
        }
    private void addEntry(String text) {
        if (!text.isEmpty()) {
            JournalEntry entry = new JournalEntry(new Date(), text);
            entries.add(entry);
            displayEntries();
        }
    }

    private void displayEntries() {
        entryPanel.removeAll(); // Clear existing entries

        for (int i = 0; i < entries.size(); i++) {
            JournalEntry entry = entries.get(i);

            JTextArea entryText = new JTextArea(entry.getDate() + "\n" + entry.getEntryText());
            entryText.setEditable(false);
            entryText.setLineWrap(true);  // Enable line wrap
            entryText.setWrapStyleWord(true);  // Wrap at word boundaries
            entryPanel.add(entryText);

            JButton editButton = new JButton("Edit");
            editButton.addActionListener(new EditButtonListener(i));
            entryPanel.add(editButton);

            JButton deleteButton = new JButton("Delete");
            deleteButton.addActionListener(new DeleteButtonListener(i));
            entryPanel.add(deleteButton);
        }

        frame.revalidate();
        frame.repaint();
 
    }

    private class EditButtonListener implements ActionListener {
        private int index;

        public EditButtonListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String editedText = JOptionPane.showInputDialog(frame, "Edit the entry:", entries.get(index).getEntryText());
            if (editedText != null) {
                entries.get(index).setEntryText(editedText);
                displayEntries();
            }
        }
    }

    private class DeleteButtonListener implements ActionListener {
        private int index;

        public DeleteButtonListener(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to delete this entry?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                entries.remove(index);
                displayEntries();
            }
        }
    }

	public void setVisible(boolean b) {
		
	}
}
