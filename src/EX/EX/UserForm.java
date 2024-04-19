package EX;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class UserForm {

	protected JFrame frame;
	private JTextField usernameInput;
	private JPasswordField Inputpassword;
	
	protected Map<String, String> userDatabase;
	
	 // Launch the application.

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
            try {
                UserForm window = new UserForm();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
	}

	 // Create the application.
	 
	public UserForm() {
        userDatabase = UserDatabase.loadDatabase();
        initialize();
        
	}

    private void exitApplication() {
        UserDatabase.saveDatabase(userDatabase);
        System.exit(0);
    }
    
	 //Initialize the contents of the frame.
	 
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Productivity Manager Login");
		frame.setBounds(100, 100, 739, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitApplication();
            }
        });
        
		JPanel panel = new JPanel();
		panel.setBackground(new Color(224, 255, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUserName = new JLabel("Username:");
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUserName.setBounds(129, 121, 139, 44);
		panel.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBounds(129, 197, 139, 44);
		panel.add(lblPassword);
		
		usernameInput = new JTextField();
		usernameInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		usernameInput.setBounds(264, 121, 283, 34);
		panel.add(usernameInput);
		usernameInput.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

				try {
					// Open the RegistrationFrame and hide the Signin frame(frame)
					RegistrationForm window = new RegistrationForm(frame, userDatabase);             
					window.Registration.setVisible(true);
					}
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSignUp.setBackground(new Color(255, 255, 255));
		btnSignUp.setForeground(new Color(0, 0, 153));
		btnSignUp.setFont(new Font("Cambria", Font.PLAIN, 17));
		btnSignUp.setBounds(416, 294, 172, 49);
		panel.add(btnSignUp);
		
		Inputpassword = new JPasswordField();
		Inputpassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Inputpassword.setBounds(260, 204, 287, 34);
		panel.add(Inputpassword);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String username = usernameInput.getText();
                String password = new String(Inputpassword.getPassword());
                
                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(frame, "Logged in successfully!");
                    // add the code to open the main app window.
                    HomeApplication homeApplication = HomeApplication.getInstance();
                    frame.setVisible(false);// Hide the current frame

                    
    				try {
    					// Open the Main Menu and hide the Signin frame(frame)
    		            homeApplication.frame.setVisible(true);
    				}
    				catch (Exception e2) {
    					e2.printStackTrace();
    				}
    				
                } else {
                    JOptionPane.showMessageDialog(frame, "Login failed. Please try again.");
                }
			}
		});
		btnSignIn.setForeground(new Color(0, 0, 153));
		btnSignIn.setFont(new Font("Cambria", Font.PLAIN, 17));
		btnSignIn.setBackground(new Color(255, 255, 255));
		btnSignIn.setBounds(149, 294, 172, 49);
		panel.add(btnSignIn);
		
		JLabel lblSignUp = new JLabel("Don't have an account? \r\n");
		lblSignUp.setForeground(new Color(0, 0, 128));
		lblSignUp.setBackground(new Color(0, 0, 128));
		lblSignUp.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblSignUp.setBounds(410, 254, 294, 31);
		panel.add(lblSignUp);
		
		JLabel lblNewLabel = new JLabel("Productivity Tracker");
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(frame);
		lblNewLabel.setBounds(182, 45, 341, 65);
		panel.add(lblNewLabel);
		
		JLabel lblSyntaxSquad = new JLabel("Syntax Squad ");
		lblSyntaxSquad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSyntaxSquad.setForeground(new Color(0, 128, 128));
		lblSyntaxSquad.setFont(new Font("Ink Free", Font.BOLD, 20));
		lblSyntaxSquad.setBounds(556, 0, 208, 57);
		panel.add(lblSyntaxSquad);
		
		JLabel lblDevelopedBy = new JLabel("Developed by:");
		lblDevelopedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevelopedBy.setForeground(new Color(0, 0, 0));
		lblDevelopedBy.setFont(new Font("Ink Free", Font.BOLD, 10));
		lblDevelopedBy.setBounds(487, 7, 139, 44);
		panel.add(lblDevelopedBy);
		
        
	}
	
	
}
