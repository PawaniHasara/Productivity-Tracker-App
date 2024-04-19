package EX;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class tracker extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Map<String, List<Expense>> expensesByMonth;
    private JTextField monthTextField, descriptionTextField, amountTextField, yearTextField, dateTextField, timeTextField;
    private JTextArea resultTextArea;

    public tracker(Map<String, List<Expense>> expensesByMonth) {
        this.expensesByMonth = expensesByMonth;
        setTitle("Monthly Expenses Tracker");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JLabel monthLabel = new JLabel("  Month:");
        monthLabel.setHorizontalAlignment(SwingConstants.LEFT);
        JLabel descriptionLabel = new JLabel("  Expense Description:");
        JLabel amountLabel = new JLabel("  Expense Amount:");
        JLabel yearLabel = new JLabel("  Year:");
        JLabel dateLabel = new JLabel("  Expense Date (MM/DD):");
        JLabel timeLabel = new JLabel("  Expense Time (HH:MM):");

        monthTextField = new JTextField(15);
        descriptionTextField = new JTextField(15);
        amountTextField = new JTextField(15);
        yearTextField = new JTextField(15);
        dateTextField = new JTextField(15);
        timeTextField = new JTextField(15);

        JButton addExpenseButton = new JButton("Add Expense");
        JButton viewExpensesButton = new JButton("View Expenses");
        viewExpensesButton.setBackground(new Color(176, 224, 230));
        JButton exitButton = new JButton("Exit");
        JButton editExpenseButton = new JButton("Edit Expense");
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);

        JPanel inputPanel = new JPanel(new GridLayout(8, 2));
        
        inputPanel.add(yearLabel);
        inputPanel.add(yearTextField);
        inputPanel.add(monthLabel);
        inputPanel.add(monthTextField);
        inputPanel.add(dateLabel);
        inputPanel.add(dateTextField);
        inputPanel.add(timeLabel);
        inputPanel.add(timeTextField);
        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionTextField);
        inputPanel.add(amountLabel);
        inputPanel.add(amountTextField);
        inputPanel.add(addExpenseButton);
        inputPanel.add(viewExpensesButton);
        inputPanel.add(exitButton);
        inputPanel.add(editExpenseButton);
        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(resultTextArea), BorderLayout.CENTER);

        addExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
            }
        });

        viewExpensesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewExpenses();
            }
        });
    
    exitButton.addActionListener(new ActionListener() {
        @Override
      
        public void actionPerformed(ActionEvent e) {
        	exitApplication();
        }

        private void exitApplication() {
            int result = JOptionPane.showConfirmDialog(tracker.this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                dispose();
            }
        
		}

		
			
		
        });

    editExpenseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            editExpense();
        }
    });
}
    private void addExpense() {
        String month = monthTextField.getText();
        String description = descriptionTextField.getText();

        // Validate input values
        if (month == null || month.trim().isEmpty() || description == null || description.trim().isEmpty()) {
            resultTextArea.setText("Please enter valid month and description.");
            return;
        }

        try {
            double amount = Double.parseDouble(amountTextField.getText());
            int year = Integer.parseInt(yearTextField.getText());
            String date = dateTextField.getText();
            String time = timeTextField.getText();

            System.out.println("Debug: Values used for Expense creation - Description: " + description + ", Amount: " + amount +
                    ", Year: " + year + ", Date: " + date + ", Time: " + time);

            Expense expense = new Expense(description, amount, year, date, time);

            // Ensure the month is not null
            if (!expensesByMonth.containsKey(month)) {
                expensesByMonth.put(month, new ArrayList<>());
            }

            expensesByMonth.get(month).add(expense);
            resultTextArea.setText("Expense added successfully for " + month);
        } catch (NumberFormatException e) {
            resultTextArea.setText("Please enter valid numeric values for amount and year.");
        } catch (Exception e) {
            resultTextArea.setText("An error occurred while adding the expense. Please check your input.");
        }
    }

    private void viewExpenses() {
        String viewMonth = monthTextField.getText();

        if (viewMonth == null || viewMonth.isEmpty()) {
            
            resultTextArea.setText("Please enter a valid month.");
            return;
        }

        if (!expensesByMonth.containsKey(viewMonth)) {
            resultTextArea.setText("No expenses recorded for " + viewMonth);
            return;
        }

        List<Expense> expenses = expensesByMonth.get(viewMonth);
        displayExpenses(expenses, viewMonth);
    }
    

    private void displayExpenses(List<Expense> expenses, String viewMonth) {
        if (expenses == null || expenses.isEmpty()) {
            resultTextArea.setText("No expenses for " + viewMonth + " to display.");
        } else {
            StringBuilder sb = new StringBuilder("Expenses for " + viewMonth + ":\n");
            for (int i = 0; i < expenses.size(); i++) {
                Expense exp = expenses.get(i);

                sb.append(String.format("%d. %s: $%.2f, Year: %d, Date: %s, Time: %s%n",
                        i + 1,
                        exp.getDescription() == null ? "null" : exp.getDescription(),
                        exp.getAmount(),
                        exp.getYear(),
                        exp.getDate() == null ? "null" : exp.getDate(),
                        exp.getTime() == null ? "null" : exp.getTime()));
            }
            resultTextArea.setText(sb.toString());
        }
    }
    private void editExpense() {
        String viewMonth = monthTextField.getText();

        if (viewMonth == null || viewMonth.isEmpty() || !expensesByMonth.containsKey(viewMonth)) {
            resultTextArea.setText("Please enter a valid month with expenses to edit.");
            return;
        }

        List<Expense> expenses = expensesByMonth.get(viewMonth);

        if (expenses.isEmpty()) {
            resultTextArea.setText("No expenses for " + viewMonth + " to edit.");
            return;
        }

        
        String[] expenseOptions = new String[expenses.size()];
        for (int i = 0; i < expenses.size(); i++) {
            expenseOptions[i] = String.format("%d. %s: $%.2f, Year: %d, Date: %s, Time: %s%n", i + 1,
                    expenses.get(i).getDescription(), expenses.get(i).getAmount(), expenses.get(i).getYear(),
                    expenses.get(i).getDate(), expenses.get(i).getTime());
        }

        String selectedExpense = (String) JOptionPane.showInputDialog(this, "Select an expense to edit:", "Edit Expense",
                JOptionPane.PLAIN_MESSAGE, null, expenseOptions, expenseOptions[0]);

        if (selectedExpense != null) {
            int selectedIndex = Integer.parseInt(selectedExpense.split("\\.")[0]) - 1;

           
            Expense editedExpense = editExpenseDetails(expenses.get(selectedIndex));

            expenses.set(selectedIndex, editedExpense);
            resultTextArea.setText("Expense edited successfully for " + viewMonth);
        }
    }

    private Expense editExpenseDetails(Expense expense) {
        

        String newDescription = JOptionPane.showInputDialog("Enter new description:", expense.getDescription());
        double newAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter new amount:", expense.getAmount()));
        int newYear = Integer.parseInt(JOptionPane.showInputDialog("Enter new year:", expense.getYear()));
        String newDate = JOptionPane.showInputDialog("Enter new date (MM/DD):", expense.getDate());
        String newTime = JOptionPane.showInputDialog("Enter new time (HH:MM):", expense.getTime());

        return new Expense(newDescription, newAmount, newYear, newDate, newTime);
    }
    

        public tracker() {
        	setBackground(new Color(224, 255, 255));
    		
    		try {
    			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    			}catch (Exception e) {
    	            System.out.println("Error occurred.");
    	        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Map<String, List<Expense>> expensesByMonth = new HashMap<>();
                tracker frame = new tracker(expensesByMonth);
                frame.setVisible(true);
            }
        });
    }
		public JFrame getFrame() {
			return frame;
		}
		public void setFrame(JFrame frame) {
			this.frame = frame;
		}
}
